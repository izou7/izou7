package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.CommunityMemberDao;
import cn.chinattclub.izou7.entity.CommunityMember;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.CommunityMemberService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.chinattclub.izou7.web.ActivityController;
import cn.zy.commons.webdev.vo.Page;

/**
 * 社区成员服务类
 *
 * @author zhangying.
 *         Created 2015-3-2.
 */
@Service
public class CommunityMemberServiceImpl  implements CommunityMemberService {

	@Resource
	private CommunityMemberDao dao;
	
	private static final Logger log = LoggerFactory.getLogger(CommunityMemberServiceImpl.class);

	@Override
	public List<CommunityMember> findCommunityMember(Page page,int communityId) {
		// TODO Auto-generated method stub.
		page.setRecordCount(dao.findMemberCount(communityId));
		return dao.findMember(page,communityId);
	}

	@Override
	public void deleteMember(int id) {
		// TODO Auto-generated method stub.
		dao.delete(id);
		//删除他在这个的所说的话
	}

	@Override
	public void passMember(int id) {
		// TODO Auto-generated method stub.
		CommunityMember member = dao.get(id);
		User user = member.getCommunity().getAdmin();
		if(user.getId()==CommonUtil.getCurrentUser().getId()){
			member.setStatus(1);
			dao.update(member);
		}else{
			log.warn(user.getUsername()+"有盗链行为，请注意！");
		}
	}
	
}
