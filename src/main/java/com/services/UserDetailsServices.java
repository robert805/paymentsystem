package com.services;

import java.util.List;

import com.entities.UserDetails;


public interface UserDetailsServices {
    public List<UserDetails> list();
	  
    public UserDetails userById(int id);
    
    public boolean saveOrUpdate(UserDetails userDetails);
}
