package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityGuestsDao;
import cn.chinattclub.izou7.dao.ActivityGuestsSettingDao;
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
	public List<ActivityGuests> getFixedGuests(ActivityGuestsSetting activityGuestsSetting) {
		return activityGuestsDao.getFixedGuests(activityGuestsSetting);
	}
	
	@Override
	public List<ActivityGuests> getSendingGuests(ActivityGuestsSetting activityGuestsSetting) {
		return activityGuestsDao.getSendingGuests(activityGuestsSetting);
	}

	@Override
	public List<ActivityGuests> getWaitingGuests(
			ActivityGuestsSetting activityGuestsSetting) {
		return activityGuestsDao.getWaitingGuests(activityGuestsSetting);
	}

	@Override
	public void update(ActivityGuests sendingGuest) {
		activityGuestsDao.update(sendingGuest);
	}
	
}
