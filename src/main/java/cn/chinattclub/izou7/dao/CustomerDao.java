package cn.chinattclub.izou7.dao;

import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.Contact;
import cn.chinattclub.izou7.entity.Customer;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 
 * @author ZY
 *
 */
@Repository
public class CustomerDao  extends AdvancedHibernateDao<Customer>{
}
