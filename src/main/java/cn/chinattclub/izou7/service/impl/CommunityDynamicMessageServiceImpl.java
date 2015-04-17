package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.CommunityDynamicMessageDao;
import cn.chinattclub.izou7.entity.CommunityDynamicMessage;
import cn.chinattclub.izou7.service.CommunityDynamicMessageService;

/**
 * 社区服务类
 *
 * @author zhangying.
 *         Created 2015-3-2.
 */
@Service
public class CommunityDynamicMessageServiceImpl  implements CommunityDynamicMessageService {

	@Resource
	private CommunityDynamicMessageDao dao;

	@Override
	public List<CommunityDynamicMessage> findMessage(int dynamicId) {
		// TODO Auto-generated method stub.
		String hql = "from CommunityDynamicMessage m where m.communityDynamic.id=?";
		return dao.findByHQL(hql,0,0,dynamicId);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub.
		dao.delete(id);
	}

	@Override
	public CommunityDynamicMessage findById(int id) {
		// TODO Auto-generated method stub.
		return dao.get(id);
	}

}
