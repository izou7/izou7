package cn.chinattclub.izou7.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "i_media")
public class Media {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Length(min=1, max=50,message="媒体名称长度应在1到50个字符之间")
	private String name;
	
	@Length(min=1, max=50,message="媒体公众号名称长度应在1到50个字符之间")
	@Column(name="public_name")
	private String publicName;
	
	@Length(min=1, max=50,message="媒体公众号ID长度应在1到50个字符之间")
	@Column(name="public_id")
	private String publicId;
	
	@Length(min=1, max=50,message="标签长度应在1到50个字符之间")
	private String tags;
	
	@Length(min=1, max=500,message="简介长度应在1到500个字符之间")
	private String introduction;
	
	@Length(min=1, max=200,message="海报不能为空")
	@Column(name="poster_url")
	private String posterUrl;
	
	@Column(name="user_id")
	private int userId;

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

	public String getPublicName() {
		return publicName;
	}

	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	
}
