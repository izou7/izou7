package cn.chinattclub.izou7.dto;

import java.util.Date;

import cn.chinattclub.izou7.enumeration.ActivityStep;

/**
 * 日程DTO
 * @author ZY
 *
 */
public class CalendarDto {

	private String title;
	
	private String start;
	
	private String end;
	
	private Integer id;
	
	private Boolean allDay = false;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getAllDay() {
		return allDay;
	}
	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}

	
	
	
}
