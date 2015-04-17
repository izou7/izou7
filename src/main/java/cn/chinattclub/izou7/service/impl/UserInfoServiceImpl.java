package cn.chinattclub.izou7.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.UserDao;
import cn.chinattclub.izou7.dao.UserInfoDao;
import cn.chinattclub.izou7.dto.GuestDto;
import cn.chinattclub.izou7.dto.UserInfoDto;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.chinattclub.izou7.util.CommonUtil;
/**
 * 活动业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	public UserInfoDao userInfoDao;
	
	@Resource
	public UserDao userDao;

	/*
	public UserInfo setToUserInfo(UserInfoDto userInfoDto){
		UserInfo userInfo = new UserInfo();
		userInfo.setBirthday(userInfoDto.getBirthday());
		userInfo.setCity(userInfoDto.getCity());
		userInfo.setEmail(userInfoDto.getEmail());
		userInfo.setIntroduction(userInfoDto.getIntroduction());
		userInfo.setPhone(userInfoDto.getPhone());
		userInfo.setQq(userInfoDto.getQq());
		userInfo.setRealName(userInfoDto.getRealName());
		userInfo.setSex(userInfoDto.isSex());
		return userInfo;
	}*/

	@Override
	public void addUserInfo(UserInfoDto userInfoDto) {
		UserInfo userInfo = new UserInfo();
		userInfo = userInfoDto.toUserInfo(userInfo);
		userInfo.setBadNumber(0);
		userInfo.setCareerInfo("");
		userInfo.setCreateTime(new Date());
		userInfo.setHeadPicture("");
		userInfo.setHeadPictureUrl("");
		userInfo.setInterestCareer("");
		userInfo.setInterestField("");
		userInfo.setPraiseNumber(0);
		userInfo.setUpdateTime(new Date());
		userInfo.setUserData("");
		userInfoDao.save(userInfo);
		
		User user = CommonUtil.getCurrentUser();
		user.setUserInfo(userInfo);
		
		userDao.update(user);
	}

	@Override
	public void updateUserInfo(UserInfoDto userInfoDto, int userInfoId) {
		UserInfo userInfo = userInfoDao.get(userInfoId);
		User user = CommonUtil.getCurrentUser();
		userInfo = userInfoDto.toUserInfo(userInfo);
		userInfoDao.update(userInfo);
	}

	@Override
	public List<GuestDto> recommend(int activityId) {
		// TODO Auto-generated method stub
		List<UserInfo> list = userInfoDao.list();
		List<GuestDto> guestList = new ArrayList<>();
		for (UserInfo info : list) {
			GuestDto guest = new GuestDto();
			guest.setCompany("无");
			guest.setIntroduction(info.getIntroduction());
			guest.setName(info.getRealName());
			guest.setPhone(info.getPhone());
			guest.setPosition("无");
			guest.setResearchArea(info.getHeadPictureUrl());
			guest.setId(info.getId());
			guestList.add(guest);
		}
		return guestList;
	}

	@Override
	public UserInfo findById(int id) {
		// TODO Auto-generated method stub.
		return userInfoDao.get(id);
	}

	@Override
	public void update(UserInfo userInfo) {
		// TODO Auto-generated method stub.
		userInfoDao.update(userInfo);
	}

}
