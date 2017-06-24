package com.test;
import junit.framework.TestCase;

import com.entities.User;
import com.services.UserServices;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
(
  {
   "classpath:SpringMVC-servlet.xml",
   "classpath:applicationContext.xml"
   
  }
)


@RunWith(SpringJUnit4ClassRunner.class)

@Transactional


@WebAppConfiguration
public class a {

	@Autowired
	UserServices userServices;



    @Test
	public void setup() {
	User user = userServices.userByName("tester24@interia.pl");
	System.out.println(user.getBalance());
	
	assertEquals(2, 2 );
	}

}