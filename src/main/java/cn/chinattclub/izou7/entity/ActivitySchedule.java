package cn.chinattclub.izou7.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * 活动日程实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_schedule")
public class ActivitySchedule {
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	private int activity;
	
	/**
	 * 开始时间
	 */
	@Column(name = "start_time")
	private Date startTime;
	
	/**
	 * 结束时间
	 */
	@Column(name = "end_time")
	private Date endTime;
	
	/**
	 * 活动内容
	 */
	private String content;
	
	/** 
	 *  创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;
	
	/** 
	 * 更新时间 
	 */
	@Column(name = "update_time", insertable = false, updatable = false)
	private Date updateTime;
	
	@Transient
	private String title;
	
	@Transient
	private String start;
	
	@Transient
	private String end;
	
	@Transient
	private Boolean allDay=false;
	
	/**
	 * Returns the value of the field called 'id'.
	 * @return Returns the id.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets the field called 'id' to the given value.
	 * @param id The id to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	public int getActivity() {
		return activity;
	}

	public void setActivity(int activity) {
		this.activity = activity;
	}

	/**
	 * Returns the value of the field called 'startTime'.
	 * @return Returns the startTime.
	 */
	public Date getStartTime() {
		return this.startTime;
	}

	/**
	 * Sets the field called 'startTime' to the given value.
	 * @param startTime The startTime to set.
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Returns the value of the field called 'endTime'.
	 * @return Returns the endTime.
	 */
	public Date getEndTime() {
		return this.endTime;
	}

	/**
	 * Sets the field called 'endTime' to the given value.
	 * @param endTime The endTime to set.
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * Returns the value of the field called 'content'.
	 * @return Returns the content.
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * Sets the field called 'content' to the given value.
	 * @param content The content to set.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Returns the value of the field called 'createTime'.
	 * @return Returns the createTime.
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * Sets the field called 'createTime' to the given value.
	 * @param createTime The createTime to set.
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Returns the value of the field called 'updateTime'.
	 * @return Returns the updateTime.
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * Sets the field called 'updateTime' to the given value.
	 * @param updateTime The updateTime to set.
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTitle() {
		return content;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return df.format(startTime);
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return df.format(endTime);
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Boolean getAllDay() {
		return allDay;
	}

	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}
	
	

}
