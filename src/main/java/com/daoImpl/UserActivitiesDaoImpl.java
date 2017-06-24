package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserActivitiesDao;
import com.entities.User;
import com.entities.UserActivities;

@Repository
@Transactional
public class UserActivitiesDaoImpl implements UserActivitiesDao {
	

    @Autowired
    SessionFactory session;

	public boolean saveOrUpdate(UserActivities userActivities) {
    
        session.getCurrentSession().saveOrUpdate(userActivities);
        return true;
    }
 
    public List<UserActivities> list(User user) {
        return session.getCurrentSession().createQuery("from UserActivities o where o.user_id = ?").setParameter(0, user.getUser_id()).list();
    }




	
}
