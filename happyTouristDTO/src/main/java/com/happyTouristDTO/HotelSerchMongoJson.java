package com.happyTouristDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
@Document(collection="expedia_hotel_search")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelSerchMongoJson {
	
	/*@Id
	private String id;*/
	private HotelDto hotelRequestDto;
	private HotelResponseDto hotelResponseDto;
	public HotelDto getHotelRequestDto() {
		return hotelRequestDto;
	}
	public void setHotelRequestDto(HotelDto hotelRequestDto) {
		this.hotelRequestDto = hotelRequestDto;
	}
	public HotelResponseDto getHotelResponseDto() {
		return hotelResponseDto;
	}
	public void setHotelResponseDto(HotelResponseDto hotelResponseDto) {
		this.hotelResponseDto = hotelResponseDto;
	}
	/*public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}*/
}
