package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.dto.GuestDto;
import cn.chinattclub.izou7.dto.UserInfoDto;

/**
 * 活动业务逻辑接口
 * @author ZY
 *
 */
public interface UserInfoService {
	
	
	public void addUserInfo(UserInfoDto userInfoDto);
	
	public void updateUserInfo(UserInfoDto userInfoDto,int userInfoId);

	/**
	 * 活动系统推荐用户
	 * @return
	 */
	public List<GuestDto> recommend(int activityId);

}
