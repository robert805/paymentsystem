package com.services;

import java.util.List;

import com.entities.Shop;
import com.entities.User;

public interface ShopServices {

	 public boolean saveOrUpdate(Shop shop);
	  
	    public List<Shop> list();
	    
	    public List<Shop> listWhereIdUserIs(User user);
	  
	    public Shop userById(int id);
	    
	    public Shop shopByName(String name);
	    
	    public Shop shopById(int id);
}
