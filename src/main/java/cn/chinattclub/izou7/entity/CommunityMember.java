package cn.chinattclub.izou7.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * 活动用户实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_community_member")
public class CommunityMember {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	@JoinColumn(name="community")
	private Community community;
	
	/**
	 * 活动
	 */
	@ManyToOne
	@JoinColumn(name="member")
	private User member;
	
	/** 
	 *  创建时间
	 */
	@Column(name = "create_time")
	private Date createTime = new Date();
	
	/** 
	 * 更新时间 
	 */
	@Column(name = "update_time", insertable = false, updatable = false)
	private Date updateTime = new Date();
	
	private int status;

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

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
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

	/**
	 * Returns the value of the field called 'status'.
	 * @return Returns the status.
	 */
	public int getStatus() {
		return this.status;
	}

	/**
	 * Sets the field called 'status' to the given value.
	 * @param status The status to set.
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	
}
