package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.ActivityCooperation;


/**
 * 活动合作业务类
 * @author ZY
 *
 */
public interface ActivityCooperationService {

	public List<ActivityCooperation> findByActivityId(int activityId);

	public void add(ActivityCooperation cooperation);

	public void delete(int id);


}
