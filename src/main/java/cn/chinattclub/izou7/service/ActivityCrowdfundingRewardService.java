package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.ActivityCrowdfundingReward;



/**
 * 活动众筹业务类
 * @author ZY
 *
 */
public interface ActivityCrowdfundingRewardService {

	public List<ActivityCrowdfundingReward> findByActivityId(Integer activityId);

	public void add(ActivityCrowdfundingReward reward);

	public void delete(int id);



}
