package cn.chinattclub.izou7.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityDao;
import cn.chinattclub.izou7.dao.PublicDao;
import cn.chinattclub.izou7.dto.PublicDto;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.Article;
import cn.chinattclub.izou7.entity.Public;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.PublicService;
import cn.chinattclub.izou7.util.CommonUtil;
/**
 * 活动业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class PublicServiceImpl implements PublicService {
	
	@Resource
	public PublicDao dao;

	@Resource
	public ActivityDao activityDao;

	List<Article> getArticlesFromPublic(PublicDto dto){
		List<Article> articles = new ArrayList<Article>();
		//////////todo////////////
		return articles;
	}
	
	Public getEntityFromFDto(PublicDto dto){
		Public pub = new Public();
		
		pub.setWechatId(dto.getWechatId());
		pub.setPublicName(dto.getPublicName());
		pub.setTags(dto.getTags());
		pub.setDescription(dto.getDescription());
		pub.setMine(dto.isMine());
		pub.setCreateTime(new Date());
		pub.setUpdateTime(new Date());
		
		List<Article> article = getArticlesFromPublic(dto);
		pub.setArticle(article);
		
		return pub;
	}
	
	@Override
	public void importPublic(PublicDto dto) {
		
		Public pub = getEntityFromFDto(dto);
		dao.save(pub);
		
	}

	@Override
	public List<Public> listPublic(User user) {
		
		List<Public> list = dao.listByUser(user);
		return list;
	}

	@Override
	public void deletePublic(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Public getPublicById(int publicId) {
		return dao.get(publicId);
	}

	@Override
	public List<Public> recommend(Integer activityId) {
		// TODO Auto-generated method stub
		Activity act = activityDao.get(activityId);
		String[] tags = act.getTags().split(",");
		return dao.recommend(tags);
	}

	@Override
	public void save(Public publicObj) {
		// TODO Auto-generated method stub.
		dao.save(publicObj);
	}

	@Override
	public boolean validate(String wechatId) {
		// TODO Auto-generated method stub.
		User user = CommonUtil.getCurrentUser();
		List<Public> publicList = listPublic(user);
		for (Public publicObj : publicList) {
			if(publicObj.getWechatId().equals(wechatId)){
				return false;
			}
		}
		return true;
	}
	
}
