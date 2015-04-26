package cn.chinattclub.izou7.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "i_agency")
public class Agency {
	@Id
	@GeneratedValue
	private int id;
	
	@Length(max=50,message="公司不能超过50个字符长度")
	private String company;
	
	@NotBlank(message="联系人不能为空！")
	@Length(max=50,message="联系人不能超过50个字符长度")
	private String name;
	
	@NotBlank(message="手机不能为空")
	@Pattern(regexp = "^1[3-8]{1}\\d{9}$", message = "手机格式不正确")
	private String phone;
	
	@Pattern(regexp = "[1-9][0-9]{5,9}",message = "QQ号格式不正确")
	private String qq;
	
	@NotBlank(message="地区不能为空")
	private String city;
	
	@Email(message="邮件地址无效！")  
	@Length(max=50,message="邮件不能超过50个字符长度")
	private String email;
	
	
	@NotBlank(message="地址不能为空")
	@Length(max=200,message="地址不能超过200个字符长度")
	private String address;
	
	
	
	@Length(max=500,message="介绍不能超过500个字符长度")
	private String description;

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


	/**
	 * Returns the value of the field called 'city'.
	 * @return Returns the city.
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Sets the field called 'city' to the given value.
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the value of the field called 'qq'.
	 * @return Returns the qq.
	 */
	public String getQq() {
		return this.qq;
	}

	/**
	 * Sets the field called 'qq' to the given value.
	 * @param qq The qq to set.
	 */
	public void setQq(String qq) {
		this.qq = qq;
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
	 * Returns the value of the field called 'description'.
	 * @return Returns the description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the field called 'description' to the given value.
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
