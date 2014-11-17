package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.City;



/**
 * 
 * 城市业务逻辑类
 *
 * @author zhangying.
 *         Created 2014-11-17.
 */
public interface CityService {

	/**
	 * 通过省ID获取城市
	 *
	 * @param id
	 * @return
	 */
	public List<City> findCityIdByProvince(int id);

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public List<City> list();
}
