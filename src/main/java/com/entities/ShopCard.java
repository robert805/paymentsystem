package com.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "shop_card")
public class ShopCard {

	

	@Id
	
	private Integer shop_card_id;
	private double amount;
	private boolean active;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="shop")
	private Shop shop;
	
	
	@Override
	public String toString() {
		return "ShopCard [shop_card_id=" + shop_card_id + ", amount=" + amount + ", active=" + active + ", shop=" + shop
				+ "]";
	}
	public Integer getShop_card_id() {
		return shop_card_id;
	}
	public void setShop_card_id(Integer shop_card_id) {
		this.shop_card_id = shop_card_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
	
}
