package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityGuestsSettingDao;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.service.ActivityGuestsSettingService;

/**
 * 用户业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityGuestsSettingServiceImpl implements ActivityGuestsSettingService {
	@Resource
    private ActivityGuestsSettingDao activityGuestsSettingDao;

	@Override
	public List<ActivityGuestsSetting> getUnfixedActivity() {
		return activityGuestsSettingDao.getUnfixedActivity();
	}

	@Override
	public void update(ActivityGuestsSetting activityGuestsSetting) {
		activityGuestsSettingDao.update(activityGuestsSetting);
		
	}
}
