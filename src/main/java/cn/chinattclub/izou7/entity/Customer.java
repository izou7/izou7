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
	
	@NotBlank(message="公司名称不能为空！")
	@Length(max=50,message="公司名称不能超过50个字符长度")
	@Column(name = "company_name")
	private String companyName;
	
	
	@Length(max=100,message="公司网址不能超过100个字符长度")
	private String webSite;
	
	@Length(max=50,message="公众号名称不能超过50个字符长度")
	private String publicNum;
	
	@NotBlank(message="姓名不能为空！")
	@Length(max=50,message="姓名不能超过50个字符长度")
	private String name;
	
	@NotBlank(message="职务不能为空！")
	@Length(max=50,message="职务不能超过50个字符长度")
	private String position;
	
	@Length(max=1000,message="教育背景不能超过1000个字符长度")
	@Column(name = "education_info")
	private String educationInfo;
	
	@Length(max=1000,message="工作经历不能超过1000个字符长度")
	@Column(name = "career_info")
	private String careerInfo;
	
	
	@Length(max=10000,message="公司产品或拟申报项目简介不能超过10000个字符长度")
	private String description;


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


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getEducationInfo() {
		return educationInfo;
	}


	public void setEducationInfo(String educationInfo) {
		this.educationInfo = educationInfo;
	}


	public String getCareerInfo() {
		return careerInfo;
	}


	public void setCareerInfo(String careerInfo) {
		this.careerInfo = careerInfo;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
}
