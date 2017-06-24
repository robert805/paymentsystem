package com.services;

import java.util.List;

import com.entities.Shop;
import com.entities.ShopCard;
import com.entities.Transaction;
import com.entities.User;

public interface TransactionServices {

	 public boolean saveOrUpdate(Transaction transaction);
	 
	    public List<Transaction> list(User user);
	    
	    public List<Transaction> list_recipent(User user);
	 
	    public boolean delete(Transaction transaction);
	    
	    public Transaction transacionById(int id);
	    
	    public boolean cardPayment(List<ShopCard> listShopCardToUnactivate , int cardNumberToChangeMoney, Double moneyToTakeFromCard,Double userBalanceToTake, User user, String shopUser, String transaction_id, Shop shop);
	
	    public boolean cardPayment(List<ShopCard> listShopCardToUnactivate , Double userBalanceToTake, User user, String shopUser,String transaction_id, Shop shop);
}
