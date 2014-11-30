package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityCooperationDao;
import cn.chinattclub.izou7.entity.ActivityCooperation;
import cn.chinattclub.izou7.service.ActivityCooperationService;
/**
 * 活动合作业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityCooperationServiceImpl implements ActivityCooperationService {

	@Resource 
	private ActivityCooperationDao dao;
	
	@Override
	public List<ActivityCooperation> findByActivityId(int activityId) {
		// TODO Auto-generated method stub
		return dao.findByActivityId(activityId);
	}

	@Override
	public void add(ActivityCooperation cooperation) {
		// TODO Auto-generated method stub
		 dao.save(cooperation);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	
}
