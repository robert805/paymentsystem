package com.dao;

import java.util.List;

import com.entities.User;
import com.entities.UserActivities;

public interface UserActivitiesDao {
	
    public boolean saveOrUpdate(UserActivities userActivities);
    
    public List<UserActivities> list(User user);
 


}
