package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.entity.Sponsor;



/**
 * 
 * 城市业务逻辑类
 *
 * @author zhangying.
 *         Created 2015-01-31.
 */
public interface SponsorService {

	public List<Sponsor> list();
	
	public void save(Sponsor sponsor);
	
	public void update(Sponsor sponsor);
	
}
