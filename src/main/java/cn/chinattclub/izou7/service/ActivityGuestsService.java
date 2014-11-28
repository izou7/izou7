package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityGuest;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.entity.User;

/*
 * 
 *@Title:
 *@Description:
 *@Author:ZY
 *@Since:2014-11-9
 *@Version:1.1.0
 */
public interface ActivityGuestsService {

	public List<ActivityGuest> getFixedGuests(Activity activity);

	public List<ActivityGuest> getSendingGuests(Activity activity);

	public List<ActivityGuest> getWaitingGuests(Activity activity);

	public void update(ActivityGuest sendingGuest);

	/**
	 * 调整嘉宾顺序
	 * 
	 * @param activityId
	 * @param guestId
	 * @param up
	 */
	public void execSequence(int activityId, int guestId, boolean up);

	public void add(ActivityGuest aGuest);

	/**
	 * 计算最大排名
	 * 
	 * @param activityId
	 * @return
	 */
	public int getMaxRank(int activityId);

}