package cn.chinattclub.izou7.dto;

import cn.chinattclub.izou7.enumeration.ActivityStep;

/**
 * 获取活动信息DTO
 * @author ZY
 *
 */
public class ActivityDto {

	/**
	 * 活动ID
	 */
	private Integer activityId;
	/**
	 * 活动步骤
	 */
	private ActivityStep step;
	
	public Integer getActivityId() {
		return activityId;
	}
	
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	
	public ActivityStep getStep() {
		return step;
	}
	
	public void setStep(ActivityStep step) {
		this.step = step;
	}
	
	
}
