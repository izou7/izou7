package cn.chinattclub.izou7.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cn.chinattclub.izou7.dao.CityDao;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.User2;
import cn.chinattclub.izou7.realm.UserRealm;
import cn.chinattclub.izou7.service.ActivityGuestsService;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.service.CityService;
import cn.chinattclub.izou7.service.UserService;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-12
 * <p>Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
				"classpath:spring-shiro-web.xml",
				"classpath:applicationContext-mysql.xml",
				"classpath:applicationContext-common.xml"
		}
)
@TransactionConfiguration(defaultRollback = false)
public class ShiroTest { 

    @Autowired
    protected UserService userService;

    @Autowired
    private UserRealm userRealm;
    
    @Resource
    private CityService cityServiceImpl;
    
    @Resource
    private ActivityService activityServiceImpl;
    
    @Resource
    private ActivityGuestsService activityGuestsServiceImpl;



    protected String password = "123";

    protected User2 u1;
    protected User2 u2;
    protected User2 u3;
    protected User2 u4;
    
    public void setUp() {
//        //4、新增用户
//        u1 = new User("zhang", password);
//        u2 = new User("li", password);
//        u3 = new User("wu", password);
//        u4 = new User("wang", password);
//        u4.setLocked(Boolean.TRUE);
//        userService.createUser(u1);
//        userService.createUser(u2);
//        userService.createUser(u3);
//        userService.createUser(u4);

    }

    @Test
    public void test() {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken("wu", password);
//        subject.login(token);
//
//        Assert.assertTrue(subject.isAuthenticated());
//        subject.checkRole("admin");
//        subject.checkPermission("user:create");
//    	User u = new User();
//    	u.setUsername("zy");
//    	u.setPassword("123456");
//    	userService.createUser(u);
    	
//    	List<City> citys = cityServiceImpl.list();
//    	System.out.println(citys.size());
//    	List<City> city = cityServiceImpl.findCityIdByProvince(28);
//    	System.out.println(city.size());
//    	ActivityGuestsSetting activityGuestsSetting = new ActivityGuestsSetting();
//    	activityGuestsSetting.setId(1);
//    	List<ActivityGuests> tt = activityGuestsServiceImpl.getWaitingGuests(activityGuestsSetting);
//    	System.out.println(tt.size());
    	
    }

}

