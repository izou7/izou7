package cn.chinattclub.izou7.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.UserInfoDao;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.UserInfoService;
/**
 * 活动业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	public UserInfoDao userInfoDao;
	
	@Override
	public UserInfo getUserInfo(User user) {
		return userInfoDao.get(user.getId());
	}

	@Override
	public void addUserInfo(UserInfo userInfo) {
		userInfoDao.save(userInfo);
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		userInfoDao.update(userInfo);
		
	}

	
	
}
