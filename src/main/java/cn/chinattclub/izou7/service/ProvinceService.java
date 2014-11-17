package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.Province;



/**
 * 
 * 省业务逻辑类
 *
 * @author zhangying.
 *         Created 2014-11-17.
 */
public interface ProvinceService {
	/**
	 * 
	 * 获取所有省
	 *
	 * @return
	 */
	public List<Province> findAll();
}
