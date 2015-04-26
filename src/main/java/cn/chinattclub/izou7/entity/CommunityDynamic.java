package cn.chinattclub.izou7.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 活动用户实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_community_dynamic")
public class CommunityDynamic {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	@JoinColumn(name="community")
	private Community community;
	
	@OneToMany(mappedBy = "communityDynamic",cascade=CascadeType.REMOVE)
	private List<CommunityDynamicMessage> communityDynamicMessages;
	
	/**
	 * 活动
	 */
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	private String content;
	
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

	/**
	 * Returns the value of the field called 'user'.
	 * @return Returns the user.
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Sets the field called 'user' to the given value.
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
	}


	public String getContent() {
		return content;
	}

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

	/**
	 * Returns the value of the field called 'communityDynamicMessages'.
	 * @return Returns the communityDynamicMessages.
	 */
	public List<CommunityDynamicMessage> getCommunityDynamicMessages() {
		return this.communityDynamicMessages;
	}

	/**
	 * Sets the field called 'communityDynamicMessages' to the given value.
	 * @param communityDynamicMessages The communityDynamicMessages to set.
	 */
	public void setCommunityDynamicMessages(
			List<CommunityDynamicMessage> communityDynamicMessages) {
		this.communityDynamicMessages = communityDynamicMessages;
	}

}
