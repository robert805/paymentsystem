package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserActivitiesDao;
import com.entities.User;
import com.entities.UserActivities;
import com.services.UserActivitiesServices;

@Service
public class UserActivitiesServicesImpl implements UserActivitiesServices {

	@Autowired
	UserActivitiesDao userActivitiesDao;
	
	public boolean saveOrUpdate(UserActivities userActivities) {
		// TODO Auto-generated method stub
		return userActivitiesDao.saveOrUpdate(userActivities);
	}

	public List<UserActivities> list(User user) {
		// TODO Auto-generated method stub
		return userActivitiesDao.list(user);
	}

}
