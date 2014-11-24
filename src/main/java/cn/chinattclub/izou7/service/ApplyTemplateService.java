package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.ApplyTemplate;

/**
 * 活动报名模板逻辑接口
 * @author ZY
 *
 */
public interface ApplyTemplateService {
	
	public List<ApplyTemplate> list();

	/**
	 * 获取报名模板
	 * @param id
	 * @return
	 */
	public ApplyTemplate get(int id);

}
