package cn.chinattclub.izou7.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.enumeration.ActivityExecuteType;

import com.sun.istack.NotNull;

/**
 * 活动表单DTO
 * 
 * @author ZY
 * 
 */
public class ActivityFormDto {

	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private Integer id;

	/**
	 * 活动标签
	 */
	@NotBlank(message = "活动标签不能为空")
	private String tags;

	/**
	 * 活动名称
	 */
	@Size(min = 1, max = 50, message = "活动名称不能为空且长度应在1到50个字符之间")
	private String name;

	/**
	 * 活动地址
	 */
	@Size(min = 1, max = 100, message = "活动地址长度应在1到100个字符之间")
	private String place;

	/** 开始时间 **/
	@NotBlank(message = "开始时间不能为空")
	private String startTime;

	/** 结束时间 **/
	@NotBlank(message = "结束时间不能为空")
	private String endTime;

	/**
	 * 活动人数
	 */
	@Range(min = 0, max = 10000, message = "活动人数应大于0且小于10000")
	private Integer headCount;

	/**
	 * 活动介绍
	 */
	private String introduction;

	/**
	 * 是否公开
	 */
	private Boolean opened;

	/**
	 * 活动主页
	 */
	private String homepage;

	/**
	 * 城市
	 */
	private Integer city;

	/**
	 * 海报地址
	 */
	@NotBlank(message = "活动海报不能为空")
	private String posterUrl;

	/**
	 * 提交类型
	 */
	private ActivityExecuteType type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
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

	public ActivityExecuteType getType() {
		return type;
	}

	public void setType(ActivityExecuteType type) {
		this.type = type;
	}

	public static DateFormat getDf() {
		return df;
	}

	public Activity convert(Activity activity) throws ParseException {
		if (activity == null) {
			activity = new Activity();
			activity.setCreateTime(new Date());
		}
		activity.setEndTime(df.parse(getEndTime()));
		activity.setHeadCount(getHeadCount());
		activity.setHomepage(getHomepage());
		activity.setIntroduction(getIntroduction());
		activity.setName(getName());
		activity.setOpened(getOpened());
		activity.setPlace(getPlace());
		activity.setStartTime(df.parse(getStartTime()));
		activity.setTags(getTags());
		activity.setStatus(type.equals(type.DEPLOY) ? 1 : 0);
		activity.setPosterUrl(posterUrl);
		return activity;
	}

}
