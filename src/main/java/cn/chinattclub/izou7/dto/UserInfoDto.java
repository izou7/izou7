package cn.chinattclub.izou7.dto;

import java.util.Date;

import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.entity.UserInfo;

public class UserInfoDto {

	private Integer id;
	private String realName;
	private String phone;
	private String email;
	private String qq;
	private Date birthday;
	private boolean sex;
	private String introduction;
	private City city;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public UserInfo toUserInfo(UserInfo userInfo){
		userInfo.setBirthday(this.getBirthday());
		userInfo.setCity(this.getCity());
		userInfo.setEmail(this.getEmail());
		userInfo.setIntroduction(this.getIntroduction());
		userInfo.setPhone(this.getPhone());
		userInfo.setQq(this.getQq());
		userInfo.setRealName(this.getRealName());
		userInfo.setSex(this.isSex());
		return userInfo;
	}
}
