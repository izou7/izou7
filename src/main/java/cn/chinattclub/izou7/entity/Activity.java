package cn.chinattclub.izou7.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 活动实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity")
public class Activity {

	@Id
	@GeneratedValue
	private Integer id;
	/**
	 * 用户名
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user")
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;
	
	/**
	 * 活动名称
	 */
	private String name;
	
	/**
	 * 活动举办城市
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="city")
	private City city;
	
	/**
	 * 活动地址
	 */
	private String place;
	
	/**
	 * 地点横坐标
	 */
	@Column(name = "coordinate_x")
	private Float coordinateX;
	
	/**
	 * 地点纵坐标
	 */
	@Column(name = "coordinate_y")
	private Float coordinateY;
	
	/** 开始时间 **/
	@Column(name = "start_time")
	private Date startTime;
	
	/** 结束时间 **/
	@Column(name = "end_time")
	private Date endTime;
	
	/**
	 * 活动人数
	 */
	@Column(name = "head_count")
	private Integer headCount;
	
	
	/**
	 * 活动标签
	 */
	private String tags;
	
	/**
	 * 活动介绍
	 */
	private String introduction;
	
	/**
	 * 是否公开
	 */
	@Column(name="is_opened")
	private Boolean opened;
	
	/**
	 * 活动主页
	 */
	private String homepage;
	
	/**
	 * 活动状态0为已保存，1为已发布
	 */
	private Integer status;
	
//	@OneToMany(mappedBy="activity",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	private Set<ActivityPoster> activityPosters;
	
	/**
	 * 报名模板
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="apply_template_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private ApplyTemplate template;
	
	/**
	 * 票务信息
	 */
	@OneToMany
	@JoinColumn(name="activity")
	private Set<ActivityTicket> tickets;
	
	/**
	 * 文章
	 */
	@OneToMany
	@JoinColumn(name="activity")
	private Set<ActivityArticle> articles;
	
	/**
	 * 嘉宾
	 */
	@OneToMany
	@JoinColumn(name="activity")
	private Set<ActivityGuest> guests;
	
