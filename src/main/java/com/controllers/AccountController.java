package com.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Card;
import com.entities.User;
import com.entities.UserDetails;
import com.other.Log;
import com.services.CardServices;
import com.services.UserActivitiesServices;
import com.services.UserDetailsServices;
import com.services.UserServices;

@Controller
@RequestMapping("users")
public class AccountController {
	

    @Autowired
    UserServices userServices;
    
    @Autowired
    UserActivitiesServices userActivitiesServices;
 
    @Autowired
    UserDetailsServices userDetailsServices;
    
    @Autowired
    CardServices cardServices;
    
    @RequestMapping("/portfel")
    public ModelAndView portfel( Principal principal) {
    	String name = principal.getName();
     
    	User user= userServices.userByName(name);
        UserDetails userDetails=  userDetailsServices.userById(user.getUser_details_id());
        
        
        
      
        
        ModelAndView view = new ModelAndView("portfel");
       
       view.addObject("username", name);
       view.addObject("user", user);
       view.addObject("userDetails", userDetails);
        return view;
    }

    @RequestMapping(value = "/doladuje", method= RequestMethod.POST)
    public String portfeldoladuj(HttpServletRequest requestContext, Model model, String number, Principal principal) {
   
    	String name = principal.getName();
         Card card = new Card();
    	User user= userServices.userByName(name);
         Integer parseInt = Integer.parseInt(number);
    	 if(!(cardServices.exist(parseInt))){ 
         	String error_active = "Karta o podanym numerze nie istnieje!";
         model.addAttribute("error_active" , error_active);	
         model.addAttribute("username", name);
         model.addAttribute("user", user);
         return "portfel";
         }
        
        card = cardServices.cardByNumber(Integer.parseInt(number));
        
        if(!(card.isActive())){ 
        	String error_active = "Karta o podanym numerze zosta³a wykorzystana!";
        model.addAttribute("error_active" , error_active);	
        model.addAttribute("username", name);
        model.addAttribute("user", user);
        return "portfel";
        }
        
        if(card.isActive()){
        card.setActive(false);
        user.setBalance(user.getBalance() + card.getAmount());
        cardServices.saveOrUpdate(card);
        userServices.saveOrUpdate(user);
        Log log = new Log();
    	userActivitiesServices.saveOrUpdate(log.log(user, "Do³adowanie konta", requestContext.getRemoteAddr() ));
        String error_active = "Œrodki dodane pomyœlnie!";
        model.addAttribute("error_active" , error_active);	
        model.addAttribute("username", name);
        model.addAttribute("user", user);
       
        }
        
       
        return "portfel";
   
    }
  
}
