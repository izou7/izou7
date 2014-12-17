package cn.chinattclub.izou7.dto;



/**
 * 活动查询DTO
 * @author ZY
 *
 */
public class ActivityQueryDto {
	
	private Integer userId;
	
	private Integer status;
	
	private String name;

	

	/**
	 * Returns the value of the field called 'userId'.
	 * @return Returns the userId.
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * Sets the field called 'userId' to the given value.
	 * @param userId The userId to set.
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Returns the value of the field called 'status'.
	 * @return Returns the status.
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * Sets the field called 'status' to the given value.
	 * @param status The status to set.
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
	
	
}
