package cn.chinattclub.izou7.service.impl;

import java.util.List;

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
	private ActivityDao dao;
	
	@Override
	public Activity findById(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public void update(Activity activity) {
		// TODO Auto-generated method stub
		dao.update(activity);
	}
	
	public void add(Activity activity){
		dao.save(activity);
	}

	@Override
	public List<Activity> getUnfixedActivity() {
		// TODO Auto-generated method stub
		return dao.getUnfixedActivity();
	}

	@Override
	public List<Activity> getDeployedActivity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getWaitActivity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
