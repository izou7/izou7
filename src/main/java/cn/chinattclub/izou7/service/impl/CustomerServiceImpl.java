package cn.chinattclub.izou7.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.CustomerDao;
import cn.chinattclub.izou7.entity.Customer;
import cn.chinattclub.izou7.service.CustomerService;
/**
 * 客户服务业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerDao dao;

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		dao.save(customer);
	}

}
