package cn.chinattclub.izou7.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "i_site")
public class Site {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Length(min=1, max=50,message="标签长度应在1到50个字符之间")
	private String tags;
	
	@Length(min=1, max=50,message="名称长度应在1到50个字符之间")
	private String name;
	
	@Length(min=1, max=200,message="海报不能为空")
	@Column(name="poster_url")
	private String posterUrl;
	
	@Length(min=1, max=200,message="地址长度应在1到200个字符之间")
	private String address;
	
	@Transient
	private Integer cityId;
	
	@Transient
	@Length(min=1,max=50,message="真实姓名字符长度应在1到50位之间")
	private String realName;
	
	@Transient
	@Pattern(regexp="1[3|5|7|8|][0-9]{9}",message="手机号格式不合法")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@Length(min=1, max=500,message="简介长度应在1到500个字符之间")
	private String introduction;
	
	@Column(name="user_id")
	private int userId;
	

	@Column(name="create_time")
	private Date createTime;
	
	@Column(name = "update_time", insertable = false, updatable = false)
	private Date updateTime;
	
	private boolean enable= true;
	
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	/**
	 * Returns the value of the field called 'cityId'.
	 * @return Returns the cityId.
	 */
	public Integer getCityId() {
		return this.cityId;
	}

	/**
	 * Sets the field called 'cityId' to the given value.
	 * @param cityId The cityId to set.
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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

	
}
