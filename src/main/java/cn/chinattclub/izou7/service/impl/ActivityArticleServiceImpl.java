package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityArticleDao;
import cn.chinattclub.izou7.entity.ActivityArticle;
import cn.chinattclub.izou7.service.ActivityArticleService;
/**
 * 文章业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityArticleServiceImpl implements ActivityArticleService {

	@Resource
	private ActivityArticleDao dao;
	
	@Override
	public List<ActivityArticle> findArticlesById(int id) {
		// TODO Auto-generated method stub.
		return dao.findByHQL("from ActivityArticle as art where art.activity.id=?",0,1000,id);
	}
	
}
