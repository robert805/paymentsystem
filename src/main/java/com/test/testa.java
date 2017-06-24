package com.test;



import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testa {

	public static void main(String argv[]){
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource sessionFactory = applicationContext.getBean("dataSource" , DataSource.class);
        
    	System.out.println(sessionFactory.toString());
	}
}
