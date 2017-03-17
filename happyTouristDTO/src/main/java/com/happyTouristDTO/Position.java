package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Position {
	
	private String type;
    private List<String> coordinates;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<String> coordinates) {
		this.coordinates = coordinates;
	}

}
