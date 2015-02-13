package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.GuestDao;
import cn.chinattclub.izou7.entity.Guest;
import cn.chinattclub.izou7.service.GuestService;

/*
 * 嘉宾业务逻辑类
 * @author ZY
 *
 */
@Service("guestService")
public class GuestServiceImpl implements GuestService {
	
	@Resource
    private GuestDao guestDao;

	@Override
	public List<Guest> list() {
		// TODO Auto-generated method stub
		return guestDao.list();
	}

	@Override
	public void save(Guest guest) {
		// TODO Auto-generated method stub
		guestDao.save(guest);
	}

	@Override
	public void update(Guest guest) {
		// TODO Auto-generated method stub
		guestDao.update(guest);
	}


	
}
