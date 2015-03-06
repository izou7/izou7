package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.CommunityMemberDao;
import cn.chinattclub.izou7.entity.CommunityMember;
import cn.chinattclub.izou7.service.CommunityMemberService;
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
	
}
