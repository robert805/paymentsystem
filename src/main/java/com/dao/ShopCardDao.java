package com.dao;

import java.util.List;

import com.entities.Card;
import com.entities.Shop;
import com.entities.ShopCard;



public interface ShopCardDao {
	 public boolean saveOrUpdate(ShopCard shopCard);
	 
	    public List<ShopCard> list(Shop shop);
	    
	    public boolean exist(int number);
	   
		
	    
		public ShopCard cardByNumber(int number);
}
