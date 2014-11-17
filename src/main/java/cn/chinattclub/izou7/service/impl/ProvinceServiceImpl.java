package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ProvinceDao;
import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.service.ProvinceService;
/**
 * 城市业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

	@Resource
	private ProvinceDao dao;
	@Override
	public List<Province> findAll() {
		// TODO Auto-generated method stub.
		return dao.list();
	}
}
