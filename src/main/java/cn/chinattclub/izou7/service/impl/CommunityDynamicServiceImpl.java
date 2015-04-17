package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.CommunityDao;
import cn.chinattclub.izou7.dao.CommunityDynamicDao;
import cn.chinattclub.izou7.entity.Community;
import cn.chinattclub.izou7.entity.CommunityDynamic;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.CommunityDynamicService;
import cn.chinattclub.izou7.service.CommunityService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.vo.Page;

/**
 * 社区服务类
 *
 * @author zhangying.
 *         Created 2015-3-2.
 */
@Service
public class CommunityDynamicServiceImpl  implements CommunityDynamicService {

	@Resource
	private CommunityDynamicDao dao;

	@Override
	public List<CommunityDynamic> findDynamics(Page page, int communityId,
			String content) {
		// TODO Auto-generated method stub.
		page.setRecordCount(dao.findDynamicsCount(communityId,content));
		return dao.findDynamics(page,communityId,content);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub.
		dao.delete(id);
	}

	@Override
	public CommunityDynamic findById(int id) {
		// TODO Auto-generated method stub.
		return dao.get(id);
	}
	
	

	

}