	/**
	 * 嘉宾设置
	 */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="activity")
	private Set<ActivityGuestsSetting> settings;
	
	/**
	 * 开放合作
	 */
	@OneToMany
	@JoinColumn(name="activity")
	private Set<ActivityCooperation> cooperations;
	
	/**
	 * 众筹回报设置
	 */
	@OneToMany
	@JoinColumn(name="activity")
	private Set<ActivityCrowdfundingReward> rewards;
	
	/**
	 * 众筹设置
	 */
	@OneToMany
	@JoinColumn(name="activity")
	private Set<ActivityCrowdfundingSetting> cfSettings;
	
	/** 
	 *  创建时间
	 */
	@Column(name = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
	private Date createTime;
	
	/** 
	 * 更新时间 
	 */
	@Column(name = "update_time", insertable = false, updatable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
	private Date updateTime;
	
	/**
	 * 海报url
	 */
	@Column(name="poster_url")
	private String posterUrl;

	/**
	 * Returns the value of the field called 'id'.
	 * @return Returns the id.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets the field called 'id' to the given value.
	 * @param id The id to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Returns the value of the field called 'user'.
	 * @return Returns the user.
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Sets the field called 'user' to the given value.
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
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
	 * Returns the value of the field called 'city'.
	 * @return Returns the city.
	 */
	public City getCity() {
		return this.city;
	}

	/**
	 * Sets the field called 'city' to the given value.
	 * @param city The city to set.
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * Returns the value of the field called 'place'.
	 * @return Returns the place.
	 */
	public String getPlace() {
		return this.place;
	}

	/**
	 * Sets the field called 'place' to the given value.
	 * @param place The place to set.
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * Returns the value of the field called 'coordinateX'.
	 * @return Returns the coordinateX.
	 */
	public Float getCoordinateX() {
		return this.coordinateX;
	}

	/**
	 * Sets the field called 'coordinateX' to the given value.
	 * @param coordinateX The coordinateX to set.
	 */
	public void setCoordinateX(Float coordinateX) {
		this.coordinateX = coordinateX;
	}

	/**
	 * Returns the value of the field called 'coordinateY'.
	 * @return Returns the coordinateY.
	 */
	public Float getCoordinateY() {
		return this.coordinateY;
	}

	/**
	 * Sets the field called 'coordinateY' to the given value.
	 * @param coordinateY The coordinateY to set.
	 */
	public void setCoordinateY(Float coordinateY) {
		this.coordinateY = coordinateY;
	}

	/**
	 * Returns the value of the field called 'startTime'.
	 * @return Returns the startTime.
	 */
	public Date getStartTime() {
		return this.startTime;
	}

	/**
	 * Sets the field called 'startTime' to the given value.
	 * @param startTime The startTime to set.
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Returns the value of the field called 'endTime'.
	 * @return Returns the endTime.
	 */
	public Date getEndTime() {
		return this.endTime;
	}

	/**
	 * Sets the field called 'endTime' to the given value.
	 * @param endTime The endTime to set.
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * Returns the value of the field called 'headCount'.
	 * @return Returns the headCount.
	 */
	public Integer getHeadCount() {
		return this.headCount;
	}

	/**
	 * Sets the field called 'headCount' to the given value.
	 * @param headCount The headCount to set.
	 */
	public void setHeadCount(Integer headCount) {
		this.headCount = headCount;
	}

	/**
	 * Returns the value of the field called 'tags'.
	 * @return Returns the tags.
	 */
	public String getTags() {
		return this.tags;
	}

	/**
	 * Sets the field called 'tags' to the given value.
	 * @param tags The tags to set.
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * Returns the value of the field called 'introduction'.
	 * @return Returns the introduction.
	 */
	public String getIntroduction() {
		return this.introduction;
	}

	/**
	 * Sets the field called 'introduction' to the given value.
	 * @param introduction The introduction to set.
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * Returns the value of the field called 'opened'.
	 * @return Returns the opened.
	 */
	public Boolean getOpened() {
		return this.opened;
	}

	/**
	 * Sets the field called 'opened' to the given value.
	 * @param opened The opened to set.
	 */
	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	/**
	 * Returns the value of the field called 'homepage'.
	 * @return Returns the homepage.
	 */
	public String getHomepage() {
		return this.homepage;
	}

	/**
	 * Sets the field called 'homepage' to the given value.
	 * @param homepage The homepage to set.
	 */
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	/**
	 * Returns the value of the field called 'status'.
	 * @return Returns the status.
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * Sets the field called 'status' to the given value.
	 * @param status The status to set.
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Returns the value of the field called 'createTime'.
	 * @return Returns the createTime.
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * Sets the field called 'createTime' to the given value.
	 * @param createTime The createTime to set.
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Returns the value of the field called 'updateTime'.
	 * @return Returns the updateTime.
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * Sets the field called 'updateTime' to the given value.
	 * @param updateTime The updateTime to set.
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public ApplyTemplate getTemplate() {
		return template;
	}

	public void setTemplate(ApplyTemplate template) {
		this.template = template;
	}


	/**
	 * Returns the value of the field called 'tickets'.
	 * @return Returns the tickets.
	 */
	public Set<ActivityTicket> getTickets() {
		return this.tickets;
	}

	/**
	 * Sets the field called 'tickets' to the given value.
	 * @param tickets The tickets to set.
	 */
	public void setTickets(Set<ActivityTicket> tickets) {
		this.tickets = tickets;
	}

	/**
	 * Returns the value of the field called 'guests'.
	 * @return Returns the guests.
	 */
	public Set<ActivityGuest> getGuests() {
		return this.guests;
	}

	/**
	 * Sets the field called 'guests' to the given value.
	 * @param guests The guests to set.
	 */
	public void setGuests(Set<ActivityGuest> guests) {
		this.guests = guests;
	}

	

	/**
	 * Returns the value of the field called 'settings'.
	 * @return Returns the settings.
	 */
	public Set<ActivityGuestsSetting> getSettings() {
		return this.settings;
	}

	/**
	 * Sets the field called 'settings' to the given value.
	 * @param settings The settings to set.
	 */
	public void setSettings(Set<ActivityGuestsSetting> settings) {
		this.settings = settings;
	}

	/**
	 * Returns the value of the field called 'articles'.
	 * @return Returns the articles.
	 */
	public Set<ActivityArticle> getArticles() {
		return this.articles;
	}

	/**
	 * Sets the field called 'articles' to the given value.
	 * @param articles The articles to set.
	 */
	public void setArticles(Set<ActivityArticle> articles) {
		this.articles = articles;
	}

	/**
	 * Returns the value of the field called 'cooperations'.
	 * @return Returns the cooperations.
	 */
	public Set<ActivityCooperation> getCooperations() {
		return this.cooperations;
	}

	/**
	 * Sets the field called 'cooperations' to the given value.
	 * @param cooperations The cooperations to set.
	 */
	public void setCooperations(Set<ActivityCooperation> cooperations) {
		this.cooperations = cooperations;
	}

	/**
	 * Returns the value of the field called 'rewards'.
	 * @return Returns the rewards.
	 */
	public Set<ActivityCrowdfundingReward> getRewards() {
		return this.rewards;
	}

	/**
	 * Sets the field called 'rewards' to the given value.
	 * @param rewards The rewards to set.
	 */
	public void setRewards(Set<ActivityCrowdfundingReward> rewards) {
		this.rewards = rewards;
	}

	/**
	 * Returns the value of the field called 'cfSettings'.
	 * @return Returns the cfSettings.
	 */
	public Set<ActivityCrowdfundingSetting> getCfSettings() {
		return this.cfSettings;
	}

	/**
	 * Sets the field called 'cfSettings' to the given value.
	 * @param cfSettings The cfSettings to set.
	 */
	public void setCfSettings(Set<ActivityCrowdfundingSetting> cfSettings) {
		this.cfSettings = cfSettings;
	}

	public String getPosterUrl() {
//		if(activityPosters!=null&&activityPosters.size()>0){
//			this.posterUrl = activityPosters.iterator().next().getPoster();  
//		}
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	
}
