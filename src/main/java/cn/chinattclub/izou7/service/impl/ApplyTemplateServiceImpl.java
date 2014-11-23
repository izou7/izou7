package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ApplyTemplateDao;
import cn.chinattclub.izou7.entity.ApplyTemplate;
import cn.chinattclub.izou7.service.ApplyTemplateService;
/**
 * 活动报名模板逻辑实现类
 * @author ZY
 *
 */
@Service
public class ApplyTemplateServiceImpl implements ApplyTemplateService {

	@Resource
	private ApplyTemplateDao dao;

	@Override
	public List<ApplyTemplate> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	
	
}
