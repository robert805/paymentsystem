package com.dao;

import java.util.List;



import com.entities.Card;

public interface CardDao {

	public boolean saveOrUpdate(Card card);
	
	public List<Card> list();
	
	public boolean exist(int number);
	
	public Card cardByNumber(int number);
}
