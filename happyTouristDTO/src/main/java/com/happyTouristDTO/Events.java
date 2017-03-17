package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Events {
	  private List<Datum2> data;	  
	  private Paging paging;
	public List<Datum2> getData() {
		return data;
	}
	public void setData(List<Datum2> data) {
		this.data = data;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	  }
