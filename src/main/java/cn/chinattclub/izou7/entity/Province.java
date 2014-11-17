package cn.chinattclub.izou7.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * 省实体类
 *
 * @author zhangying.
 *         Created 2014-11-17.
 */
@Entity
@Table(name = "i_province")
public class Province {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="province")
	private String name;
	
	
//	@OneToMany(mappedBy = "province",fetch = FetchType.EAGER)
//	@Fetch(FetchMode.SELECT)
//	private List<City> citys;

	/**
	 * Returns the value of the field called 'id'.
	 * @return Returns the id.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the field called 'id' to the given value.
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the value of the field called 'name'.
	 * @return Returns the name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the field called 'name' to the given value.
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	
}
