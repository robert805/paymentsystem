package com.daoImpl;

import java.util.List;
import java.util.Random;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CardDao;
import com.entities.Card;
import com.entities.User;

@Repository
@Transactional
public class CardDaoImpl implements CardDao{
	
	@Autowired
	SessionFactory session;

	public boolean saveOrUpdate(Card card) {
	
		
		session.getCurrentSession().saveOrUpdate(card);
		
		return true;
	}

	
	public List<Card> list() {
		
		return session.getCurrentSession().createQuery("from Card").list();
	}


	public boolean exist(int number) {
	    return (session.getCurrentSession().createQuery("select 1 from Card where id =:cardid")
                .setInteger("cardid", number).uniqueResult() != null);
	}


	public Card cardByNumber(int number) {
		   List<Card> cards = session.getCurrentSession().createQuery("from Card").list();
	         Card card = new Card();
	         for(Card r: cards){
	        if( r.getId().equals(number)){ 
	         card= r;
	        }
	         }
	         return card;
	}



}
