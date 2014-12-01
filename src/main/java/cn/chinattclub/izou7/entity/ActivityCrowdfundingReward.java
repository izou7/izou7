package cn.chinattclub.izou7.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



/**
 * 活动众筹回报设置实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_crowdfunding_reward_setting")
public class ActivityCrowdfundingReward {

	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * 活动
	 */
	private int activity;
	
	/**
	 * 支持金额
	 */
	private int amount;
	
	/**
	 * 众筹名额
	 */
	@Column(name="limit_num")
	private int limit;
	
	/**
	 * 回报内容
	 */
	private String reward;
	
	/**
	 * 回报开始时间
	 */
	@Column(name="reward_start_time")
	private Date rewardStartTime;
	
	/**
	 * 回报结束时间
	 */
	@Column(name="reward_end_time")
	private Date rewardEndTime;
	
	/**
	 * 回报天数
	 */
	@Transient
	private Integer days;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActivity() {
		return activity;
	}

	public void setActivity(int activity) {
		this.activity = activity;
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

	public Date getRewardStartTime() {
		return rewardStartTime;
	}

	public void setRewardStartTime(Date rewardStartTime) {
		this.rewardStartTime = rewardStartTime;
	}

	public Date getRewardEndTime() {
		return rewardEndTime;
	}

	public void setRewardEndTime(Date rewardEndTime) {
		this.rewardEndTime = rewardEndTime;
	}

	public Integer getDays() {
		return Integer.parseInt(String.valueOf((rewardEndTime.getTime()-rewardStartTime.getTime())/(1000*24*60*60)));
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
}
