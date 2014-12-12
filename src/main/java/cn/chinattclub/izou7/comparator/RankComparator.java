package cn.chinattclub.izou7.comparator;

import java.util.Comparator;

import cn.chinattclub.izou7.entity.ActivityGuest;


/**
 * 排名比较Comparator
 *
 * @author zhangying.
 *         Created 2014-12-4.
 */
public class RankComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub.
		ActivityGuest g1 = (ActivityGuest)o1;
		ActivityGuest g2 = (ActivityGuest)o2;
		if(g1.getRank()>g2.getRank()){
			return 1;
		}
		return -1;
	}

}
