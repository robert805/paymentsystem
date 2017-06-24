package com.services;



import java.util.List;

import com.entities.User;
import com.entities.UserActivities;

public interface UserActivitiesServices {
	
    public boolean saveOrUpdate(UserActivities userActivities);
    
    public List<UserActivities> list(User user);
 


}
