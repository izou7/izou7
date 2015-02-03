package cn.chinattclub.izou7.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "i_site")
public class Site {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Length(min=1, max=50,message="名称长度应在1到50个字符之间")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@Length(min=1, max=200,message="地址长度应在1到200个字符之间")
	private String address;
	
	@Length(min=1, max=50,message="标签长度应在1到50个字符之间")
	private String tags;
	
	@Length(min=1, max=500,message="简介长度应在1到500个字符之间")
	private String introduction;
	
	@Column(name="user_id")
	private int userId;
	
	@Length(min=1, max=200,message="海报不能为空")
	@Column(name="poster_url")
	private String posterUrl;

	@Column(name="create_time")
	private Date createTime;
	
	@Column(name = "update_time", insertable = false, updatable = false)
	private Date updateTime;
	
	private boolean enable;

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

	
}
