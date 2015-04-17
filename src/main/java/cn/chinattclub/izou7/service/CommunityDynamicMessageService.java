package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.CommunityDynamicMessage;




/**
 *动态留言服务类
 *
 * @author zhangying.
 *         Created 2015-3-5.
 */
public interface CommunityDynamicMessageService {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param dynamicId
	 * @return
	 */
	public List<CommunityDynamicMessage> findMessage(int dynamicId);

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param id
	 */
	public void delete(Integer id);
	
	public CommunityDynamicMessage findById(int id);


}
