package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.SiteDao;
import cn.chinattclub.izou7.dao.TagDao;
import cn.chinattclub.izou7.entity.Site;
import cn.chinattclub.izou7.entity.Sponsor;
import cn.chinattclub.izou7.entity.Tag;
import cn.chinattclub.izou7.service.SiteService;
import cn.chinattclub.izou7.service.TagService;

/*
 * 场地业务逻辑类
 * @author ZY
 *
 */
@Service("siteService")
public class SiteServiceImpl implements SiteService {
	
	@Resource
    private SiteDao siteDao;

	@Override
	public List<Site> list() {
		// TODO Auto-generated method stub
		return siteDao.list();
	}

	@Override
	public void save(Site site) {
		// TODO Auto-generated method stub
		siteDao.save(site);
	}

	@Override
	public void update(Site site) {
		// TODO Auto-generated method stub
		siteDao.update(site);
	}


	
}
