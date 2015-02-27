package cn.chinattclub.izou7.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "i_guest")
public class Guest {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Length(min=1, max=50,message="兴趣标签长度应在1到50个字符之间")
	@Column(name="interest_tags")
	private String interestTags;
	
	@Length(min=1, max=50,message="擅长标签长度应在1到50个字符之间")
	@Column(name="adept_tags")
	private String adeptTags;
	
	@Column(name="user_id")
	private int userId;
	
	@Length(min=1, max=200,message="图像不能为空")
	@Column(name="poster_url")
	private String posterUrl;
	
	private String ways;
	
	@Length(min=1,max=50,message="真实姓名字符长度应在1到50位之间")
	@Column(name="real_name")
	private String realName;
	
	@Pattern(regexp="1[3|5|7|8|][0-9]{9}",message="手机号格式不合法")
	private String phone;
	
	@Length(min=1,max=50,message="公司名称字符长度应在1到50位之间")
	private String company;
	
	@Length(min=1,max=50,message="职位名称字符长度应在1到50位之间")
	private String position;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name = "update_time", insertable = false, updatable = false)
	private Date updateTime;
	
	private boolean enable = true;
	
	private boolean self;

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

	/**
	 * Returns the value of the field called 'interestTags'.
	 * @return Returns the interestTags.
	 */
	public String getInterestTags() {
		return this.interestTags;
	}

	/**
	 * Sets the field called 'interestTags' to the given value.
	 * @param interestTags The interestTags to set.
	 */
	public void setInterestTags(String interestTags) {
		this.interestTags = interestTags;
	}

	/**
	 * Returns the value of the field called 'adeptTags'.
	 * @return Returns the adeptTags.
	 */
	public String getAdeptTags() {
		return this.adeptTags;
	}

	/**
	 * Sets the field called 'adeptTags' to the given value.
	 * @param adeptTags The adeptTags to set.
	 */
	public void setAdeptTags(String adeptTags) {
		this.adeptTags = adeptTags;
	}

	/**
	 * Returns the value of the field called 'userId'.
	 * @return Returns the userId.
	 */
	public int getUserId() {
		return this.userId;
	}

	/**
	 * Sets the field called 'userId' to the given value.
	 * @param userId The userId to set.
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Returns the value of the field called 'posterUrl'.
	 * @return Returns the posterUrl.
	 */
	public String getPosterUrl() {
		return this.posterUrl;
	}

	/**
	 * Sets the field called 'posterUrl' to the given value.
	 * @param posterUrl The posterUrl to set.
	 */
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	/**
	 * Returns the value of the field called 'realName'.
	 * @return Returns the realName.
	 */
	public String getRealName() {
		return this.realName;
	}

	/**
	 * Sets the field called 'realName' to the given value.
	 * @param realName The realName to set.
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * Returns the value of the field called 'phone'.
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * Sets the field called 'phone' to the given value.
	 * @param phone The phone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns the value of the field called 'company'.
	 * @return Returns the company.
	 */
	public String getCompany() {
		return this.company;
	}

	/**
	 * Sets the field called 'company' to the given value.
	 * @param company The company to set.
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * Returns the value of the field called 'position'.
	 * @return Returns the position.
	 */
	public String getPosition() {
		return this.position;
	}

	/**
	 * Sets the field called 'position' to the given value.
	 * @param position The position to set.
	 */
	public void setPosition(String position) {
		this.position = position;
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
	 * Returns the value of the field called 'enable'.
	 * @return Returns the enable.
	 */
	public boolean isEnable() {
		return this.enable;
	}

	/**
	 * Sets the field called 'enable' to the given value.
	 * @param enable The enable to set.
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * Returns the value of the field called 'self'.
	 * @return Returns the self.
	 */
	public boolean isSelf() {
		return this.self;
	}

	/**
	 * Sets the field called 'self' to the given value.
	 * @param self The self to set.
	 */
	public void setSelf(boolean self) {
		this.self = self;
	}

	
}
