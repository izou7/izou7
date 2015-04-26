package cn.chinattclub.izou7.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.AgencyDao;
import cn.chinattclub.izou7.entity.Agency;
import cn.chinattclub.izou7.service.AgencyService;
/**
 * 代理加入业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class AgencyServiceImpl implements AgencyService {

	@Resource
	private AgencyDao dao;

	@Override
	public void add(Agency agency) {
		// TODO Auto-generated method stub.
		dao.save(agency);
	}
	
}
