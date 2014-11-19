package cn.chinattclub.izou7.service;

import cn.chinattclub.izou7.dto.UserInfoDto;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;

/**
 * 活动业务逻辑接口
 * @author ZY
 *
 */
public interface UserInfoService {
	
	
	public void addUserInfo(UserInfoDto userInfoDto);
	
	public void updateUserInfo(UserInfoDto userInfoDto,int userInfoId);

}
