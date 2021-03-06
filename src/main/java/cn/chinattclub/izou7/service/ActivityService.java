package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.dto.ActivityQueryDto;
import cn.chinattclub.izou7.entity.Activity;
import cn.zy.commons.webdev.vo.Page;

/**
 * 活动业务逻辑接口
 * 
 * @author ZY
 * 
 */
public interface ActivityService {

	public Activity findById(int id);

	public void update(Activity activity);

	void add(Activity activity);

	public List<Activity> getUnfixedActivity();

//	public List<Activity> findActivitys(Page page, int id, int status);

	public void delete(int activityId);

	/**
	 * 
	 * 获取活动及活动级联内容
	 * 
	 * @param activityId
	 * @return
	 */
	public Activity findALLById(int activityId);

	List<Activity> findActivitys(Page page, ActivityQueryDto query);

}
