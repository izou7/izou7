package cn.chinattclub.izou7.dto;

import java.util.Date;




/**
 * 社区成员DTO
 * @author ZY
 *
 */
public class MemberDto {
	
	private int id;
	
	private String headPictureUrl;
	
	private String username;
	
	private Date addDate;
	
	private String phone;
	
	private String introduction;
	
	private int userId;

	/**
	 * Returns the value of the field called 'headPictureUrl'.
	 * @return Returns the headPictureUrl.
	 */
	public String getHeadPictureUrl() {
		return this.headPictureUrl;
	}

	/**
	 * Sets the field called 'headPictureUrl' to the given value.
	 * @param headPictureUrl The headPictureUrl to set.
	 */
	public void setHeadPictureUrl(String headPictureUrl) {
		this.headPictureUrl = headPictureUrl;
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

	/**
	 * Returns the value of the field called 'addDate'.
	 * @return Returns the addDate.
	 */
	public Date getAddDate() {
		return this.addDate;
	}

	/**
	 * Sets the field called 'addDate' to the given value.
	 * @param addDate The addDate to set.
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
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
	 * Returns the value of the field called 'introduction'.
	 * @return Returns the introduction.
	 */
	public String getIntroduction() {
		return this.introduction;
	}

	/**
	 * Sets the field called 'introduction' to the given value.
	 * @param introduction The introduction to set.
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

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
	 * Returns the value of the field called 'userId'.
	 * @return Returns the userId.
	 */
	public int getUserId() {
		return this.userId;
	}

	/**
	 * Sets the field called 'userId' to the given value.
	 * @param userId The userId to set.
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
