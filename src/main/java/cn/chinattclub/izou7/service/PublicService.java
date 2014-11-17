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

	void importPublic(PublicDto dto);
	
	List<Public> listPublic(User user);
	
	void deletePublic(int id);

}
