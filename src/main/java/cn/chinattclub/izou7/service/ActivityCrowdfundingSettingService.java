package cn.chinattclub.izou7.service;

import cn.chinattclub.izou7.entity.ActivityCrowdfundingSetting;



/**
 * 活动众筹业务类
 * @author ZY
 *
 */
public interface ActivityCrowdfundingSettingService {

	public ActivityCrowdfundingSetting findByActivityId(Integer activityId);

	public void addOrUpdate(ActivityCrowdfundingSetting setting);



}
