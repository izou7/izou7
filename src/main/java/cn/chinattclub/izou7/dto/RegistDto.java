package cn.chinattclub.izou7.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class RegistDto {
	
	@NotBlank(message="手机不能为空")
	@Pattern(regexp = "^1[3-8]{1}\\d{9}$", message = "手机格式不正确")
	private String phone;
	
	@NotBlank(message="密码不能为空")
	@Pattern(regexp = "^[A-Za-z]\\w{5,11}$", message = "密码格式不正确")
	private String password;
	
	@NotBlank(message="验证码不能为空")
	private String captcha;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	
}
