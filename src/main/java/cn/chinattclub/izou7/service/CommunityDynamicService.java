package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.CommunityDynamic;
import cn.zy.commons.webdev.vo.Page;




/**
 *动态服务类
 *
 * @author zhangying.
 *         Created 2015-3-5.
 */
public interface CommunityDynamicService {

	public List<CommunityDynamic> findDynamics(Page page, int communityId,
			String content);

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param id
	 */
	public void delete(Integer id);
	
	public CommunityDynamic findById(int id);

}
