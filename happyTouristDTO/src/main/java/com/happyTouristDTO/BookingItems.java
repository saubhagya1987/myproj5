package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingItems {
	
	private String Status;

    private String Deeplink;

    private List<String> SegmentIds;

    private String Price;

    private String AgentID;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDeeplink() {
		return Deeplink;
	}

	public void setDeeplink(String deeplink) {
		Deeplink = deeplink;
	}

	public List<String> getSegmentIds() {
		return SegmentIds;
	}

	public void setSegmentIds(List<String> segmentIds) {
		SegmentIds = segmentIds;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getAgentID() {
		return AgentID;
	}

	public void setAgentID(String agentID) {
		AgentID = agentID;
	}

}
