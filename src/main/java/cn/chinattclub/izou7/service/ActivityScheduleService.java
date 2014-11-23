package cn.chinattclub.izou7.service;

import java.util.Date;
import java.util.List;

import cn.chinattclub.izou7.entity.ActivitySchedule;

/**
 * 日程业务接口类
 */
public interface ActivityScheduleService {

	public List<ActivitySchedule> findById(int id);
	/**
	 * 附带查询条件的查询
	 * @param id
	 * @param start
	 * @param end
	 * @return
	 */
	public List<ActivitySchedule> find(int id,Date start,Date end);

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param article
	 */
	public void add(ActivitySchedule schedule);

	/**
	 * 删除日程
	 * 
	 * @param articleId
	 */
	public void delete(int id);
	/**
	 * 获取日程
	 * @param id
	 * @return
	 */
	public ActivitySchedule get(int id);
	/**
	 * 更新日程
	 * @param as
	 */
	public void update(ActivitySchedule as);
}
