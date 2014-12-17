package cn.chinattclub.izou7.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "i_public")
public class Public {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="wechat_id")
	@NotBlank(message="公众账号微信ID不能为空")
	@Length(min=1,max=100,message="公众账号微信ID长度应该在1到100之间")
	private String wechatId;
	
	@Column(name="public_name")
	@NotBlank(message="公众号名称不能为空")
	@Length(min=1,max=100,message="公众号名称长度应该在1到100之间")
	private String publicName;
	
	@NotBlank(message="标签不能为空")
	private String tags;
	
	private String description;	
	
	@Column(name="is_mine")
	private boolean mine;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="update_time")
	private Date updateTime;
	
	@OneToMany(mappedBy="pub", cascade=CascadeType.ALL)
	private List<Article> article;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getPublicName() {
		return publicName;
	}

	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}


}
