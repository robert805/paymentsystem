package com.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Shop {

	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
private int shop_id;
  
  private String name;
  private String address;

  private int phone;
  private String postalcode;
  private String voivodeship;
  private String link_send_data;
  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="user")
private User user;
  
public int getShop_id() {
	return shop_id;
}
public void setShop_id(int shop_id) {
	this.shop_id = shop_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getPostalcode() {
	return postalcode;
}
public void setPostalcode(String postalcode) {
	this.postalcode = postalcode;
}
public String getVoivodeship() {
	return voivodeship;
}
public void setVoivodeship(String voivodeship) {
	this.voivodeship = voivodeship;
}
public String getLink_send_data() {
	return link_send_data;
}
public void setLink_send_data(String link_send_data) {
	this.link_send_data = link_send_data;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Override
public String toString() {
	return "Shop [shop_id=" + shop_id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", postalcode="
			+ postalcode + ", voivodeship=" + voivodeship + ", link_send_data=" + link_send_data + ", user=" + user
			+ "]";
}
  
  
}
