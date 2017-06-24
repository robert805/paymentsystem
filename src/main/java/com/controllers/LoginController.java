package com.controllers;
 

 
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.entities.Card;
import com.entities.User;
import com.entities.UserDetails;
import com.other.Generator;
import com.other.Log;
import com.other.PasswordEncoder;
import com.services.CardServices;
import com.services.UserActivitiesServices;
import com.services.UserDetailsServices;
import com.services.UserServices;
 
@Controller
@RequestMapping("portfel")
public class LoginController {

	@Autowired
	UserServices userServices;
	
	@Autowired
	UserDetailsServices userDetailsServices;
	
	@Autowired
	UserActivitiesServices userActivitiesServices;
	
    PasswordEncoder passwordEncoder = new PasswordEncoder();
	
    @RequestMapping("/login")
    public ModelAndView login() {
      ModelAndView login = new ModelAndView("login");
    	
        return login;
    }
	
    @RequestMapping("/register")
    public ModelAndView register(Principal principal) {
      ModelAndView register = new ModelAndView("register");
     
     String password_check = null;
     String password_error_check = "Podane haslo sie nie zgadza";
  	  User user= new User();
  	
 
      register.addObject("user", user);
      register.addObject("password_check" , password_check);
      register.addObject("password_error_check", password_error_check);
        return register;
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest requestContext ,Model model,String account_type, String password_check, @Valid User user, BindingResult bindingResult) {

    	
    	
    	
    	
    	 
    	
    	if(!(user.getPassword().equals(password_check))){
    		String error_psw = "Haslo sie nie zgadza";
        	model.addAttribute("error_psw", error_psw );
       	 return "register";
    	}
    	//jeœli u¿ytkownik istnieje wyrzuæ komunikat 
    	if(userServices.exist(user.getUsername())){
    		String error_exist = "Uzytkownik o tej nazwie istnieje";
        	model.addAttribute("error_exist", error_exist );
    		return "register";
    	}
  	 // bindingResult.rejectValue("username",  "error.user" , "Nie moze byc puste");
  	 
    	if(bindingResult.hasErrors()  ){
    	
    		System.out.println(bindingResult.getFieldError());  
         
        	 return "register";
        }
        UserDetails userDetails = new UserDetails();
        System.out.println(user);
        user.setUser_role_id(2);
        user.setBalance(0.0);
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
   System.out.println (    user.getPassword());
        userDetails.setAccount_type(account_type);
        userDetailsServices.saveOrUpdate(userDetails);
        
        
        user.setUser_details_id(userDetails.getUser_details_id());
    	userServices.saveOrUpdate(user);
        Log log = new Log();
       System.out.println(requestContext.getRemoteAddr());
    	userActivitiesServices.saveOrUpdate(log.log(user, "Utworzenie konta" , requestContext.getRemoteAddr() ));
    	
        return "redirect:/";
    }

    
    

   
    
}
