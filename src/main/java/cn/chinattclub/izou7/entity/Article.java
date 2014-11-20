package cn.chinattclub.izou7.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "i_article")
public class Article {

	@Id
	@GeneratedValue
	private Integer id;

	
	private String title;
	
	private String tags;
	
	private String summary;
	
	private String url;
	
	@Transient
	private String error;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Returns the value of the field called 'error'.
	 * @return Returns the error.
	 */
	public String getError() {
		return this.error;
	}

	/**
	 * Sets the field called 'error' to the given value.
	 * @param error The error to set.
	 */
	public void setError(String error) {
		this.error = error;
	}

	
	
}
