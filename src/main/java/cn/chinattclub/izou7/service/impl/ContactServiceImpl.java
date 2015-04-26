package cn.chinattclub.izou7.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ContactDao;
import cn.chinattclub.izou7.entity.Contact;
import cn.chinattclub.izou7.service.ContactService;
/**
 * 联系我们业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	@Resource
	private ContactDao dao;

	@Override
	public void add(Contact contact) {
		// TODO Auto-generated method stub.
		dao.save(contact);
	}

	@Override
	public Contact get(int id) {
		// TODO Auto-generated method stub.
		return dao.get(id);
	}

	@Override
	public void update(Contact contact) {
		// TODO Auto-generated method stub.
		dao.update(contact);
	}
	
}
