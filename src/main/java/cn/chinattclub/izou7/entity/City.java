package cn.chinattclub.izou7.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@Table(name = "i_city")
public class City {
	@Id
	@GeneratedValue
	private int id;
	
	private String city;
	
//	private int pid;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private Province province;

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
	 * Returns the value of the field called 'city'.
	 * @return Returns the city.
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Sets the field called 'city' to the given value.
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the value of the field called 'province'.
	 * @return Returns the province.
	 */
	public Province getProvince() {
		return this.province;
	}

	/**
	 * Sets the field called 'province' to the given value.
	 * @param province The province to set.
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

}
