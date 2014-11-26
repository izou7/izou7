package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityGuestsDao;
import cn.chinattclub.izou7.dao.ActivityGuestsSettingDao;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityGuests;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.service.ActivityGuestsService;
import cn.chinattclub.izou7.service.ActivityGuestsSettingService;

/**
 * 用户业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityGuestsServiceImpl implements ActivityGuestsService {
	@Resource
    private ActivityGuestsDao activityGuestsDao;

	@Override
	public List<ActivityGuests> getFixedGuests(Activity activity) {
		return activityGuestsDao.getFixedGuests(activity);
	}
	
	@Override
	public List<ActivityGuests> getSendingGuests(Activity activity) {
		return activityGuestsDao.getSendingGuests(activity);
	}

	@Override
	public List<ActivityGuests> getWaitingGuests(Activity activity) {
		return activityGuestsDao.getWaitingGuests(activity);
	}

	@Override
	public void update(ActivityGuests sendingGuest) {
		activityGuestsDao.update(sendingGuest);
	}
	
}
