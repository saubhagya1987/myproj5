package com.happyTourist.serviceimpl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.happyTourist.exception.HappyTouristException;
import com.happyTourist.service.HappyTouristService;
import com.happyTourist.utils.RequestUtils;
import com.happyTouristDTO.HappyTouristDto;
import com.happyTouristDTO.TripRequestDto;
import com.happyTouristPersistence.dao.HappyTouristDao;

//@Component("ClearTrip")
@Component
@Profile("ClearTrip")
public class TouristServiceImpl implements HappyTouristService {
	
	@Autowired
	private HappyTouristDao happyTouristDao;
	@Autowired
	private MessageSource messageSource;
	
	private static final String GET_CLEARTRIP_URL = "get.cleatrip.url";
	private static final String CLEARTRIP_CLIENT_ID = "cleatrip.client.id";
	private static final String CLEARTRIP_CLIENT_SECRET = "cleatrip.client.secret";
	/**
	 * Gets the group name.
	 *
	 * @param happyTouristDto the happy tourist dto
	 * @return the group name
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HappyTouristDto getGroupName(Integer groupId, String groupAdminName)
			throws HappyTouristException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Gets the trip data.
	 *
	 * @param tripAdvisorDto the trip advisor dto
	 * @return the trip data
	 * @throws HappyTouristException the happy tourist exception
	 */

	@Override
	public TripRequestDto getTripData(TripRequestDto tripAdvisorDto) throws HappyTouristException {
		
		tripAdvisorDto.setClientId(messageSource.getMessage(CLEARTRIP_CLIENT_ID, null, Locale.getDefault()));
		tripAdvisorDto.setClientSecret(messageSource.getMessage(CLEARTRIP_CLIENT_SECRET, null, Locale.getDefault()));
		String url=messageSource.getMessage(GET_CLEARTRIP_URL, null, Locale.getDefault());
		TripRequestDto tripAdvisor=RequestUtils.getTripData(url,tripAdvisorDto);
		return tripAdvisor;
		
		
	}

}
