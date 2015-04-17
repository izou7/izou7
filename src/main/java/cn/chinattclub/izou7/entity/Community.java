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
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * 社区实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_community")
@JsonIgnoreProperties("city")
public class Community {

	@Id
	@GeneratedValue
	private Integer id;

	/**
	 * 用户名
	 */
	@ManyToOne
	@JoinColumn(name="admin")
	@NotFound(action = NotFoundAction.IGNORE)
	private User admin;
	
	/**
	 * 社区标签
	 */
	@NotBlank(message="标签不能为空")
	@Length(max=50,message="标签长度应小于50个字符")
	private String tags;
	
	
	/**
	 * 社区名称
	 */
	@NotBlank(message="社区名称不能为空")
	@Length(max=50,message="社区名称长度应小于50个字符")
	private String name;
	
	/**
	 * 活动举办城市
	 */
	@ManyToOne
	@JoinColumn(name="city")
	private City city;
	
	@Transient
	private int cityId;
	
	@Transient
	@NotBlank(message="联系人不能为空")
	@Length(max=50,message="联系人长度应小于50个字符")
	private String realName;
	
	@Transient
	@NotBlank(message="手机不能为空")
	@Pattern(regexp = "^1[3-8]{1}\\d{9}$", message = "手机格式不正确")
	private String phone;
	/**
	 * 地址
	 */
//	@NotBlank(message="地址不能为空")
//	@Length(max=200,message="地址长度应小于200个字符")
	private String address;
	
	@OneToMany(mappedBy = "community",cascade=CascadeType.REMOVE)
	private List<CommunityMember> communityMembers;
	
	/**
	 * 地点横坐标
	 */
	@Column(name = "coordinate_x")
	private Float coordinateX;
	
	/**
	 * 地点纵坐标
	 */
	@Column(name = "coordinate_y")
	private Float coordinateY;
	
	private String poster;
	
	/**
	 * 活动介绍
	 */
	@NotBlank(message="介绍不能为空")
	@Length(max=500,message="介绍长度小于500个字符之间")
	private String description;
	
	private String reserve;

	/**
	 * 微信公众号
	 */
	@Column(name = "public_number")
	private String publicNumber;
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
	
	private boolean enable = true;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Returns the value of the field called 'admin'.
	 * @return Returns the admin.
	 */
	public User getAdmin() {
		return this.admin;
	}

	/**
	 * Sets the field called 'admin' to the given value.
	 * @param admin The admin to set.
	 */
	public void setAdmin(User admin) {
		this.admin = admin;
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

	public Float getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(Float coordinateX) {
		this.coordinateX = coordinateX;
	}

	public Float getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(Float coordinateY) {
		this.coordinateY = coordinateY;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
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
	 * Returns the value of the field called 'communityMembers'.
	 * @return Returns the communityMembers.
	 */
	public List<CommunityMember> getCommunityMembers() {
		return this.communityMembers;
	}

	/**
	 * Sets the field called 'communityMembers' to the given value.
	 * @param communityMembers The communityMembers to set.
	 */
	public void setCommunityMembers(List<CommunityMember> communityMembers) {
		this.communityMembers = communityMembers;
	}

	/**
	 * Returns the value of the field called 'address'.
	 * @return Returns the address.
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Sets the field called 'address' to the given value.
	 * @param address The address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the value of the field called 'cityId'.
	 * @return Returns the cityId.
	 */
	public int getCityId() {
		return this.cityId;
	}

	/**
	 * Sets the field called 'cityId' to the given value.
	 * @param cityId The cityId to set.
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	/**
	 * Returns the value of the field called 'publicNumber'.
	 * @return Returns the publicNumber.
	 */
	public String getPublicNumber() {
		return this.publicNumber;
	}

	/**
	 * Sets the field called 'publicNumber' to the given value.
	 * @param publicNumber The publicNumber to set.
	 */
	public void setPublicNumber(String publicNumber) {
		this.publicNumber = publicNumber;
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
	
	
	
}
