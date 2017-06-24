package com.dao;

import java.util.List;

import com.entities.Transaction;
import com.entities.User;

 
public interface UsersDao {
	
    public boolean saveOrUpdate(User user);
 
    public List<User> list();
 
    public boolean delete(User user);
    
    public boolean exist(String name);
    
    public User userByName(String name);
    
    public boolean moneyTransfer(User userTake, User userGive);
    
}