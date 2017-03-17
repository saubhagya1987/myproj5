package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reviews {
	
	private String time;
    private String text;
    private String profile_photo_url;
    private String author_url;
    private String author_name;
    private List<Aspects> aspects;
    private String rating;
    private String language;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getProfile_photo_url() {
		return profile_photo_url;
	}
	public void setProfile_photo_url(String profile_photo_url) {
		this.profile_photo_url = profile_photo_url;
	}
	public String getAuthor_url() {
		return author_url;
	}
	public void setAuthor_url(String author_url) {
		this.author_url = author_url;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public List<Aspects> getAspects() {
		return aspects;
	}
	public void setAspects(List<Aspects> aspects) {
		this.aspects = aspects;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}


}
