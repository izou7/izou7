package cn.chinattclub.izou7.dto;

import java.util.Date;

import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.entity.UserInfo;

public class UserDto {

	private String userName;
	private String address;
	/**
	 * Returns the value of the field called 'userName'.
	 * @return Returns the userName.
	 */
	public String getUserName() {
		return this.userName;
	}
	/**
	 * Sets the field called 'userName' to the given value.
	 * @param userName The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * Returns the value of the field called 'address'.
	 * @return Returns the address.
	 */
	public String getAddress() {
		return this.address;
	}
	/**
	 * Sets the field called 'address' to the given value.
	 * @param address The address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
