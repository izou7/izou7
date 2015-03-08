package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.Community;



public interface CommunityService {

	public List<Community> getMyCommunities();
	
	public void add(Community community);
	
	public void update(Community community);
	
	public Community findById(int id);
	
	public void delete(int id);
}
