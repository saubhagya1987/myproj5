package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewSummaryCollection {
	 private List<ReviewSummary> reviewSummary;

	public List<ReviewSummary> getReviewSummary() {
		return reviewSummary;
	}

	public void setReviewSummary(List<ReviewSummary> reviewSummary) {
		this.reviewSummary = reviewSummary;
	}
}
