package com.servicesImpl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.dao.ShopCardDao;
import com.dao.TransactionDao;
import com.dao.UsersDao;
import com.entities.Shop;
import com.entities.ShopCard;
import com.entities.Transaction;
import com.entities.User;
import com.other.RESTfull;
import com.services.TransactionServices;

@Service
public class TransactionServicesImpl implements TransactionServices {

	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	ShopCardDao shopCardDao;
	
	@Autowired
	UsersDao usersDao;
	
	public boolean saveOrUpdate(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionDao.saveOrUpdate(transaction);
	}

	public List<Transaction> list(User user) {
		// TODO Auto-generated method stub
		return transactionDao.list(user);
	}

	public boolean delete(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionDao.delete(transaction);
	}

	public List<Transaction> list_recipent(User user) {
		// TODO Auto-generated method stub
		return transactionDao.list_recipent(user);
	}

	public Transaction transacionById(int id) {
		
		return transactionDao.transacionById(id);
	}

	
	@Transactional(rollbackFor = Exception.class)
	public boolean cardPayment(List<ShopCard> listShopCardToUnactivate,
			int cardNumberToChangeMoney,
			Double moneyToTakeFromCard,
			Double userBalanceToTake,
			User user, 
			String shopUser, 
			String transaction_id, 
			Shop shop) {
		 String operation_title = "Zakupy w sklepie " + shop.getName() + " U¿yto kart podarunkowych. Numery kart: ";
		//pobranie ró¿nicy pieniêdzy
		 user = usersDao.userByName(user.getUsername());	
		 
		 System.out.println("CITI HESJHJFRKHDAF" + userBalanceToTake);

	Double diffrence;
	 
	diffrence = user.getBalance() -  userBalanceToTake;  
	System.out.println(diffrence);
		//zmiana aktywnoœæi statusu u¿ytych kart
	for(ShopCard a:listShopCardToUnactivate){
		operation_title= operation_title + " " + a.getShop_card_id() + " ";
		a.setActive(false);
		shopCardDao.saveOrUpdate(a);
	}
	
	//œci¹gniecie kasy z karty która przekroczy³a iloœæ do zap³aty i zostawienie statusu active na true
	ShopCard shopCard = shopCardDao.cardByNumber(cardNumberToChangeMoney);
	shopCard.setActive(true);
   shopCard.setAmount(shopCard.getAmount() - moneyToTakeFromCard);
    shopCardDao.saveOrUpdate(shopCard);

    
    
  //zmiana na koncie jeœli by³a dop³ata do kart podarunkowych
    //user = usersDao.userByName(user.getUsername());
    user.setBalance(userBalanceToTake);
    usersDao.saveOrUpdate(user);
    
   
    User shopUser1 =  usersDao.userByName(shopUser);
    shopUser1.setBalance(shopUser1.getBalance() + diffrence);
    usersDao.saveOrUpdate(shopUser1);
    
    
    Transaction transaction = new Transaction();
    transaction.setAmount(diffrence);
    transaction.setSender(user);
    transaction.setRecipent(shopUser1);
    transaction.setTitle(operation_title);
    transactionDao.saveOrUpdate(transaction);
    //Wysy³anie do sklepu statusu
    boolean statusCode = false;
    RESTfull rest = new RESTfull();
    try {
	statusCode =  rest.sendPost(shop.getLink_send_data(), "Posivite", transaction_id);
	} catch (Exception e) {
		
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			 
		 return false;
	      }
	}
	}
	
	
	
	@Transactional(rollbackFor = Exception.class)
	public boolean cardPayment(
			List<ShopCard> listShopCardToUnactivate, 
			 Double userBalanceToTake, 
			 User user, 
			 String shopUser, 
			 String transaction_id, 
			 Shop shop) {
		 String operation_title = "Zakupy w sklepie: " + shop.getName() + " U¿yto kart podarunkowych. Numery kart:";
		//pobranie ró¿nicy pieniêdzy
	Double diffrence = user.getBalance() -  userBalanceToTake;  
		
		//zmiana aktywnoœæi statusu u¿ytych kart
	for(ShopCard a:listShopCardToUnactivate){
		operation_title= operation_title + " "+ a.getShop_card_id() + " ";
		a.setActive(false);
		shopCardDao.saveOrUpdate(a);
	}
	
	
    
  //zmiana na koncie jeœli by³a dop³ata do kart podarunkowych
    user = usersDao.userByName(user.getUsername());
    user.setBalance(userBalanceToTake);
    usersDao.saveOrUpdate(user);
    
   
   User shopUser1 =  usersDao.userByName(shopUser);
    shopUser1.setBalance(shopUser1.getBalance() + diffrence);
    usersDao.saveOrUpdate(shopUser1);
    
    
    Transaction transaction = new Transaction();
    transaction.setAmount(diffrence);
    transaction.setSender(user);
	Calendar calendar = Calendar.getInstance();
    transaction.setDate(calendar.getTime());
    transaction.setRecipent(shopUser1);
    transaction.setTitle(operation_title);
    transactionDao.saveOrUpdate(transaction);
    //Wysy³anie do sklepu statusu
    
    boolean statusCode = false;
    RESTfull rest = new RESTfull();
    try {
	statusCode = 	rest.sendPost(shop.getLink_send_data(), "Posivite", transaction_id);
	} catch (Exception e) {
		
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
