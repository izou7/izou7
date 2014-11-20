package cn.chinattclub.izou7.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Size;


import cn.chinattclub.izou7.entity.Activity;

import com.sun.istack.NotNull;



/**
 * 活动表单DTO
 * 
 * @author ZY
 * 
 */
public class ActivityFormDto {
	
	private static final DateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd");


	private Integer id;
	
	/**
	 * 活动名称
	 */
	@NotNull
	@Size(min = 1, max = 64)
	private String name;
	
	/**
	 * 活动地址
	 */
	@NotNull
	@Size(min = 1, max = 128)
	private String place;
	
	/** 开始时间 **/
	@NotNull
	private String startTime;
	
	/** 结束时间 **/
	@NotNull
	private String endTime;
	
	/**
	 * 活动人数
	 */
	@NotNull
	private Integer headCount;
	
	/**
	 * 活动标签
	 */
	private String tags;
	
	/**
	 * 活动介绍
	 */
	private String introduction;
	
	/**
	 * 是否公开
	 */
	@NotNull
	private Boolean opened;
	
	/**
	 * 活动主页
	 */
	@NotNull
	private String homepage;
	
	/**
	 * 城市
	 */
	@NotNull
	private Integer city;
	
	/**
	 * 海报地址
	 */
	@NotNull
	private String posterUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getHeadCount() {
		return headCount;
	}

	public void setHeadCount(Integer headCount) {
		this.headCount = headCount;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	
	public Activity convert(Activity activity) throws ParseException{
		if(activity==null){
			activity = new Activity();
		}
		activity.setCreateTime(new Date());
		activity.setEndTime(df.parse(getEndTime()));
		activity.setHeadCount(getHeadCount());
		activity.setHomepage(getHomepage());
		activity.setIntroduction(getIntroduction());
		activity.setName(getName());
		activity.setOpened(getOpened());
		activity.setPlace(getPlace());
		activity.setStartTime(df.parse(getStartTime()));
		activity.setTags(getTags());
		return activity;
	}
	
}
