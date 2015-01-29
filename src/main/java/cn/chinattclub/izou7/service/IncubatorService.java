package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.Incubator;
import cn.zy.commons.webdev.vo.Page;



/**
 * 
 * 孵化器逻辑类
 *
 * @author zhangying.
 *         Created 2014-11-17.
 */
public interface IncubatorService {

	public List<Incubator> find(Page page);

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param id
	 * @return
	 */
	Incubator get(int id);

}
