package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Periods {
	private Open open;
    private Close close;
	public Open getOpen() {
		return open;
	}
	public void setOpen(Open open) {
		this.open = open;
	}
	public Close getClose() {
		return close;
	}
	public void setClose(Close close) {
		this.close = close;
	}
}
