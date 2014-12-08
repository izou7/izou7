package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.ActivityArticle;

/*
 * 
 *@Title:
 *@Description:
 *@Author:ZY
 *@Since:2014-11-9
 *@Version:1.1.0
 */
public interface ActivityArticleService {

	public List<ActivityArticle> findArticlesById(int id);

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param article
	 */
	public void add(ActivityArticle article);

	/**
	 * 删除文章
	 * 
	 * @param articleId
	 */
	public void delete(int articleId);

	/**
	 * 验证文章数量
	 *
	 * @param article
	 */
	public boolean validateNum(ActivityArticle article);
}
