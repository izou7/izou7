package cn.chinattclub.izou7.service;

import cn.chinattclub.izou7.entity.ActivityTicket;


/**
 * 活动票务业务接口类
 */
public interface ActivityTicketService {

	/**
	 * 
	 * @param activityId
	 * @return
	 */
	public ActivityTicket findByActivityId(int activityId);
}
