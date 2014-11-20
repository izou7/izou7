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
}
