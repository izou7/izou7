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
    private ActivityGuestsSettingDao dao;

	@Override
	public List<ActivityGuestsSetting> getUnfixedActivity() {
		return dao.getUnfixedActivity();
	}

	@Override
	public void update(ActivityGuestsSetting activityGuestsSetting) {
		dao.update(activityGuestsSetting);
	}

	@Override
	public void addOrUpdate(ActivityGuestsSetting setting) {
		// TODO Auto-generated method stub
		if(setting.getId()==null){
			dao.save(setting);
		}else{
			ActivityGuestsSetting persistentSetting = dao.get(setting.getId());
			persistentSetting.setGuestNumber(setting.getGuestNumber());
			persistentSetting.setGuestRegistrationDeadline(setting.getGuestRegistrationDeadline());
			update(persistentSetting);
		}
	}
}
