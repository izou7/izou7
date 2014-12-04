package cn.chinattclub.izou7.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * 登陆用户DTO
 *
 * @author zhangying.
 *         Created 2014-12-4.
 */
public class RegistUserDto {
	
	@Size(min=6,max=20,message="用户名长度应在5到20个字符之间")
	@Pattern(regexp="^[a-zA-Z0-9]+$",message="用户名须由字母数字组成")
	private String username;
	
	@Size(min=6,max=20,message="密码长度应在5到20个字符之间")
	@Pattern(regexp="^[a-zA-Z0-9]+$",message="密码须由字母数字组成")
	private String password;
	
	private String password2;
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
	/**
	 * Returns the value of the field called 'username'.
	 * @return Returns the username.
	 */
	public String getUsername() {
		return this.username;
	}
	/**
	 * Sets the field called 'username' to the given value.
	 * @param username The username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
