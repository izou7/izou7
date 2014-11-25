package cn.chinattclub.izou7.service;


import java.util.List;

import cn.chinattclub.izou7.entity.ActivityGuests;
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

	public List<ActivityGuests> getFixedGuests(ActivityGuestsSetting activityGuestsSetting);
	
	public List<ActivityGuests> getSendingGuests(ActivityGuestsSetting activityGuestsSetting);

	public List<ActivityGuests> getWaitingGuests(ActivityGuestsSetting activityGuestsSetting);

	public void update(ActivityGuests sendingGuest);
	
}
