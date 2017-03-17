package com.happyTourist.utils;

import java.util.Comparator;

import com.happyTouristDTO.Activities;

public class ValueComparator implements Comparator<Activities> {

	@Override
	public int compare(Activities o1, Activities o2) {
		if (o1 == o2)
			return 0;
		if (o1 == null || o1.getRecommendationScore() == null)
			return 1;
		if (o2 == null || o2.getRecommendationScore() == null)
			return -1;

		return o2.getRecommendationScore().compareTo(o1.getRecommendationScore());
	}


}
