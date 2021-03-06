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
//		return dao.findByHQL("from City as city where city.province.id=?",0,1000,id);
		return dao.findByHQL("SELECT pro.citys from Province as pro where pro.id=?",0,1000,id);
//		return dao.findCityByProvince(id);
	}
	@Override
	public List<City> list() {
		// TODO Auto-generated method stub.
		return dao.list();
	}
	@Override
	public City getCity(Integer city) {
		// TODO Auto-generated method stub.
		List<City> citys = dao.findByHQL("from City as city where city.id=?",0,1000,city);
		if(citys!=null&&citys.size()>0){
			return citys.get(0);
		}
		return null;
	}
	@Override
	public City findCityByName(String name) {
		// TODO Auto-generated method stub
		List<City> citys = dao.findByHQL("from City as city where city.city=?",0,1000,name);
		
		if(citys!=null&&citys.size()>0){
			if(citys.size()>1){
				System.out.println("FUCK YOU");
			}
			return citys.get(0);
		}
		return null;
	}
}
