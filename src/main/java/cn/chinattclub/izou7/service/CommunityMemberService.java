package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.CommunityMember;
import cn.zy.commons.webdev.vo.Page;



public interface CommunityMemberService {

	public List<CommunityMember> findCommunityMember(Page page,int communityId);
	
	public void deleteMember(int id);
	
	public void execPassMember(int id,int pass);
}
