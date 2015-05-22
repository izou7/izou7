package cn.chinattclub.izou7.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "i_customer")
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	
	@Length(max=50,message="公司名称不能超过50个字符长度")
	@Column(name = "company_name")
	private String companyName;
	
	
	@Length(max=100,message="公司网址不能超过100个字符长度")
	private String webSite;
	
	@Length(max=50,message="公众号名称不能超过50个字符长度")
	private String publicNum;
	
//	@NotBlank(message="姓名不能为空！")
//	@Length(max=50,message="姓名不能超过50个字符长度")
//	private String name;
//	
//	@NotBlank(message="职务不能为空！")
//	@Length(max=50,message="职务不能超过50个字符长度")
//	private String position;
//	
//	@Length(max=1000,message="教育背景不能超过1000个字符长度")
//	@Column(name = "education_info")
//	private String educationInfo;
//	
//	@Length(max=1000,message="工作经历不能超过1000个字符长度")
//	@Column(name = "career_info")
//	private String careerInfo;
	
	/**
	 * 管理层信息
	 */
	@Length(max=10000,message="管理层信息不合法")
	@Column(name="management_info")
	private String managementInfo;
	
	
	@Length(max=10000,message="公司产品或拟申报项目简介不能超过10000个字符长度")
	private String description;
	
	@NotBlank(message="姓名不能为空！")
	@Length(max=50,message="姓名不能超过50个字符长度")
	private String name;
	
	@Length(max=50,message="邮箱格式有误")
	@Email(message="邮件地址无效！")  
	private String email;
	
	@NotBlank(message="手机不能为空！")
	@Pattern(regexp = "^1[3-8]{1}\\d{9}$", message = "手机格式不正确")
	private String phone;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getWebSite() {
		return webSite;
	}


	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}


	public String getPublicNum() {
		return publicNum;
	}


	public void setPublicNum(String publicNum) {
		this.publicNum = publicNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Returns the value of the field called 'managementInfo'.
	 * @return Returns the managementInfo.
	 */
	public String getManagementInfo() {
		return this.managementInfo;
	}


	/**
	 * Sets the field called 'managementInfo' to the given value.
	 * @param managementInfo The managementInfo to set.
	 */
	public void setManagementInfo(String managementInfo) {
		this.managementInfo = managementInfo;
	}


	/**
	 * Returns the value of the field called 'email'.
	 * @return Returns the email.
	 */
	public String getEmail() {
		return this.email;
	}


	/**
	 * Sets the field called 'email' to the given value.
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
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
