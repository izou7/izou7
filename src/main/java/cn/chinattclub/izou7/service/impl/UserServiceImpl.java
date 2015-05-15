package cn.chinattclub.izou7.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ContactDao;
import cn.chinattclub.izou7.dao.UserDao;
import cn.chinattclub.izou7.entity.Contact;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.ContactService;
import cn.chinattclub.izou7.service.UserService;
import cn.chinattclub.izou7.util.Base64Util;
import cn.chinattclub.izou7.util.PasswordHelper;
/**
 * 用户业务逻辑类
 * @author ZY
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	
	@Resource
    private UserDao userDao;
	@Resource
	private ContactDao dao;
	
	@Resource
    private PasswordHelper passwordHelper;
	

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        userDao.save(user);
        return user;
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    @Override
    public void updatePassword(int userId, String newPassword) {
        User user = userDao.get(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.update(user);
    }


    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

	@Override
	public boolean exists(String  username) {
		return userDao.findByUsername(username)==null?false:true;
	}
	
	@Override
	public String getEncryptPassword(String oldPassword, User user) {
		PasswordHelper passwordHelper = new PasswordHelper();
		return passwordHelper.password(oldPassword, user.getSalt(), user.getUsername());
	}
	
	@Override
	public void updateAndDecodeUser(String key){
		String decodeStr = Base64Util.getFromBase64(key);
		String password = String.valueOf((Integer.parseInt(decodeStr.substring(decodeStr.length()-6,decodeStr.length()))+11111));
		String idAndPre = decodeStr.replace(decodeStr.substring(decodeStr.length()-6,decodeStr.length()),"");
		String pre = idAndPre.substring(idAndPre.length()-2,idAndPre.length());
		String id = idAndPre.substring(0,idAndPre.length()-2);
		password = pre+password;
//		User user = get(Integer.parseInt(id));
//		String newEncryptPassword = getEncryptPassword(password,user);
//		updatePasswordNew(user,newEncryptPassword);
		updatePassword(Integer.parseInt(id),password);
	}
	
//	@Override
//	public void updatePasswordNew(User user, String encryptPassword) {
//		// TODO Auto-generated method stub
//		user.setPassword(encryptPassword);
//		userDao.update(user);
//	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub.
		return userDao.get(id);
	}

}
