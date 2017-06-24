package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ShopCardDao;
import com.entities.Shop;
import com.entities.ShopCard;
import com.entities.Transaction;
import com.entities.User;


@Repository
@Transactional
public class ShopCardDaoImpl implements ShopCardDao{

	@Autowired
	SessionFactory session;
	
public List<ShopCard> list(Shop shop) {
		
		return session.getCurrentSession().createQuery("from ShopCard where shop = ?").setParameter(0, shop).list();
	}

public boolean saveOrUpdate(ShopCard shopCard) {
    // TODO Auto-generated method stub
    session.getCurrentSession().saveOrUpdate(shopCard);
    return true;
}

public boolean exist(int number) {
    return (session.getCurrentSession().createQuery("select 1 from ShopCard where shop_card_id =:cardid")
            .setInteger("cardid", number).uniqueResult() != null);
}

public ShopCard cardByNumber(int number) {
	return (ShopCard)(session.getCurrentSession().get(ShopCard.class, number));
	
}



}
