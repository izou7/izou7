package cn.ttforum.izou7.test;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cn.ttforum.izou7.entity.User;
import cn.ttforum.izou7.realm.UserRealm;
import cn.ttforum.izou7.service.UserService;

import javax.sql.DataSource;

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



    protected String password = "123";

    protected User u1;
    protected User u2;
    protected User u3;
    protected User u4;
    
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
    	User u = new User();
    	u.setUsername("zy");
    	u.setPassword("123456");
    	userService.createUser(u);





    }

}
