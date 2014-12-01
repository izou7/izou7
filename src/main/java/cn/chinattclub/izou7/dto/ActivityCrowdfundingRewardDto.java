package cn.chinattclub.izou7.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.chinattclub.izou7.entity.ActivityCrowdfundingReward;



/**
 * 活动众筹回报设置DTO
 * 
 * @author ZY
 * 
 */
public class ActivityCrowdfundingRewardDto {
	
	private static final DateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd");

	private int id;
	
	/**
	 * 支持金额
	 */
	private int amount;
	
	/**
	 * 众筹名额
	 */
	private int limit;
	
	/**
	 * 回报内容
	 */
	private String reward;
	
	/**
	 * 回报开始时间
	 */
	private String rewardStartTime;
	
	/**
	 * 回报结束时间
	 */
	private String rewardEndTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getRewardStartTime() {
		return rewardStartTime;
	}

	public void setRewardStartTime(String rewardStartTime) {
		this.rewardStartTime = rewardStartTime;
	}

	public String getRewardEndTime() {
		return rewardEndTime;
	}

	public void setRewardEndTime(String rewardEndTime) {
		this.rewardEndTime = rewardEndTime;
	}
	
	public ActivityCrowdfundingReward convert() throws ParseException{
		ActivityCrowdfundingReward rewardObj = new ActivityCrowdfundingReward();
		rewardObj.setAmount(amount);
		rewardObj.setLimit(limit);
		rewardObj.setReward(reward);
		rewardObj.setRewardEndTime(df.parse(rewardEndTime));
		rewardObj.setRewardStartTime(df.parse(rewardStartTime));
		return rewardObj;
	}
}
