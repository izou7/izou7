package cn.chinattclub.izou7.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.PublicDao;
import cn.chinattclub.izou7.dto.PublicDto;
import cn.chinattclub.izou7.entity.Article;
import cn.chinattclub.izou7.entity.Public;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.PublicService;
/**
 * 活动业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class PublicServiceImpl implements PublicService {

	@Resource
	public PublicDao publicDao;

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
		publicDao.save(pub);
		
	}

	@Override
	public List<Public> listPublic(User user) {
		
		List<Public> list = publicDao.listByUser(user);
		return list;
	}

	@Override
	public void deletePublic(int id) {
		// TODO Auto-generated method stub
		publicDao.delete(id);
	}

	@Override
	public Public getPublicById(int publicId) {
		return publicDao.get(publicId);
	}
	
}
