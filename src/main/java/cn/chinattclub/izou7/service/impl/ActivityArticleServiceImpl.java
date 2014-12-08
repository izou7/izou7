package cn.chinattclub.izou7.service.impl;

import java.util.List;
import java.util.Properties;

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
	
	@Resource
	private Properties appConfig;
	
	@Override
	public List<ActivityArticle> findArticlesById(int id) {
		// TODO Auto-generated method stub.
		return dao.findByHQL("from ActivityArticle as art where art.activity=?",0,1000,id);
	}

	@Override
	public void add(ActivityArticle article) {
		// TODO Auto-generated method stub.
		dao.save(article);
	}

	@Override
	public void delete(int articleId) {
		// TODO Auto-generated method stub
		dao.delete(articleId);
	}

	@Override
	public boolean validateNum(ActivityArticle article) {
		// TODO Auto-generated method stub.
		List<ActivityArticle> articles = findArticlesById(article.getActivity());
		if(articles!=null&&articles.size()>=Integer.parseInt(appConfig.get("maxArticles").toString())){
			return false;
		}
		return true;
	}
	
}
