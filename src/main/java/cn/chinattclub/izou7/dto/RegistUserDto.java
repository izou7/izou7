package cn.chinattclub.izou7.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;


/**
 * 登陆用户DTO
 *
 * @author zhangying.
 *         Created 2014-12-4.
 */
public class RegistUserDto {
	
//	@Size(min=6,max=20,message="用户名长度应在5到20个字符之间")
//	@Pattern(regexp="^[a-zA-Z0-9]+$",message="用户名须由字母或数字组成")
//	private String username;
	
	private String phone;
	
	private String realName;
	/**
	 * 行业
	 */
	private String industry;
	
	@Email(message="邮箱格式不正确")
	private String email;
	
	@Pattern(regexp="^[a-zA-Z]\\w{5,17}$",message="密码必须以字母开头，长度在6~18之间，只能包含字符、数字和下划线")
	private String password;
	
	private String password2;

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

	/**
	 * Returns the value of the field called 'industry'.
	 * @return Returns the industry.
	 */
	public String getIndustry() {
		return this.industry;
	}

	/**
	 * Sets the field called 'industry' to the given value.
	 * @param industry The industry to set.
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
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
	 * Returns the value of the field called 'password'.
	 * @return Returns the password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the field called 'password' to the given value.
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the value of the field called 'password2'.
	 * @return Returns the password2.
	 */
	public String getPassword2() {
		return this.password2;
	}

	/**
	 * Sets the field called 'password2' to the given value.
	 * @param password2 The password2 to set.
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
}
