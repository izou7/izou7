package cn.chinattclub.izou7.service;

import java.util.List;

import cn.chinattclub.izou7.entity.Media;



/**
 * 
 * 媒体业务逻辑类
 *
 * @author zhangying.
 *         Created 2015-01-31.
 */
public interface MediaService {

	public List<Media> list();
	
	public void save(Media media);
	
	public void update(Media media);
	
}
