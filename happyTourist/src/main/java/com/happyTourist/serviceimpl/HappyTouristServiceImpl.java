package com.happyTourist.serviceimpl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.happyTourist.exception.HappyTouristException;
import com.happyTourist.service.HappyTouristService;
import com.happyTourist.utils.RequestUtils;
import com.happyTouristDTO.HappyTouristDto;
import com.happyTouristDTO.TripRequestDto;
import com.happyTouristPersistence.dao.HappyTouristDao;
import com.happyTouristPersistence.entity.ChatGroup;

//@Component("TripAdvisor")
@Component
@Profile("TripAdvisor")
public class HappyTouristServiceImpl implements HappyTouristService {

	@Autowired
	private HappyTouristDao happyTouristDao;
	@Autowired
	private MessageSource messageSource;
	
	private static final String GET_TRIPADVISOR_URL = "get.trip.advisor.url";
	private static final String TRIPADVISOR_CLIENT_ID = "trip.advisor.client.id";
	private static final String TRIPADVISOR_CLIENT_SECRET = "trip.advisor.client.secret";
	
	/**
	 * Gets the group name.
	 *
	 * @param happyTouristDto the happy tourist dto
	 * @return the group name
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HappyTouristDto getGroupName(Integer groupId, String groupAdminName)	throws HappyTouristException {
		HappyTouristDto happyTouristDto = new HappyTouristDto();
		ChatGroup chatgGroup = happyTouristDao.getGroupId(groupAdminName,groupId);
		if (chatgGroup != null) {			
			happyTouristDto.setGroupName(chatgGroup.getGroupName());
		}

		return happyTouristDto;
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
		
		tripAdvisorDto.setClientId(messageSource.getMessage(TRIPADVISOR_CLIENT_ID, null, Locale.getDefault()));
		tripAdvisorDto.setClientSecret(messageSource.getMessage(TRIPADVISOR_CLIENT_SECRET, null, Locale.getDefault()));
		String url=messageSource.getMessage(GET_TRIPADVISOR_URL, null, Locale.getDefault());
		TripRequestDto tripAdvisor=RequestUtils.getTripData(url,tripAdvisorDto);
		return tripAdvisor;
		
		
	}

}
