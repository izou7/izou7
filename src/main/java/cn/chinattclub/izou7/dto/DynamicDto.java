package cn.chinattclub.izou7.dto;

import java.util.Date;




/**
 * 动态DTO
 * @author ZY
 *
 */
public class DynamicDto {
	
	private int id;
	
	private String username;
	
	private String content;
	
	private Date createTime;

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
	 * Returns the value of the field called 'content'.
	 * @return Returns the content.
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * Sets the field called 'content' to the given value.
	 * @param content The content to set.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Returns the value of the field called 'createTime'.
	 * @return Returns the createTime.
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * Sets the field called 'createTime' to the given value.
	 * @param createTime The createTime to set.
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
