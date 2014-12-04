package cn.chinattclub.izou7.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.UserDao;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.UserService;
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
    public void changePassword(Long userId, String newPassword) {
        User user =userDao.get(userId);
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
}
