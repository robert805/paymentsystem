package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TransactionDao;
import com.entities.Transaction;
import com.entities.User;
import com.entities.UserDetails;

@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    SessionFactory session;
	
    public boolean saveOrUpdate(Transaction transaction) {
		
    	session.getCurrentSession().saveOrUpdate(transaction);
		
		return true;
	}

	public List<Transaction> list(User user) {
		
		return session.getCurrentSession().createQuery("from Transaction where sender_id = ?").setParameter(0, user.getUser_id()).list();
	}
	
	public List<Transaction> list_recipent(User user) {
		
		return session.getCurrentSession().createQuery("from Transaction where recipent_id = ?").setParameter(0, user.getUser_id()).list();
	}
	

	public boolean delete(Transaction transaction) {

		try{
		session.getCurrentSession().delete(transaction);
		
		return true;
		}
		catch(Exception ex){
			return false;
			
		}
	}

	public Transaction transacionById(int id) {
		Transaction transaction = new Transaction();
		List<Transaction> transactionlist = session.getCurrentSession().createQuery("from Transaction").list();
		for(Transaction r: transactionlist){
	        if( r.getId().equals(id)){ 
	         transaction= r;
	        }
	         }
	return transaction;
	}

	
	public UserDetails userById(int id) {
		 UserDetails userDetails = new UserDetails();
		 List<UserDetails> users = session.getCurrentSession().createQuery("from UserDetails").list();
		 for(UserDetails r: users){
		        if( r.getUser_details_id().equals(id)){ 
		         userDetails= r;
		        }
		         }
		return userDetails;
	}
	
}
