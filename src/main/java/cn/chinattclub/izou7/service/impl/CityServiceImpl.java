package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.CityDao;
import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.service.CityService;
/**
 * 城市业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class CityServiceImpl implements CityService {

	@Resource
	private CityDao dao;
	@Override
	public List<City> findCityIdByProvince(int id) {
		// TODO Auto-generated method stub.
		return dao.findByHQL("SELECT pro.citys from Province as pro where pro.id=?",0,1000,id);
	}
	
	@Override
	public City getCity(int id){
		return dao.get(id);
	}
	
	@Override
	public List<City> list() {
		// TODO Auto-generated method stub.
		return dao.list();
	}
}
