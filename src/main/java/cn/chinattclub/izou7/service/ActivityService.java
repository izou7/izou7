package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.Activity;

/**
 * 活动业务逻辑接口
 * @author ZY
 *
 */
public interface ActivityService {
	
	public Activity findById(int id);
	
	public void update(Activity activity);

	void add(Activity activity);

	public List<Activity> getUnfixedActivity();

	public List<Activity> getDeployedActivity(Integer id);

	public List<Activity> getWaitActivity(Integer id);

}
