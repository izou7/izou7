package cn.chinattclub.izou7.service;


import cn.chinattclub.izou7.entity.User;

/*
 * 
 *@Title:
 *@Description:
 *@Author:ZY
 *@Since:2014-11-9
 *@Version:1.1.0
 */
public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void updatePassword(int userId, String newPassword);

    
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);
    
    public boolean exists(String username);

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param key
	 */
	public void updateAndDecodeUser(String key);
	
	public User get(int id);

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param oldPassword
	 * @param user
	 * @return
	 */
	public String getEncryptPassword(String oldPassword, User user);

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param user
	 * @param encryptPassword
	 */
//	public void updatePasswordNew(User user, String encryptPassword);
    
}
