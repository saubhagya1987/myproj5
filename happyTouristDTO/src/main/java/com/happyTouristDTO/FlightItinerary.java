package com.happyTouristDTO;

import java.util.List;

public class FlightItinerary {
	
	 private String InboundLegId;
	 private FlightBookingDetailsLink BookingDetailsLink;
	 private String OutboundLegId;
	 private List<PricingOptions> PricingOptions;
	
	public List<PricingOptions> getPricingOptions() {
		return PricingOptions;
	}
	public void setPricingOptions(List<PricingOptions> pricingOptions) {
		PricingOptions = pricingOptions;
	}
	public String getInboundLegId() {
		return InboundLegId;
	}
	public void setInboundLegId(String inboundLegId) {
		InboundLegId = inboundLegId;
	}
	public FlightBookingDetailsLink getBookingDetailsLink() {
		return BookingDetailsLink;
	}
	public void setBookingDetailsLink(FlightBookingDetailsLink bookingDetailsLink) {
		BookingDetailsLink = bookingDetailsLink;
	}
	public String getOutboundLegId() {
		return OutboundLegId;
	}
	public void setOutboundLegId(String outboundLegId) {
		OutboundLegId = outboundLegId;
	}

}
