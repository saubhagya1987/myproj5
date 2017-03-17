package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Photo {	
	  private int height;
	  private List<String> html_attributions;	  
	  private String photo_reference;
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public List<String> getHtml_attributions() {
		return html_attributions;
	}
	public void setHtml_attributions(List<String> html_attributions) {
		this.html_attributions = html_attributions;
	}
	public String getPhoto_reference() {
		return photo_reference;
	}
	public void setPhoto_reference(String photo_reference) {
		this.photo_reference = photo_reference;
	}
}
