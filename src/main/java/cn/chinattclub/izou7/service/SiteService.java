package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.Site;



/**
 * 
 * 场地业务逻辑类
 *
 * @author zhangying.
 *         Created 2015-01-31.
 */
public interface SiteService {

	public List<Site> list();
	
	public void save(Site site);
	
	public void update(Site site);
	
}
