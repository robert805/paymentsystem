package com.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Card;
import com.entities.Transaction;
import com.entities.User;
import com.entities.UserDetails;
import com.google.gson.Gson;
import com.lowagie.text.DocumentException;
import com.other.Email;
import com.other.Generator;
import com.other.Pdf;
import com.services.CardServices;
import com.services.UserServices;


@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	CardServices cardServices;
	
	@Autowired
	UserServices userServices;
	
	Generator generator = new Generator();
	
	 @RequestMapping("cardgenerator")
	    public ModelAndView generator(Principal principal) {
	      ModelAndView register = new ModelAndView("cardgenerator");
	         
	       register.addObject("lista", cardServices.list());
	      
	     
	 
	        return register;
	    }
	    
	    @RequestMapping(value= "createcard", method = RequestMethod.POST)
	    public String creategenerator(Double amount) {
	    	Card card = new Card();
	    	
	    	int x;
	    	
	    	card.setId(generator.generate());
	    	
	    	
	    	card.setAmount(amount);
	        card.setActive(true);
	    	while(cardServices.exist(card.getId())|| card.getId()<9999999){
	    		x = generator.generate();
	    		if(x > 9999999)
	    		card.setId(x);
	    	}
	        
	    	cardServices.saveOrUpdate(card);
	    	return "redirect:/admin/cardgenerator";
	    }
	    
	    @RequestMapping("userslist")
	    public ModelAndView userslist(){
	    ModelAndView view = new ModelAndView("userslist");	
	    	
	    Gson gson = new Gson();
	    view.addObject("lista",  gson.toJson(userServices.list())	);
	   
	    	
	     return view;	
	    }
	    
	    @RequestMapping(value= "/changeaccountstatus", method= RequestMethod.POST)
	    public String changeaAcountStatus(Model model, String username, String status, Principal principal) {
	    	
	    	User user = userServices.userByName(username);
	    	
	    	user.setActive(Boolean.parseBoolean(status));
	        userServices.saveOrUpdate(user);
	        return "redirect:/admin/userslist";
	    }
	    @RequestMapping(value= "/changeaccountrole", method= RequestMethod.POST)
	    public String changeAccoutRole(Model model, String username, String status, Principal principal) {
	    	
	    	User user = userServices.userByName(username);
	    	
	    	
	    	user.setUser_role_id(Integer.parseInt(status));
	        userServices.saveOrUpdate(user);
	        return "redirect:/admin/userslist";
	    }
	    @RequestMapping(value= "/deleteaccount", method= RequestMethod.POST)
	    public String deleteAccount(Model model, String username, Principal principal) {
	    	
	    	User user = userServices.userByName(username);
	    	
	    	
	    	
	        userServices.delete(user);
	        return "redirect:/admin/userslist";
	    }
}
