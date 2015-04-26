package cn.chinattclub.izou7.service;

import cn.chinattclub.izou7.entity.Contact;



/**
 * 
 * 联系我们业务逻辑类
 *
 * @author zhangying.
 *         Created 2014-11-17.
 */
public interface ContactService {

	public void add(Contact contact);
	
	public Contact get(int id);
	
	public void update(Contact contact);
}
