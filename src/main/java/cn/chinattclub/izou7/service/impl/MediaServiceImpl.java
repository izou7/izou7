package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.MediaDao;
import cn.chinattclub.izou7.dao.SiteDao;
import cn.chinattclub.izou7.entity.Media;
import cn.chinattclub.izou7.entity.Site;
import cn.chinattclub.izou7.service.MediaService;

/*
 * 媒体业务逻辑类
 * @author ZY
 *
 */
@Service("mediaService")
public class MediaServiceImpl implements MediaService {
	
	@Resource
    private MediaDao mediaDao;

	@Override
	public List<Media> list() {
		// TODO Auto-generated method stub
		return mediaDao.list();
	}

	@Override
	public void save(Media media) {
		// TODO Auto-generated method stub
		mediaDao.save(media);
	}

	@Override
	public void update(Media media) {
		// TODO Auto-generated method stub
		mediaDao.update(media);
	}


	
}
