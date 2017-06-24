package com.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user_activities")
public class UserActivities {

	
	@Id
	@GeneratedValue
	private Integer user_activities_id;
	private Date date;
	private String ip;
	private String acitivity_type;
	private Integer user_id;
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getUser_activities_id() {
		return user_activities_id;
	}
	public void setUser_activities_id(Integer user_activities_id) {
		this.user_activities_id = user_activities_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getActivity_type() {
		return acitivity_type;
	}
	public void setActivity_type(String activity_type) {
		this.acitivity_type = activity_type;
	}
	@Override
	public String toString() {
		return "UserActivities [user_activities_id=" + user_activities_id + ", date=" + date
				+ ", activity_type=" + acitivity_type + ", user_id=" + user_id + "]";
	}
	
	
	
	
}
