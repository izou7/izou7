package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityCrowdfundingRewardDao;
import cn.chinattclub.izou7.entity.ActivityCrowdfundingReward;
import cn.chinattclub.izou7.service.ActivityCrowdfundingRewardService;
/**
 * 活动众筹业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityCrowdfundingRewardServiceImpl implements ActivityCrowdfundingRewardService {

	@Resource
	private  ActivityCrowdfundingRewardDao dao;
	
	@Override
	public List<ActivityCrowdfundingReward> findByActivityId(Integer activityId) {
		// TODO Auto-generated method stub
		return dao.findByActivityId(activityId);
	}

	@Override
	public void add(ActivityCrowdfundingReward reward) {
		// TODO Auto-generated method stub
		dao.save(reward);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	
	
}
