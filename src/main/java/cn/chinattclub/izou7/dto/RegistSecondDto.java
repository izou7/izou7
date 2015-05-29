package cn.chinattclub.izou7.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistSecondDto {
	
	@NotBlank(message="真实姓名不能为空")
	@Length(max=50,message="真实姓名不合法")
	private String realName;
	
	private Integer city;
	
	@Length(max=100,message="公司名称不合法")
	private String company;
	
	@Length(max=100,message="公司职位不合法")
	private String position;
	
	private Boolean sex = true;
	
	@NotNull(message="ID不能为空")
	private Integer id;

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
	 * Returns the value of the field called 'city'.
	 * @return Returns the city.
	 */
	public Integer getCity() {
		return this.city;
	}

	/**
	 * Sets the field called 'city' to the given value.
	 * @param city The city to set.
	 */
	public void setCity(Integer city) {
		this.city = city;
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
	 * Returns the value of the field called 'position'.
	 * @return Returns the position.
	 */
	public String getPosition() {
		return this.position;
	}

	/**
	 * Sets the field called 'position' to the given value.
	 * @param position The position to set.
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Returns the value of the field called 'sex'.
	 * @return Returns the sex.
	 */
	public Boolean getSex() {
		return this.sex;
	}

	/**
	 * Sets the field called 'sex' to the given value.
	 * @param sex The sex to set.
	 */
	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	/**
	 * Returns the value of the field called 'id'.
	 * @return Returns the id.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets the field called 'id' to the given value.
	 * @param id The id to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
