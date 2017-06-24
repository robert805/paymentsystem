package com.dao;

import java.util.List;



import com.entities.Transaction;
import com.entities.User;
import com.entities.UserDetails;

public interface TransactionDao {

	 public boolean saveOrUpdate(Transaction transaction);
	 
	    public List<Transaction> list(User user);
	    
	    public List<Transaction> list_recipent(User user);
	 
	    public boolean delete(Transaction transaction);
	    
	    public Transaction transacionById(int id);
	
	   
	   
}
