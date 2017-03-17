package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingOptions {
	
	 private List<BookingItems> BookingItems;

	public List<BookingItems> getBookingItems() {
		return BookingItems;
	}

	public void setBookingItems(List<BookingItems> bookingItems) {
		BookingItems = bookingItems;
	}

}
