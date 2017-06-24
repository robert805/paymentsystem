package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDetailsDao;
import com.dao.UsersDao;
import com.entities.UserDetails;
import com.services.UserDetailsServices;

@Service
public class UserDetailServicesImpl implements UserDetailsServices{

	 @Autowired
	    UserDetailsDao userDetailsDao;
	
	public List<UserDetails> list() {
		// TODO Auto-generated method stub
		return userDetailsDao.list();
	}

	public UserDetails userById(int id) {
		// TODO Auto-generated method stub
		return userDetailsDao.userById(id);
	}

	public boolean saveOrUpdate(UserDetails userDetails) {
		
		return userDetailsDao.saveOrUpdate(userDetails);
	}


	
	

}
