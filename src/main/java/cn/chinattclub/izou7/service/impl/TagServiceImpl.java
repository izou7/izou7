package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.TagDao;
import cn.chinattclub.izou7.entity.Tag;
import cn.chinattclub.izou7.service.TagService;

/*
 * 标签业务逻辑类
 * @author ZY
 *
 */
@Service("tagService")
public class TagServiceImpl implements TagService {
	@Resource
    private TagDao tagDao;

	@Override
	public List<Tag> list() {
		// TODO Auto-generated method stub.
		return tagDao.list();
	}
	
}
