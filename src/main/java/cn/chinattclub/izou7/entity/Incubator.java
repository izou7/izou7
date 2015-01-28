package cn.chinattclub.izou7.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;



/**
 * 孵化器实体类
 *
 * @author zhangying.
 *         Created 2015-1-28.
 */
@Entity
@Table(name = "i_incubator")
public class Incubator {
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 简介
	 */
	private String introduction;
	
	/**
	 * 详细介绍
	 */
	@Column(name = "detailed_introduction")
	private String detailedIntroduction;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 联系方式
	 */
	@Column(name = "contact_info")
	private String contactInfo;
	
	/**
	 * 申请链接
	 */
	private String url;
	
	/**
	 * 大海报
	 */
	@Column(name = "big_posterUrl")
	private String bigPosterUrl;
	
	/**
	 * 小海报
	 */
	@Column(name = "little_posterUrl")
	private String littlePosterUrl;
	
	@Column(name = "create_time")
	private Date createTime;
	
	private boolean enable;

	/**
	 * Returns the value of the field called 'id'.
	 * @return Returns the id.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the field called 'id' to the given value.
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the value of the field called 'name'.
	 * @return Returns the name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the field called 'name' to the given value.
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the value of the field called 'introduction'.
	 * @return Returns the introduction.
	 */
	public String getIntroduction() {
		return this.introduction;
	}

	/**
	 * Sets the field called 'introduction' to the given value.
	 * @param introduction The introduction to set.
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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
	 * Returns the value of the field called 'contactInfo'.
	 * @return Returns the contactInfo.
	 */
	public String getContactInfo() {
		return this.contactInfo;
	}

	/**
	 * Sets the field called 'contactInfo' to the given value.
	 * @param contactInfo The contactInfo to set.
	 */
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	/**
	 * Returns the value of the field called 'url'.
	 * @return Returns the url.
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Sets the field called 'url' to the given value.
	 * @param url The url to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Returns the value of the field called 'bigPosterUrl'.
	 * @return Returns the bigPosterUrl.
	 */
	public String getBigPosterUrl() {
		return this.bigPosterUrl;
	}

	/**
	 * Sets the field called 'bigPosterUrl' to the given value.
	 * @param bigPosterUrl The bigPosterUrl to set.
	 */
	public void setBigPosterUrl(String bigPosterUrl) {
		this.bigPosterUrl = bigPosterUrl;
	}

	/**
	 * Returns the value of the field called 'littlePosterUrl'.
	 * @return Returns the littlePosterUrl.
	 */
	public String getLittlePosterUrl() {
		return this.littlePosterUrl;
	}

	/**
	 * Sets the field called 'littlePosterUrl' to the given value.
	 * @param littlePosterUrl The littlePosterUrl to set.
	 */
	public void setLittlePosterUrl(String littlePosterUrl) {
		this.littlePosterUrl = littlePosterUrl;
	}

	/**
	 * Returns the value of the field called 'detailedIntroduction'.
	 * @return Returns the detailedIntroduction.
	 */
	public String getDetailedIntroduction() {
		return this.detailedIntroduction;
	}

	/**
	 * Sets the field called 'detailedIntroduction' to the given value.
	 * @param detailedIntroduction The detailedIntroduction to set.
	 */
	public void setDetailedIntroduction(String detailedIntroduction) {
		this.detailedIntroduction = detailedIntroduction;
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
	
	
	
	

}
