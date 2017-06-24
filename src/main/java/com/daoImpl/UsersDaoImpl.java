package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UsersDao;
import com.entities.Transaction;
import com.entities.User;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {
 
    @Autowired
    SessionFactory session;
 
    public boolean saveOrUpdate(User user) {
        // TODO Auto-generated method stub
        session.getCurrentSession().saveOrUpdate(user);
        return true;
    }
 
    public List<User> list() {
        return session.getCurrentSession().createQuery("from User").list();
    }
    
    public User userByName(String name){
         List<User> users = session.getCurrentSession().createQuery("from User").list();
         User user = new User();
         for(User r: users){
        if( r.getUsername().equals(name)){ 
         user= r;
        }
         }
         return user;
    }
 
    public boolean delete(User user) {
        try {
            session.getCurrentSession().delete(user);
        } catch (Exception ex) {
            return false;
        }
 
        return true;
    }
    
    public boolean exist(String name) {
    return (
    	
    		
    session.getCurrentSession().createQuery("select 1 from User where username =:usernamee")
                                         .setString("usernamee", name).uniqueResult() != null);
         
          
    }

	public boolean moneyTransfer(User userTake, User userGive) {
		
		return false;
		
	}


   

    
  
}