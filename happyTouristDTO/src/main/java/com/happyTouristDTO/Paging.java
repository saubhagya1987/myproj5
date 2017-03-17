package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paging {
	private Cursors cursors;

	public Cursors getCursors() {
		return cursors;
	}

	public void setCursors(Cursors cursors) {
		this.cursors = cursors;
	}

	 }
