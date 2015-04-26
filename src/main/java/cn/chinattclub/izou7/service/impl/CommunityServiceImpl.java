package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.CommunityDao;
import cn.chinattclub.izou7.entity.Community;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.CommunityService;
import cn.chinattclub.izou7.util.CommonUtil;

/**
 * 社区服务类
 *
 * @author zhangying.
 *         Created 2015-3-2.
 */
@Service
public class CommunityServiceImpl  implements CommunityService {

	@Resource
	private CommunityDao dao;
	
	@Override
	public List<Community> getMyCommunities() {
		// TODO Auto-generated method stub.
		User user = CommonUtil.getCurrentUser();
		String hql = "from Community c where c.admin.id=? and c.enable=1 order by c.createTime desc";
		return dao.findByHQL(hql,0,0,user.getId());
	}
	
	@Override
	public void add(Community community) {
		// TODO Auto-generated method stub.
		dao.save(community);
	}

	@Override
	public void update(Community community) {
		// TODO Auto-generated method stub.
		dao.update(community);
	}

	@Override
	public Community findById(int id) {
		// TODO Auto-generated method stub.
		return dao.get(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub.
		Community cmt = this.findById(id);
		cmt.setEnable(false);
		cmt.setPhone("15245698520");
		cmt.setRealName("sb");
		dao.update(cmt);
	}

	

}
