package com.happyTouristDTO;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoogleResponseDto {
	  private List<Object> html_attributions;
	  private String next_page_token;
	  private List<Result> results;
	  private String status;
	  private Result result;	  
	  
	  
	public List<Object> getHtml_attributions() {
		return html_attributions;
	}
	public void setHtml_attributions(List<Object> html_attributions) {
		this.html_attributions = html_attributions;
	}
	public String getNext_page_token() {
		return next_page_token;
	}
	public void setNext_page_token(String next_page_token) {
		this.next_page_token = next_page_token;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
}
