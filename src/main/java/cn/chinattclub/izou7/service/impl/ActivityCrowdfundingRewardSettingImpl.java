package cn.chinattclub.izou7.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityCrowdfundingSettingDao;
import cn.chinattclub.izou7.entity.ActivityCrowdfundingSetting;
import cn.chinattclub.izou7.enumeration.CrowdfundingStatus;
import cn.chinattclub.izou7.service.ActivityCrowdfundingSettingService;
/**
 * 活动众筹业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityCrowdfundingRewardSettingImpl implements ActivityCrowdfundingSettingService {
	
	@Resource
	private ActivityCrowdfundingSettingDao dao;
	
	@Override
	public ActivityCrowdfundingSetting findByActivityId(Integer activityId) {
		// TODO Auto-generated method stub
		return dao.findByActivityId(activityId);
	}

	@Override
	public void addOrUpdate(ActivityCrowdfundingSetting setting) {
		// TODO Auto-generated method stub
		if(setting.getId()==null){
			dao.save(setting);
		}else{
			ActivityCrowdfundingSetting settingPersistent = dao.get(setting.getId());
			settingPersistent.setAccountBank(setting.getAccountBank());
			settingPersistent.setAccountName(setting.getAccountName());
			settingPersistent.setAccountNumber(setting.getAccountNumber());
			settingPersistent.setAccountType(setting.getAccountType());
			settingPersistent.setAmount(setting.getAmount());
			settingPersistent.setDays(setting.getDays());
			settingPersistent.setGotAmount(setting.getGotAmount());
			settingPersistent.setHighLines(setting.getHighLines());
			settingPersistent.setSubBank(setting.getSubBank());
			dao.update(settingPersistent);
		}
	}
	
	
}
