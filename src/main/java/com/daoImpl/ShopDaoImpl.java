package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ShopDao;
import com.entities.Shop;
import com.entities.User;
import com.entities.UserDetails;
@Repository
@Transactional
public class ShopDaoImpl implements ShopDao{
	
    @Autowired
    SessionFactory session;
 
   
 
    public List<Shop> list() {
        return session.getCurrentSession().createQuery("from Shop").list();
    }


    public List<Shop> listWhereIdUserIs(User user) {
        return session.getCurrentSession().createQuery("from Shop where user = ?").setParameter(0, user).list();
    }


	public Shop userById(int id) {
		 Shop shop = new Shop();
		 List<Shop> shops = session.getCurrentSession().createQuery("from Shop").list();
		 for(Shop r: shops){
		        if( r.getUser().getUser_id().equals(id)){ 
		         shop = r; 
		        }
		         }
		return shop;
	}
   
	
	
    

	public boolean saveOrUpdate(Shop shop) {
        // TODO Auto-generated method stub
        session.getCurrentSession().saveOrUpdate(shop);
        return true;
    }


	   public Shop shopByName(String name){
	         List<Shop> shops = session.getCurrentSession().createQuery("from Shop").list();
	         Shop shop = new Shop();
	         for(Shop r: shops){
	        if( r.getName().equals(name)){ 
	         shop= r;
	        }
	         }
	         return shop;
	    }


	public Shop shopById(int id) {
	
		return (Shop) session.getCurrentSession().get(Shop.class, id);
	}
	




}
