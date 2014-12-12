package cn.chinattclub.izou7.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;


/**
 * 活动嘉宾实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_guests_setting")
public class ActivityGuestsSetting {


	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	private Integer activity;
	
	/**
	 * 需求嘉宾人数
	 */
	@Column(name="guest_number")
	@Range(min=0, max=1000,message="需求嘉宾人数应在0到1000之间")
	private Integer guestNumber;
	
	/**
	 * 嘉宾报名期限
	 */
	@Column(name="guest_registration_deadline")
	@Range(min=0, max=30,message="嘉宾报名期限应在0到30之间")
	private Integer guestRegistrationDeadline;
	
	/**
	 * 邀请嘉宾是否完成
	 * 0是未完成，1是已完成
	 */
	private Boolean over = false;
	
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

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	public Boolean getOver() {
		return over;
	}

	public void setOver(Boolean over) {
		this.over = over;
	}

	/**
	 * Returns the value of the field called 'guestNumber'.
	 * @return Returns the guestNumber.
	 */
	public Integer getGuestNumber() {
		return this.guestNumber;
	}

	/**
	 * Sets the field called 'guestNumber' to the given value.
	 * @param guestNumber The guestNumber to set.
	 */
	public void setGuestNumber(Integer guestNumber) {
		this.guestNumber = guestNumber;
	}

	/**
	 * Returns the value of the field called 'guestRegistrationDeadline'.
	 * @return Returns the guestRegistrationDeadline.
	 */
	public Integer getGuestRegistrationDeadline() {
		return this.guestRegistrationDeadline;
	}

	/**
	 * Sets the field called 'guestRegistrationDeadline' to the given value.
	 * @param guestRegistrationDeadline The guestRegistrationDeadline to set.
	 */
	public void setGuestRegistrationDeadline(Integer guestRegistrationDeadline) {
		this.guestRegistrationDeadline = guestRegistrationDeadline;
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
	
	
	
}
