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
@Table(name = "i_contact")
public class Contact {
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(message="姓名不能为空！")
	@Length(max=50,message="姓名不能超过50个字符长度")
	private String name;
	
	@Email(message="邮件地址无效！")  
    @NotBlank(message="邮件地址不能为空！")
	@Length(max=50,message="邮件不能超过50个字符长度")
	private String email;
	
	@NotBlank(message="手机不能为空")
	@Pattern(regexp = "^1[3-8]{1}\\d{9}$", message = "手机格式不正确")
	private String phone;
	
	@NotBlank(message="公司不能为空")
	@Length(max=50,message="公司不能超过50个字符长度")
	private String company;
	
	@NotBlank(message="介绍不能为空")
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
