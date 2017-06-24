package com.controllers;
 

 
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.bouncycastle.asn1.ocsp.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Card;
import com.entities.Transaction;
import com.entities.User;
import com.entities.UserActivities;
import com.entities.UserDetails;
import com.google.gson.Gson;
import com.other.Log;
import com.services.CardServices;
import com.services.ShopServices;
import com.services.TransactionServices;
import com.services.UserActivitiesServices;
import com.services.UserDetailsServices;
import com.services.UserServices;
 
@Controller
@RequestMapping("users")
public class UserController {
	 
	@Autowired
    TransactionServices transactionServices;
    
    @Autowired
    UserServices userServices;
 
    @Autowired
    UserDetailsServices userDetailsServices;
    
    @Autowired
    UserActivitiesServices userActivitiesServices;
    
   @Autowired
   CardServices cardServices;
   
   @Autowired
   ShopServices shopServices;
    
   @RequestMapping(value="lista", method = RequestMethod.GET)
	public @ResponseBody List<User> getShopInJSON(Principal principal) {
     
	   List<User> user_list = userServices.list();	
	   
	   
		return user_list;

	}
   
   /*  @RequestMapping(value= "/add")
    public ModelAndView getPage(Principal principal) {
    	String name = principal.getName();
       
        User user = userServices.userByName(name);
    	System.out.print(user.getUserDetails().getAdress());
        ModelAndView view = new ModelAndView("add");
      // view.addObject("username", name);
        Gson gson = new Gson();
        
        view.addObject("data" , userServices.list());
        view.addObject("jsondata" , gson.toJson(userServices.list()));
        view.addObject("jsontrans" , gson.toJson(transactionServices.list(user)));
       // view.addObject("lista", lista);
        return view;
    }*/
    @RequestMapping(value= "/testy")
    public String testy(Model model) {
    	
    model.addAttribute("status", "Udalo sie");
    return "forward:http://localhost:8083/SpringMVC/recive";
    }
    
    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
        	 return "/register";
        }
     
    	userServices.saveOrUpdate(user);
        return "redirect:/";
    }
   
    @RequestMapping("/hello")
    public ModelAndView hello() {
      ModelAndView hello = new ModelAndView("add");
    	
        return hello;
    }
    
  
    @RequestMapping("/login")
    public ModelAndView login() {
      ModelAndView login = new ModelAndView("login");
    	
        return login;
    }

    @RequestMapping("/zalogowany")
    public ModelAndView zalogowany(Principal principal) {
    	String name = principal.getName();
  
    	User user= new User();
    	
        ModelAndView view = new ModelAndView("zalogowany");
       view.addObject("username", name);
       view.addObject("user", user);
        return view;
    }
   
    @RequestMapping("/index")
    public ModelAndView index(Principal principal) {
    	String name = principal.getName();
    
    	User user= new User();
    	
     
       
        ModelAndView view = new ModelAndView("index");
       view.addObject("username", name);
       view.addObject("user", user);
    //   view.addObject("napis", napis);
        return view;
    }
   
 
   

    

    
   
    
   
    
   
    
    @RequestMapping(value= "/activities")
    public ModelAndView activities(Principal principal) {
    	String name = principal.getName();
     
    	User user= userServices.userByName(name);
        
    	List<UserActivities> aktywnosc = userActivitiesServices.list(user);
    	for(UserActivities u: aktywnosc){
        	
        
        	}
        ModelAndView view = new ModelAndView("activities");
       view.addObject("username", name);
       view.addObject("user", user);
       view.addObject("data", userActivitiesServices.list(user));

        return view;
    }
    @RequestMapping(value = "/activitiessearch", method = RequestMethod.POST)
    public ModelAndView activitiesSearch( String after, String before, Principal principal) throws ParseException {
    	String name = principal.getName();
    	 DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    	User user= userServices.userByName(name);
    	 Calendar calendar = Calendar.getInstance();
         Calendar calendar1 = Calendar.getInstance();
        Date date1;
        if(before == ""){
        	before = format.format(calendar1.getTime());
        	System.out.println("Jest puste");
        }
    	if(before == null){
        	date1= calendar1.getTime();
        	System.out.println("Jest puste");
        }
    	
    	
    	 Date date = format.parse(after);
         date1 = format.parse(before);
       
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_WEEK, -1);
        date= calendar.getTime();
        calendar1.setTime(date1);
        calendar1.add(Calendar.DAY_OF_WEEK, +1);
        date1= calendar1.getTime();
        System.out.println("Calendar:" + format.format(date));
        System.out.println("Calendar1:" + format.format(date1));
    	 List<UserActivities> aktywnosc = userActivitiesServices.list(user);
    	 List<UserActivities> wynik = new ArrayList();
    	
     	for(UserActivities u: aktywnosc){
     		 System.out.println("Czeny bue na" + format.format(u.getDate()));
         	if(date.before(u.getDate())&& date1.after(u.getDate()) ){
         	wynik.add(u);
            }
        }
     	 
     	for(UserActivities b: wynik){
         	
         	System.out.println("Wynik : " + b.getDate());
        }
        System.out.println(after + " " + before);
        
    	
    	List<UserActivities> zapis_aktywnosci;
    	for(UserActivities b: aktywnosc){
    	
    	System.out.println(b.getDate());
    	}
    	
        ModelAndView view = new ModelAndView("activities");
       view.addObject("username", name);
       view.addObject("user", user);
       view.addObject("data", wynik);
      
    
        return view;
    }
  
    @RequestMapping(value = "/activitiespastweek", method = RequestMethod.POST)
    public ModelAndView activitiesPastWeek(String after, String before, Principal principal) throws ParseException {
    	String name = principal.getName();
     
    	User user= userServices.userByName(name);
        
        
    	 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    	
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        Date date = calendar.getTime();
        Date date1 = calendar.getTime();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_WEEK, -8);
        date= calendar.getTime();
        calendar1.setTime(date1);
        calendar1.add(Calendar.DAY_OF_WEEK, +1);
        date1= calendar1.getTime();
        System.out.println("Calendar:" + format.format(date));
        System.out.println("Calendar1:" + format.format(date1));
    	 List<UserActivities> aktywnosc = userActivitiesServices.list(user);
    	 List<UserActivities> wynik = new ArrayList();
    	
     	for(UserActivities u: aktywnosc){
     		 System.out.println("Czeny bue na" + format.format(u.getDate()));
         	if(date.before(u.getDate())&& date1.after(u.getDate()) ){
         	wynik.add(u);
            }
        }
     	 
     	for(UserActivities b: wynik){
         	
         	System.out.println("Wynik : " + b.getDate());
        }
    
        
    	
    	List<UserActivities> zapis_aktywnosci;
    	for(UserActivities b: aktywnosc){
    	
    	System.out.println(b.getDate());
    	}
    	
        ModelAndView view = new ModelAndView("activities");
       view.addObject("username", name);
       view.addObject("user", user);
       view.addObject("data", wynik);
    
        return view;
    }
    
    @RequestMapping(value = "/activitiespastmonth", method = RequestMethod.POST)
    public ModelAndView activitiesPastMonth(String after, String before, Principal principal) throws ParseException {
    	String name = principal.getName();
     
    	User user= userServices.userByName(name);
        
        
    	 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    	
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        Date date = calendar.getTime();
        Date date1 = calendar.getTime();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_WEEK, -31);
        date= calendar.getTime();
        calendar1.setTime(date1);
        calendar1.add(Calendar.DAY_OF_WEEK, +1);
        date1= calendar1.getTime();
        System.out.println("Calendar:" + format.format(date));
        System.out.println("Calendar1:" + format.format(date1));
    	 List<UserActivities> aktywnosc = userActivitiesServices.list(user);
    	 List<UserActivities> wynik = new ArrayList();
    	
     	for(UserActivities u: aktywnosc){
     		 System.out.println("Czeny bue na" + format.format(u.getDate()));
         	if(date.before(u.getDate())&& date1.after(u.getDate()) ){
         	wynik.add(u);
            }
        }
     	 
     	for(UserActivities b: wynik){
         	
         	System.out.println("Wynik : " + b.getDate());
        }
    
        
    	
    	List<UserActivities> zapis_aktywnosci;
    	for(UserActivities b: aktywnosc){
    	
    	System.out.println(b.getDate());
    	}
    	
        ModelAndView view = new ModelAndView("activities");
       view.addObject("username", name);
       view.addObject("user", user);
       view.addObject("data", wynik);
    
        return view;
    }
    
  
}