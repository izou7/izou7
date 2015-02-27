package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.Guest;



/**
 * 
 * 嘉宾业务逻辑类
 *
 * @author zhangying.
 *         Created 2015-01-31.
 */
public interface GuestService {

	public List<Guest> list();
	
	public void save(Guest guest);
	
	public void update(Guest guest);
	
}
