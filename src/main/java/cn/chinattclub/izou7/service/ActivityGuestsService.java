package cn.chinattclub.izou7.service;


import java.util.List;

import cn.chinattclub.izou7.entity.Activity;
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

	public List<ActivityGuests> getFixedGuests(Activity activity);
	
	public List<ActivityGuests> getSendingGuests(Activity activity);

	public List<ActivityGuests> getWaitingGuests(Activity activity);

	public void update(ActivityGuests sendingGuest);
	
}
