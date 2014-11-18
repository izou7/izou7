package cn.chinattclub.izou7.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * 省实体类
 *
 * @author zhangying.
 *         Created 2014-11-17.
 */
@Entity
@Table(name = "i_province")
@JsonIgnoreProperties("citys")
public class Province {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="province")
	private String name;
	
	
	@OneToMany(mappedBy = "province",fetch = FetchType.LAZY)
	private List<City> citys;

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

	/**
	 * Returns the value of the field called 'citys'.
	 * @return Returns the citys.
	 */
	public List<City> getCitys() {
		return this.citys;
	}

	/**
	 * Sets the field called 'citys' to the given value.
	 * @param citys The citys to set.
	 */
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	
	
}
