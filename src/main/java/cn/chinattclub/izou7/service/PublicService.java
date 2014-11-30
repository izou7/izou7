package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.dto.PublicDto;
import cn.chinattclub.izou7.entity.Public;
import cn.chinattclub.izou7.entity.User;


/**
 * 活动业务逻辑接口
 * @author ZY
 *
 */
public interface PublicService {

	public void importPublic(PublicDto dto);
	
	public List<Public> listPublic(User user);
	
	public void deletePublic(int id);
	
	public Public getPublicById(int publicId);

	/**
	 * 系统推荐
	 * @param activityId
	 * @return
	 */
	public List<Public> recommend(Integer activityId);

}
