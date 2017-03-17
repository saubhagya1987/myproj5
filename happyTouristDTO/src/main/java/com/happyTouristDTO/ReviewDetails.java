package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewDetails {
	
	private String startIndex;
	
	private ReviewSummaryCollection reviewSummaryCollection;

    private ReviewCollection reviewCollection;

    

    private String numberOfReviewsInThisPage;

	public String getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public String getNumberOfReviewsInThisPage() {
		return numberOfReviewsInThisPage;
	}

	public void setNumberOfReviewsInThisPage(String numberOfReviewsInThisPage) {
		this.numberOfReviewsInThisPage = numberOfReviewsInThisPage;
	}

	public ReviewSummaryCollection getReviewSummaryCollection() {
		return reviewSummaryCollection;
	}

	public void setReviewSummaryCollection(
			ReviewSummaryCollection reviewSummaryCollection) {
		this.reviewSummaryCollection = reviewSummaryCollection;
	}

	public ReviewCollection getReviewCollection() {
		return reviewCollection;
	}

	public void setReviewCollection(ReviewCollection reviewCollection) {
		this.reviewCollection = reviewCollection;
	}

    
}
