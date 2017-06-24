package com.dao;

import java.util.List;

import com.entities.UserDetails;

public interface UserDetailsDao {
	  
	 public boolean saveOrUpdate(UserDetails userDetails);
	  
	    public List<UserDetails> list();
	  
	    public UserDetails userById(int id);

}
