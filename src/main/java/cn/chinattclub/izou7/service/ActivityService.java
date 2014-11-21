package cn.chinattclub.izou7.service;

import cn.chinattclub.izou7.entity.Activity;

/**
 * 活动业务逻辑接口
 * @author ZY
 *
 */
public interface ActivityService {
	
	/**
	 * 根据ID查询活动
	 * @param id
	 * @return
	 */
	public Activity findById(int id);
	
	/**
	 * 更新活动
	 * @param activity
	 */
	public void update(Activity activity);

}
