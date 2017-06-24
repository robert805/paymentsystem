package com.services;

import java.util.List;

import com.entities.Shop;
import com.entities.Transaction;
import com.entities.User;


public interface UserServices {
    public boolean saveOrUpdate(User user);
    
    public List<User> list();
 
    public boolean delete(User user);
    
    public boolean exist(String name);
    
    public User userByName(String name);
    
    
    public boolean moneyTransfer(User userTake, User userGive, Double money);
    
    public boolean moneyTransferToShop(User userTake, User userGive, Double money, Shop shop, String transaction_id);
}
