package com.servicesImpl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.dao.TransactionDao;
import com.dao.UsersDao;
import com.entities.Shop;
import com.entities.Transaction;
import com.entities.User;
import com.other.RESTfull;
import com.services.UserServices;


@Service
public class UserServicesImpl implements UserServices{

	  @Autowired
	  UsersDao userDao;
	  
	  @Autowired
	  TransactionDao transactionDao;
	 
	    public boolean saveOrUpdate(User user) {
	        return userDao.saveOrUpdate(user);
	    }
	 
	    public List<User> list() {
	        // TODO Auto-generated method stub
	        return userDao.list();
	    }
	 
	    public boolean delete(User user) {
	        // TODO Auto-generated method stub
	        return userDao.delete(user);
	    }

		public boolean exist(String name) {
			// TODO Auto-generated method stub
			return userDao.exist(name);
		}

		public User userByName(String name) {
			// TODO Auto-generated method stub
			return userDao.userByName(name);
		}

		
		@Transactional
		public boolean moneyTransfer(User userTake, User userGive, Double money) {
			System.out.println("Rozpoczecie transakcji:");
			Double nadawca = userTake.getBalance();
			userTake.setBalance(nadawca - money);
			userDao.saveOrUpdate(userTake);
			System.out.println("Odebranie pieniêdzy z konta adresata pomyœlnie zakonczone!");
			Double odbiorca = userGive.getBalance();
			userGive.setBalance(odbiorca + money); 
			
	     //   System.exit(0);
			
			userDao.saveOrUpdate(userGive);
			System.out.println("Dodanie pieniêdzy na konto odbiorcy pomyœlnie zakonczone!");
			
			return false;
		}

		@Transactional
		public boolean moneyTransferToShop(User userTake, User userGive, Double money, Shop shop, String transaction_id) {
			System.out.println("Rozpoczecie transakcji:");
			
			userTake = userDao.userByName(userTake.getUsername());
			userGive = userDao.userByName(userGive.getUsername());
			
			userTake.setBalance(userTake.getBalance() - money);
			userDao.saveOrUpdate(userTake);
			System.out.println("Odebranie pieniêdzy z konta adresata pomyœlnie zakonczone!");
			userGive.setBalance(userGive.getBalance() + money); 
			
	        //System.exit(0);
			
			userDao.saveOrUpdate(userGive);
			System.out.println("Dodanie pieniêdzy na konto odbiorcy pomyœlnie zakonczone!");
			
			//tworzenie transakcji
			Transaction transaction = new Transaction();
			transaction.setSender(userTake);
            transaction.setRecipent(userGive);		
            transaction.setAmount(money);
            transaction.setTitle("Zakupy w sklepie" + shop.getName());
            Calendar calendar = Calendar.getInstance();
            transaction.setDate(calendar.getTime());
            transactionDao.saveOrUpdate(transaction);
            
			//wys³anie HTTP POST REQUEST ¯e Commit
			boolean statusCode = false;
			RESTfull rest = new RESTfull();
			try {
				statusCode = rest.sendPost(shop.getLink_send_data(), "Posivite", transaction_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 if(statusCode){
					
				 return true;
				}
			 
			 else{
				 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				 try {
					 int x = 10/0;
						throw new java.lang.Exception();
					} 
				 finally{
					 
				 return false;
			      }
			 }
		}
 
	 
	  
	}