package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpeningHours {	
	  private boolean open_now;
	  private List<Object> weekday_text;	  
	  private List<Periods> periods;    
	  
	  
	public boolean isOpen_now() {
		return open_now;
	}
	public void setOpen_now(boolean open_now) {
		this.open_now = open_now;
	}
	public List<Object> getWeekday_text() {
		return weekday_text;
	}
	public void setWeekday_text(List<Object> weekday_text) {
		this.weekday_text = weekday_text;
	}
	public List<Periods> getPeriods() {
		return periods;
	}
	public void setPeriods(List<Periods> periods) {
		this.periods = periods;
	}

	  

}
