package com.dao;

import java.util.List;

import com.entities.Shop;
import com.entities.User;
import com.entities.UserDetails;

public interface ShopDao {

	 public boolean saveOrUpdate(Shop shop);
	  
	    public List<Shop> list();
	  
	    public List<Shop> listWhereIdUserIs(User user);
	    
	    public Shop userById(int id);
	    
	    public Shop shopById(int id);
	    
	    public Shop shopByName(String name);
	
}
