package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CardDao;
import com.entities.Card;
import com.services.CardServices;

@Service
public class CardServicesImpl implements CardServices {

	@Autowired
	CardDao cardDao;
	
	
	public boolean saveOrUpdate(Card card) {
		
		return cardDao.saveOrUpdate(card);
	}


	public List<Card> list() {
		
		return cardDao.list();
	}


	public boolean exist(int number) {
		
		return cardDao.exist(number);
	}


	public Card cardByNumber(int number) {
	
		return cardDao.cardByNumber(number);
	}
	
	

}
