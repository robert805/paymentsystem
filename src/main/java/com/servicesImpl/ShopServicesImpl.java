package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ShopDao;
import com.dao.UserDetailsDao;
import com.entities.Shop;
import com.entities.User;
import com.services.ShopServices;

@Service
public class ShopServicesImpl implements ShopServices{

	@Autowired
    ShopDao shopDao;

	public boolean saveOrUpdate(Shop shop) {
	 return	shopDao.saveOrUpdate(shop);
		
	}

	public List<Shop> list() {
		// TODO Auto-generated method stub
		return shopDao.list();
	}
	
	

	public Shop userById(int id) {
		// TODO Auto-generated method stub
		return shopDao.userById(id);
	}
	
	public Shop shopByName(String name) {
		// TODO Auto-generated method stub
		return shopDao.shopByName(name);
	}

	public List<Shop> listWhereIdUserIs(User user) {
		// TODO Auto-generated method stub
		return shopDao.listWhereIdUserIs(user);
	}

	public Shop shopById(int id) {
		// TODO Auto-generated method stub
		return shopDao.shopById(id);
	}

	
}
