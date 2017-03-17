package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FacebookResponseDto {
	private List<Datum> data; 

	  private Paging2 paging;

	public List<Datum> getData() {
		return data;
	}

	public void setData(List<Datum> data) {
		this.data = data;
	}

	public Paging2 getPaging() {
		return paging;
	}

	public void setPaging(Paging2 paging) {
		this.paging = paging;
	}

	 
}
