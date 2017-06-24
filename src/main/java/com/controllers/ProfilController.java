package com.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entities.User;
import com.entities.UserDetails;
import com.other.Log;
import com.other.PasswordEncoder;
import com.services.UserActivitiesServices;
import com.services.UserDetailsServices;
import com.services.UserServices;

@Controller
@RequestMapping("users")
public class ProfilController {


    @Autowired
    UserServices userServices;
 
    @Autowired
    UserDetailsServices userDetailsServices;

    @Autowired 
    UserActivitiesServices userActivitiesServices;
	
   PasswordEncoder passwordEncoder = new PasswordEncoder();
	BCrypt bcrypt = new BCrypt();
	   @RequestMapping("/profil")
	    public ModelAndView profil(Principal principal) {
	    	String name = principal.getName();
	     
	    	User user= userServices.userByName(name);
	        UserDetails userDetails=  userDetailsServices.userById(user.getUser_details_id());
	    
	     
	    
	        ModelAndView view = new ModelAndView("profil");
	       view.addObject("username", name);
	       view.addObject("user", user);
	       view.addObject("userDetails", userDetails);
	        return view;
	    }
	   
	   @RequestMapping("/profiledit")
	    public ModelAndView profiledit(Principal principal) {
	    	String name = principal.getName();
	     
	    	User user= userServices.userByName(name);
	        UserDetails userDetails=  userDetailsServices.userById(user.getUser_details_id());
	    
	        
	  
	        ModelAndView view = new ModelAndView("profiledit");
	       view.addObject("username", name);
	       view.addObject("user", user);
	       view.addObject("userDetails", userDetails);
	        return view;
	    }
	   
	   @RequestMapping(value= "/saveprofil", method = RequestMethod.POST)
	    public String saveProfil(HttpServletRequest requestContext, Principal principal, @Valid UserDetails userDetails, BindingResult bindingResult) {
	     
	    	
	    	if(bindingResult.hasErrors()){
	        	 return "/profileedit";
	        }
	       
	        Log log = new Log();
	        User user1= userServices.userByName(principal.getName());
	    	userActivitiesServices.saveOrUpdate(log.log(user1, "Zmiana ustawien profilu", requestContext.getRemoteAddr()));
	    	userDetailsServices.saveOrUpdate(userDetails);
	        return "redirect:/users/profil";
	    }
	    
	    @RequestMapping("/passwordedit")
	    public ModelAndView passwordEdit(Principal principal) {
	    	String name = principal.getName();
	     
	    	
	    	User user= userServices.userByName(name);
	        
	    
	        
	    	
	        ModelAndView view = new ModelAndView("passwordedit");
	       view.addObject("username", name);
	       view.addObject("user", user);
	       
	        return view;
	    }
	    
	    @RequestMapping(value= "/savepassword", method = RequestMethod.POST)
	    public String saveProfil(HttpServletRequest requestContext, Principal principal, Model model, String password_check ,String password_actual, @Valid User user, BindingResult bindingResult) {
	    	System.out.println("savepassowrd: " + user);
	    	System.out.println("savepassowrd passwordcheck: " + password_check);
	    	System.out.println("savepassowrd passwordactual: " + password_actual);
	    	User user1= userServices.userByName(principal.getName());
	    	
	    	
	    	
	    	if(!(bcrypt.checkpw(password_actual, user1.getPassword() ))){
	    		String error_psw1 = "Obecnie posiadane haslo jest inne";
	        	model.addAttribute("error_psw1", error_psw1 );
	       	 return "passwordedit";
	       	 
	    	}
	    	if(!(user.getPassword().equals(password_check))){
	    		String error_psw = "Haslo sie nie zgadza";
	        	model.addAttribute("error_psw", error_psw );
	       	 return "passwordedit";
	       	 
	    	}
	    	
	    	
	    	if(bindingResult.hasErrors()){
	        	 return "/passwordedit";
	        }
	    	System.out.println("PasswordEdit user:" + user );
	    	Log log = new Log();
	    	userActivitiesServices.saveOrUpdate(log.log(user1, "Zmiana hasla", requestContext.getRemoteAddr()));
	    	user.setPassword(passwordEncoder.encode(user.getPassword()));
	    	userServices.saveOrUpdate(user);
	        return "redirect:/users/profil";
	    }
	    
	
}
