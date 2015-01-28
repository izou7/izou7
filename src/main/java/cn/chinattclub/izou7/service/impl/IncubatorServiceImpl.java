package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.IncubatorDao;
import cn.chinattclub.izou7.entity.Incubator;
import cn.chinattclub.izou7.service.IncubatorService;
import cn.zy.commons.webdev.vo.Page;
/**
 * 孵化器业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class IncubatorServiceImpl implements IncubatorService {

	@Resource
	private IncubatorDao dao;

	@Override
	public List<Incubator> find(Page page) {
		// TODO Auto-generated method stub.
		page.setRecordCount(dao.findCount());
		return dao.find(page);
	}
}
