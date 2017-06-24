package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user_details")
public class UserDetails {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer user_details_id;
	private String name;
	private String lastname;
	
	private int age;
	private String phone;
	
	private String adress;
	private String postalcode;
	private String voivodeship;
	private String account_type;
	
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
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
	@Override
	public String toString() {
		return "UserDetails [user_details_id=" + user_details_id + ", name=" + name + ", lastname=" + lastname
				+ ", age=" + age + ", phone=" + phone + "]";
	}
	public Integer getUser_details_id() {
		return user_details_id;
	}
	public void setUser_details_id(Integer user_details_id) {
		this.user_details_id = user_details_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
