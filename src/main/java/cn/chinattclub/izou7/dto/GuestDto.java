package cn.chinattclub.izou7.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import cn.chinattclub.izou7.entity.ActivityGuest;


/**
 * 系统推荐嘉宾信息DTO
 * @author ZY
 *
 */
public class GuestDto {
	
	private Integer id;
	
	@NotBlank(message="嘉宾姓名不能为空")
	private String name;
	
	private String position;
	
	private String company;
	
	private String researchArea;
	
	private String phone;
	
	private String introduction;

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getResearchArea() {
		return researchArea;
	}

	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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

	public ActivityGuest convert(){
		ActivityGuest guest = new ActivityGuest();
		guest.setCompany(company);
		guest.setCreateTime(new Date());
		guest.setIntroduction(introduction);
		guest.setName(name);
		guest.setPhone(phone);
		guest.setPosition(position);
		guest.setResearchArea(researchArea);
		return guest;
		
	}
	
	
}
