package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ShopCardDao;
import com.entities.Shop;
import com.entities.ShopCard;
import com.services.ShopCardServices;

@Service
public class ShopCardServicesImpl implements ShopCardServices {

	@Autowired
	ShopCardDao shopCardDao;
	
	public boolean saveOrUpdate(ShopCard shopCard) {
		// TODO Auto-generated method stub
		return shopCardDao.saveOrUpdate(shopCard);
	}

	public List<ShopCard> list(Shop shop) {
		// TODO Auto-generated method stub
		return shopCardDao.list(shop);
	}

	public boolean exist(int number) {
		// TODO Auto-generated method stub
		return shopCardDao.exist(number);
	}

	public ShopCard cardByNumber(int number) {
		// TODO Auto-generated method stub
		return shopCardDao.cardByNumber(number);
	}

}
