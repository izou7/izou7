package cn.chinattclub.izou7.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import cn.chinattclub.izou7.entity.ActivityTicket;
import cn.chinattclub.izou7.enumeration.ActivityExecuteType;


/**
 * 活动票务信息DTO
 * @author ZY
 *
 */
public class ActivityTicketDto {
	private static final DateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd");

	/**
	 * 活动ID
	 */
	private Integer id;
	
	@NotNull
	private Integer activity;
	
	private boolean free;
	
	@Range(min=0, max=10000,message="票价应在0到10000元之间")
	private Integer price;
	
	@Range(min=0, max=10000,message="限额应在0到10000张之间")
	private Integer limit;
	
	private String ticketSaleStartTime;
	
	private String ticketSaleEndTime;
	
	private String ticketValidStartTime;
	
	private String ticketValidEndTime;
	
	@Length(min=0, max=65536)
	private String introduction;
	
	private ActivityExecuteType type;

	/**
	 * Returns the value of the field called 'activity'.
	 * @return Returns the activity.
	 */
	public Integer getActivity() {
		return this.activity;
	}

	/**
	 * Sets the field called 'activity' to the given value.
	 * @param activity The activity to set.
	 */
	public void setActivity(Integer activity) {
		this.activity = activity;
	}


	/**
	 * Returns the value of the field called 'price'.
	 * @return Returns the price.
	 */
	public Integer getPrice() {
		return this.price;
	}

	/**
	 * Sets the field called 'price' to the given value.
	 * @param price The price to set.
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * Returns the value of the field called 'limit'.
	 * @return Returns the limit.
	 */
	public Integer getLimit() {
		return this.limit;
	}

	/**
	 * Sets the field called 'limit' to the given value.
	 * @param limit The limit to set.
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * Returns the value of the field called 'ticketSaleStartTime'.
	 * @return Returns the ticketSaleStartTime.
	 */
	public String getTicketSaleStartTime() {
		return this.ticketSaleStartTime;
	}

	/**
	 * Sets the field called 'ticketSaleStartTime' to the given value.
	 * @param ticketSaleStartTime The ticketSaleStartTime to set.
	 */
	public void setTicketSaleStartTime(String ticketSaleStartTime) {
		this.ticketSaleStartTime = ticketSaleStartTime;
	}

	/**
	 * Returns the value of the field called 'ticketSaleEndTime'.
	 * @return Returns the ticketSaleEndTime.
	 */
	public String getTicketSaleEndTime() {
		return this.ticketSaleEndTime;
	}

	/**
	 * Sets the field called 'ticketSaleEndTime' to the given value.
	 * @param ticketSaleEndTime The ticketSaleEndTime to set.
	 */
	public void setTicketSaleEndTime(String ticketSaleEndTime) {
		this.ticketSaleEndTime = ticketSaleEndTime;
	}

	/**
	 * Returns the value of the field called 'ticketValidStartTime'.
	 * @return Returns the ticketValidStartTime.
	 */
	public String getTicketValidStartTime() {
		return this.ticketValidStartTime;
	}

	/**
	 * Sets the field called 'ticketValidStartTime' to the given value.
	 * @param ticketValidStartTime The ticketValidStartTime to set.
	 */
	public void setTicketValidStartTime(String ticketValidStartTime) {
		this.ticketValidStartTime = ticketValidStartTime;
	}

	/**
	 * Returns the value of the field called 'ticketValidEndTime'.
	 * @return Returns the ticketValidEndTime.
	 */
	public String getTicketValidEndTime() {
		return this.ticketValidEndTime;
	}

	/**
	 * Sets the field called 'ticketValidEndTime' to the given value.
	 * @param ticketValidEndTime The ticketValidEndTime to set.
	 */
	public void setTicketValidEndTime(String ticketValidEndTime) {
		this.ticketValidEndTime = ticketValidEndTime;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Returns the value of the field called 'free'.
	 * @return Returns the free.
	 */
	public boolean isFree() {
		return this.free;
	}

	/**
	 * Sets the field called 'free' to the given value.
	 * @param free The free to set.
	 */
	public void setFree(boolean free) {
		this.free = free;
	}

	/**
	 * Returns the value of the field called 'type'.
	 * @return Returns the type.
	 */
	public ActivityExecuteType getType() {
		return this.type;
	}

	/**
	 * Sets the field called 'type' to the given value.
	 * @param type The type to set.
	 */
	public void setType(ActivityExecuteType type) {
		this.type = type;
	}

	/**
	 * @return
	 * @throws ParseException
	 */
	public ActivityTicket convert(ActivityTicket persistenceTicket) throws ParseException{
		ActivityTicket ticket = null;
		if(persistenceTicket!=null){
			ticket = persistenceTicket;
		}else{
			ticket = new ActivityTicket();
		}
		ticket.setFree(free);
		ticket.setId(id);
		ticket.setActivity(activity);
		if(free){
			return ticket;
		}
		ticket.setIntroduction(introduction);
		ticket.setLimit(limit);
		ticket.setPrice(price);
		if(StringUtils.isNotBlank(ticketSaleEndTime)){
			ticket.setTicketSaleEndTime(df.parse(ticketSaleEndTime));
		}
		if(StringUtils.isNotBlank(ticketSaleStartTime)){
			ticket.setTicketSaleStartTime(df.parse(ticketSaleStartTime));
		}
		if(StringUtils.isNotBlank(ticketValidEndTime)){
			ticket.setTicketValidEndTime(df.parse(ticketValidEndTime));
		}
		if(StringUtils.isNotBlank(ticketValidStartTime)){
			ticket.setTicketValidStartTime(df.parse(ticketValidStartTime));
		}
		return ticket;
	}
	
	
}
