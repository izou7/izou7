package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.BankDao;
import cn.chinattclub.izou7.entity.Bank;
import cn.chinattclub.izou7.service.BankService;
/**
 * 银行逻辑类
 * @author ZY
 *
 */
@Service
public class BankServiceImpl implements BankService {

	@Resource
	private BankDao dao;
	
	@Override
	public List<Bank> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	
	
}
