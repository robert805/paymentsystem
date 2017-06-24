package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDetailsDao;
import com.dao.UsersDao;
import com.entities.User;
import com.entities.UserDetails;

@Repository
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao {
 
    @Autowired
    SessionFactory session;
 
   
 
    public List<UserDetails> list() {
        return session.getCurrentSession().createQuery("from UserDetails").list();
    }



	public UserDetails userById(int id) {
		 UserDetails userDetails = new UserDetails();
		
	
		return (UserDetails) session.getCurrentSession().get(UserDetails.class, id);
	}



	public boolean saveOrUpdate(UserDetails userDetails) {
        // TODO Auto-generated method stub
        session.getCurrentSession().saveOrUpdate(userDetails);
        return true;
    }
	
	

  
}