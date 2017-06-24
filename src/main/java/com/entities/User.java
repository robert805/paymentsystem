package com.entities;
 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer user_id;
    @NotEmpty(message= "Nie mo¿e byæ puste")
    @Email(message= "Podany adres nie jest zgodny z formatem email")
    @Column(name = "username")
    private String username;
    @NotEmpty(message= "Nie mo¿e byæ puste")
    @Column(name = "password")
    private String password;
    private Double balance;
    
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_details_id", insertable = false, updatable = false)
	
    private UserDetails userDetails;
    
    
    
  

	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	private Integer user_role_id;

	private Integer user_details_id;
	private boolean active;
    
	
	public Integer getUser_details_id() {
		return user_details_id;
	}
	public void setUser_details_id(Integer user_details_id) {
		this.user_details_id = user_details_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Integer getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(Integer user_role_id) {
		this.user_role_id = user_role_id;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", user_role_id="
				+ user_role_id + ", active=" + active + "]";
	}

    
    
    
    


 
}

	
