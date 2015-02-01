package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.SiteDao;
import cn.chinattclub.izou7.dao.SponsorDao;
import cn.chinattclub.izou7.dao.TagDao;
import cn.chinattclub.izou7.entity.Site;
import cn.chinattclub.izou7.entity.Sponsor;
import cn.chinattclub.izou7.entity.Tag;
import cn.chinattclub.izou7.service.SiteService;
import cn.chinattclub.izou7.service.SponsorService;
import cn.chinattclub.izou7.service.TagService;

/*
 * 赞助商业务逻辑类
 * @author ZY
 *
 */
@Service("sponsorService")
public class SponsorServiceImpl implements SponsorService {
	
	@Resource
    private SponsorDao dao;

	@Override
	public List<Sponsor> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public void save(Sponsor sponsor) {
		// TODO Auto-generated method stub
		dao.save(sponsor);
	}

	@Override
	public void update(Sponsor sponsor) {
		// TODO Auto-generated method stub
		dao.update(sponsor);
	}



	
}
