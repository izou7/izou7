package cn.chinattclub.izou7.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityDao;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.service.ActivityService;
/**
 * 活动业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	@Resource
	private ActivityDao activityDao;
	
	@Override
	public Activity findById(int id) {
		// TODO Auto-generated method stub
		return activityDao.get(id);
	}

	@Override
	public void update(Activity activity) {
		// TODO Auto-generated method stub
		activityDao.update(activity);
	}
	
	@Override
	public void add(Activity activity){
		activityDao.save(activity);
	}
}
