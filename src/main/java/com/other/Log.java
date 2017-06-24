package com.other;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.entities.User;
import com.entities.UserActivities;
import com.services.UserActivitiesServices;

public class Log {
	
	public UserActivities log(User user, String activity_type, String ip_address){

	Calendar calendar = Calendar.getInstance();
	
    UserActivities userActivities = new UserActivities();
    userActivities.setActivity_type(activity_type);
    userActivities.setUser_id(user.getUser_id());
    userActivities.setDate(calendar.getTime());
    userActivities.setIp(ip_address);
	return userActivities;
	
	
	}
	
	public String actual_date(){
		Calendar calendar = Calendar.getInstance();
		 DateFormat format = new SimpleDateFormat("dd - MM - yyyy");
		 String date = format.format(calendar.getTime());
	return date;	
	}
	

}
