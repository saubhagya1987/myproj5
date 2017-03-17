package com.happyTouristPersistence.hotelSearch.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.happyTouristDTO.HotelDto;
import com.happyTouristDTO.HotelList;
import com.happyTouristDTO.HotelResponseDto;
import com.happyTouristDTO.HotelSerchMongoJson;
import com.happyTouristPersistence.hotelSearch.dao.HotelSearch;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@Repository
public class HotelSearchDaoImpl implements HotelSearch{
	
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	private MessageSource messageSource;
	private static final String MONGO_DB="mongodb.db";
	private static final String MONGO_DB_URL="mongodb.url";
	private static final String MONGO_DB_PORT="mongodb.db.port";
	
	
	
	
	/*@Override
	public void save(HotelSerchMongoJson hotelSerchMongoJson) {
		if (hotelSerchMongoJson != null) {
			   this.mongoTemplate.insert(hotelSerchMongoJson, EXPEDIA_HOTEL_SEARCH_COLLECTION);
			  }
		
	}*/
	/**
	 * Saving  hotel data.
	 *
	 */
	@Override
	public void save(HotelResponseDto hotelResponseDto,HotelDto hotelDto) {
		if (hotelResponseDto != null) {
			   //this.mongoTemplate.insert(hotelResponseDto, hotelDto.getLatitude()+"_lat"+hotelDto.getLongitude()+"_long");
			   
			   List<HotelList> List=hotelResponseDto.getHotelList();
			   
			   for (HotelList hotelList : List) {
				   hotelList.setDeepLinkUrl(hotelResponseDto.getDeepLinkUrl());
				   if(hotelDto.getLatitude()==null && hotelDto.getLongitude()==null){
					   this.mongoTemplate.insert(hotelList, hotelDto.getCheckInDate()+"_chkInDate"+hotelDto.getCheckOutDate()+"_chkOutDate"+hotelDto.getCity());
				   }
				   else{
					   this.mongoTemplate.insert(hotelList, hotelDto.getLatitude()+"_lat"+hotelDto.getLongitude()+"_long");
				   }
			   	}
			  }
		
	}
	

	/*@Override
	public List<HotelSerchMongoJson> find(HotelDto hotelDto) {				
			Query query = new Query();			
			if(hotelDto.getLatitude()!=null && hotelDto.getLongitude()!=null){
			query.addCriteria(Criteria.where("hotelRequestDto.city").is(hotelDto.getCity()).and("hotelRequestDto.checkInDate").is(hotelDto.getCheckInDate()).and
					("hotelRequestDto.checkOutDate").is(hotelDto.getCheckOutDate()).and("hotelRequestDto.room1").is(hotelDto.getRoom1()).and
					("hotelRequestDto.latitude").is(hotelDto.getLatitude()).and("hotelRequestDto.longitude").is(hotelDto.getLongitude()));
			}
			else{
				query.addCriteria(Criteria.where("hotelRequestDto.city").is(hotelDto.getCity()).and("hotelRequestDto.checkInDate").is(hotelDto.getCheckInDate()).and
						("hotelRequestDto.checkOutDate").is(hotelDto.getCheckOutDate()).and("hotelRequestDto.room1").is(hotelDto.getRoom1()));
			}
			List<HotelSerchMongoJson> listUser = mongoTemplate.find(query,HotelSerchMongoJson.class);			
			return listUser;
			
			
			List<HotelSerchMongoJson> listUser = mongoTemplate.findAll(HotelSerchMongoJson.class);
			System.out.println("4. Number of user = " + listUser.size());
		
			return null;
		
	}*/

	/*@Override
	public List<HotelSerchMongoJson> findExistingData(HotelDto hotelDto) {
		Query query = new Query();			
		query.addCriteria(Criteria.where("hotelRequestDto").is(hotelDto));			
		List<HotelSerchMongoJson> listUser = mongoTemplate.find(query,HotelSerchMongoJson.class);			
		return listUser;
	}
*/
	
	/**
	 * All hotel search data.
	 *
	 * @param hotelDto the hotel dto
	 * 
	 * 
	 */
	@Override
	public HotelResponseDto findExistingData(HotelDto hotelDto) {
		//int  port=Integer.parseInt(MONGO_DB_PORT);
		MongoClient mongo = new MongoClient(messageSource.getMessage(MONGO_DB_URL, null, Locale.getDefault()), Integer.parseInt(messageSource.getMessage(MONGO_DB_PORT, null, Locale.getDefault())));
        DB db = mongo.getDB(messageSource.getMessage(MONGO_DB, null, Locale.getDefault()));
        DBCollection collection =null;
        
        if(hotelDto.getLatitude() !=null && hotelDto.getLongitude()!=null){
         collection = db.getCollection(hotelDto.getLatitude()+"_lat"+hotelDto.getLongitude()+"_long");
        }
        else{
        	collection = db.getCollection(hotelDto.getCheckInDate()+"_chkInDate"+hotelDto.getCheckOutDate()+"_chkOutDate"+hotelDto.getCity());
        }
		DBCursor cursor = collection.find();		
		HotelResponseDto myJSONObject=null;		
		while(cursor.hasNext()) {		    
				DBObject jsonString=cursor.next();				
				myJSONObject = mongoTemplate.getConverter().read(HotelResponseDto.class, jsonString); 
		}
		return myJSONObject;
	}
	
	/**
	 * All hotel search data.
	 *
	 * @param hotelDto the hotel dto
	 * 
	 * 
	 */	
	@Override
	public HotelResponseDto find(HotelDto hotelDto,int limitCount,int numberOfElements) {
		//int  port=Integer.parseInt(MONGO_DB_PORT);
		MongoClient mongo = new MongoClient(messageSource.getMessage(MONGO_DB_URL, null, Locale.getDefault()), Integer.parseInt(messageSource.getMessage(MONGO_DB_PORT, null, Locale.getDefault())));
        DB db = mongo.getDB(messageSource.getMessage(MONGO_DB, null, Locale.getDefault()));
        DBCollection collection =null;
        if(hotelDto.getLatitude() !=null && hotelDto.getLongitude()!=null){
             collection = db.getCollection(hotelDto.getLatitude()+"_lat"+hotelDto.getLongitude()+"_long");
        }
        else{
        	 collection = db.getCollection(hotelDto.getCheckInDate()+"_chkInDate"+hotelDto.getCheckOutDate()+"_chkOutDate"+hotelDto.getCity());
        }
		DBCursor cursor = collection.find().limit(limitCount).skip(numberOfElements);		
		HotelResponseDto myJSONObject= new HotelResponseDto();		
		List<HotelList> hotelListObj = new ArrayList<HotelList>();		
		while(cursor.hasNext()) {		    
				DBObject jsonString=cursor.next();				
				HotelList hotel = mongoTemplate.getConverter().read(HotelList.class, jsonString); 
				hotelListObj.add(hotel);
		}		
		myJSONObject.setHotelList(hotelListObj);
		return myJSONObject;
		
	}
	
	
	
}
