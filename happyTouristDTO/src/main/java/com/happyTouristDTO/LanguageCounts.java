package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LanguageCounts {

	 private String en;

	    public String getEn ()
	    {
	        return en;
	    }

	    public void setEn (String en)
	    {
	        this.en = en;
	    }
}
