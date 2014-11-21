package cn.chinattclub.izou7.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * 用户实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 秘钥
	 */
	@Column(name = "secret_key")
	private String key;
	/**
	 * 是否上锁
	 */
	private Boolean locked = Boolean.FALSE;
	
	/**
	 * 账号来源
	 */
	private Integer source = 0;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "i_activity_join", joinColumns = @JoinColumn(name = "user"), inverseJoinColumns = @JoinColumn(name = "activity"))
	@NotFound(action = NotFoundAction.IGNORE)
	public List<Activity> activitys;

	/**
	 * 关联用户信息
	 */
	@OneToOne
	@JoinColumn(name = "user_info_id")
	private UserInfo userInfo;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Public> pub;

	public List<Public> getPub() {
		return pub;
	}

	public void setPub(List<Public> pub) {
		this.pub = pub;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public List<Activity> getActivitys() {
		return activitys;
	}

	public void setActivitys(List<Activity> activitys) {
		this.activitys = activitys;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

}
