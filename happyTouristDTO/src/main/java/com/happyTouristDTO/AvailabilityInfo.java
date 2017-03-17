package com.happyTouristDTO;

import java.util.List;

public class AvailabilityInfo {
	private List<Tickets> tickets;
    private Availabilities availabilities;
	public List<Tickets> getTickets() {
		return tickets;
	}
	public void setTickets(List<Tickets> tickets) {
		this.tickets = tickets;
	}
	public Availabilities getAvailabilities() {
		return availabilities;
	}
	public void setAvailabilities(Availabilities availabilities) {
		this.availabilities = availabilities;
	}

}
