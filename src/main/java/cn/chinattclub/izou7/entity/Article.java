package cn.chinattclub.izou7.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "i_article")
public class Article {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name="source")
	private Public pub;
	
	private String title;
	
	private String tags;
	
	private String summary;
	
	private String url;

	@Column(name="praise_number")
	private int praiseNumber;
	
	@Column(name="bad_number")
	private int badNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Public getPub() {
		return pub;
	}

	public void setPub(Public pub) {
		this.pub = pub;
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

	public int getPraiseNumber() {
		return praiseNumber;
	}

	public void setPraiseNumber(int praiseNumber) {
		this.praiseNumber = praiseNumber;
	}

	public int getBadNumber() {
		return badNumber;
	}

	public void setBadNumber(int badNumber) {
		this.badNumber = badNumber;
	}

	
	
}
