package cn.chinattclub.izou7.dto;

import java.util.Date;

import cn.chinattclub.izou7.entity.ActivityGuest;


/**
 * 系统推荐嘉宾信息DTO
 * @author ZY
 *
 */
public class GuestDto {

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
	public ActivityGuest convert(){
		ActivityGuest guest = new ActivityGuest();
		guest.setCompany(company);
		guest.setCreateTime(new Date());
		guest.setIntroduction(introduction);
		guest.setName(name);
		guest.setPhone(phone);
		guest.setPosition(position);
		return guest;
		
	}
	
	
}
