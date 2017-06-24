package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sender_id")
	private User sender;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="recipent_id")
	private User recipent;
	private Double amount;
	private Date date;
	private String title;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	@ManyToOne
	@JoinColumn(name="recipent_id")
	public User getRecipent() {
		return recipent;
	}
	public void setRecipent(User recipent) {
		this.recipent = recipent;
	}
	
	
	public String toString() {
		return "Transaction [id=" + id + ", sender=" + sender + ", recipent=" + recipent + "]";
	}
	
	
	

}
