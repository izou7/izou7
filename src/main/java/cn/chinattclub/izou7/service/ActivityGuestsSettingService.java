package cn.chinattclub.izou7.service;


import java.util.List;

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
public interface ActivityGuestsSettingService {

	public List<ActivityGuestsSetting> getUnfixedActivity();

	public void update(ActivityGuestsSetting activityGuestsSetting);

	public void addOrUpdate(ActivityGuestsSetting setting);
}
