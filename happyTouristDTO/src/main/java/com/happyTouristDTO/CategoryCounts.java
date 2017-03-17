package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryCounts {
	    private String Couples;

	    private String Families;

	    private String BusinessTravelers;

	    private String Other;

	    private String Everyone;

		public String getCouples() {
			return Couples;
		}

		public void setCouples(String couples) {
			Couples = couples;
		}

		public String getFamilies() {
			return Families;
		}

		public void setFamilies(String families) {
			Families = families;
		}

		public String getBusinessTravelers() {
			return BusinessTravelers;
		}

		public void setBusinessTravelers(String businessTravelers) {
			BusinessTravelers = businessTravelers;
		}

		public String getOther() {
			return Other;
		}

		public void setOther(String other) {
			Other = other;
		}

		public String getEveryone() {
			return Everyone;
		}

		public void setEveryone(String everyone) {
			Everyone = everyone;
		}   

}
