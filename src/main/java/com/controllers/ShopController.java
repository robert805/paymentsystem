package com.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.authentication.jaas.SecurityContextLoginModule;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dao.ShopDao;
import com.entities.Shop;
import com.entities.ShopCard;
import com.entities.User;
import com.other.Generator;
import com.services.ShopCardServices;
import com.services.ShopServices;
import com.services.UserServices;

@Controller
@RequestMapping("users")
public class ShopController {

	@Autowired
    ShopServices shopServices;

	@Autowired
	UserServices userServices;
	
	@Autowired
	ShopCardServices shopCardServices;
	
	  @RequestMapping("/shopregister")
	    public ModelAndView shopRegister(HttpServletRequest requestContext, Principal principal) {
	      ModelAndView register = new ModelAndView("shopregister");
	    
	   
	        register.addObject("hidden" , "hidden");
	      
	      
	        return register;
	    }
	
	  @RequestMapping("/shopregistersave")
	    public String shopregistersave(Model model, @Valid Shop shop, BindingResult bindingResult, Principal principal) {
	      
		  if(bindingResult.hasErrors()  ){
		    	
	    		System.out.println(bindingResult.getFieldError());  
	         
	        	 return "shopregister";
	        }
	     
		
		  shop.setUser(  userServices.userByName(principal.getName()));
		  shopServices.saveOrUpdate(shop);
	      
	       String komunikat1 = "Proces dodawania sklepu do systemu przebieg³ pomyœlnie!";
	       String adreszdjecia = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOAAAADgCAMAAAAt85rTAAAAYFBMVEX///9mmTNelCNakhvX48xYkRLa5dBkmDBdlB+Kr2ifvYWkwIxilyyNsW2iv4nz9+/f6dfo7+L4+/ZrnDpyoEXL272pw5G60KiPsnCbun53o0zC1LLj7Nt+qFZVkAnQ3sOoTNHDAAADoUlEQVR4nO3dD1vaMBDH8aa1S3FBQBAU53z/73KwzT+UpM1dG3KX5/d9AXIfmc2Vp86qQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEUFWt3g+Hw+sm9xip2jzXTV3XXXN8yj1Kkg6NM/+yzeIx9zTz97MxX9W7Ve555u7CZ4zbFfYe9nzFCa98hQk9vqKEDz5fQcKArxhh0HcSbgsQ3od9RQgHfQUIR3zqhaM+5cIIn2rhwPXzQqj1tIj0qRVG+07CY+5hGRF8xnT73OOS8+7X4RptN8BEn6kPuSemRfUZt8g9Mimyz9hd7pkp0X3GarqOMnzGLXNPHR/HZ9xL7rGjI51/n3WvueeOjeczrZZzkOmr73MPHlnU/dF11inZtpk+0/7KPXlcbN+P3JPHBZ83q8XHvH7CN7G5Ls9cX3M30wC+1vvj1m7f9jNco1n758nXJfStlk3trLWubpdT9ySJvrVzny/k3HrS1xLpq+33l6qnCOX7pglF+jrbfzm2UIePL9TiO78kRyjx/PP7eEKRvsbvOwupRz57P0vpa0O+8zeWJmT6kt4fDfnO31rKw6oS7/+GfedrabxQo48i1OmLF2r1na+lMUKJn0+Ez4feEBHvocT799D57hnDjQnZ53tC36ON9Y0LJe4v1X1NGWVQKHG/rla0oYaEIn3Va0ccJyiU6ate3PgMlwNZv1Cor1pQgYH3UKqPAfQKxfqqZzrQI5Trq/aUU+JzsO3lJ8Iiz7//3bFmcxdCyb6q2sYvMgGhxP3zW08tazxnPoQS748ueub8FJ6EdqXDdzoppggV+PjC079SFT6+cPdA3GQz+dhCy9gSTJ7nC5hCNb5bCm90vl+1vJEwl+9Wwlvs1zmFOX23EOb1pRfm9qUW5velFUrwpRTK8KUT5jv/+qXZaZI+X0AshVDW87sJhKJ8CYTCfLMLxflmFgr0zSmUdX35ai6hVN9cQrm+eYRy9hdf07c2KftnqKlC6b6pQvm+aUINvilCHT6+UIuPK9Tj4wlln3/96EJdPvpOI+nzibiIQsH7ZyiSUKGPJFTpIwiV+qKFan1xQsn3t+ONC3X7xoVJf//hJg3vNNr2F19DQk37dbiwsAxfWFiKLyQsx+cXluTzCcvyXQtL8/WFJZx//RbfHvV1tfb9xde+dR9v37HMv3i1eejapml+v5X5167+tlmvlfznigghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQKrE/YvE4caj3KcoAAAAASUVORK5CYII=";
	       model.addAttribute("komunikat1", komunikat1);
	       model.addAttribute("adreszdjecia", adreszdjecia);
	       model.addAttribute("hidden", "false");
	      return "shopregister";
	      
	      
	    }
	  
	  @RequestMapping(value= "/shopedit" , method=RequestMethod.POST)
	    public ModelAndView shopEdit(String shop_id, Model model,  Principal principal) {
	      ModelAndView view = new ModelAndView("shopedit");
		 
	      
	        	
	       
	Shop shop = shopServices.shopById(Integer.parseInt(shop_id));
	        	 
	        	
		 
		  
	      view.addObject("shop_id" , shop.getShop_id());
	 
	      view.addObject("shop" , shop);
		  return view;
	      
	    }
	  
	  @RequestMapping(value= "/shopeditsave", method=RequestMethod.POST)
	    public String shopEditSave(Model model,String shop_id, @Valid Shop shop, BindingResult bindingResult, Principal principal) {
	      
		  if(bindingResult.hasErrors()  ){
		    	
	    		System.out.println(bindingResult.getFieldError());  
	         
	        	 return "shopregister";
	        }
	     
		
		  shop.setUser(  userServices.userByName(principal.getName()));
		  shop.setShop_id(Integer.parseInt(shop_id));
		  shopServices.saveOrUpdate(shop);
	      
	       String komunikat1 = "Proces edycji sklepu do systemu przebieg³ pomyœlnie!";
	       String adreszdjecia = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOAAAADgCAMAAAAt85rTAAAAYFBMVEX///9mmTNelCNakhvX48xYkRLa5dBkmDBdlB+Kr2ifvYWkwIxilyyNsW2iv4nz9+/f6dfo7+L4+/ZrnDpyoEXL272pw5G60KiPsnCbun53o0zC1LLj7Nt+qFZVkAnQ3sOoTNHDAAADoUlEQVR4nO3dD1vaMBDH8aa1S3FBQBAU53z/73KwzT+UpM1dG3KX5/d9AXIfmc2Vp86qQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEUFWt3g+Hw+sm9xip2jzXTV3XXXN8yj1Kkg6NM/+yzeIx9zTz97MxX9W7Ve555u7CZ4zbFfYe9nzFCa98hQk9vqKEDz5fQcKArxhh0HcSbgsQ3od9RQgHfQUIR3zqhaM+5cIIn2rhwPXzQqj1tIj0qRVG+07CY+5hGRF8xnT73OOS8+7X4RptN8BEn6kPuSemRfUZt8g9Mimyz9hd7pkp0X3GarqOMnzGLXNPHR/HZ9xL7rGjI51/n3WvueeOjeczrZZzkOmr73MPHlnU/dF11inZtpk+0/7KPXlcbN+P3JPHBZ83q8XHvH7CN7G5Ls9cX3M30wC+1vvj1m7f9jNco1n758nXJfStlk3trLWubpdT9ySJvrVzny/k3HrS1xLpq+33l6qnCOX7pglF+jrbfzm2UIePL9TiO78kRyjx/PP7eEKRvsbvOwupRz57P0vpa0O+8zeWJmT6kt4fDfnO31rKw6oS7/+GfedrabxQo48i1OmLF2r1na+lMUKJn0+Ez4feEBHvocT799D57hnDjQnZ53tC36ON9Y0LJe4v1X1NGWVQKHG/rla0oYaEIn3Va0ccJyiU6ate3PgMlwNZv1Cor1pQgYH3UKqPAfQKxfqqZzrQI5Trq/aUU+JzsO3lJ8Iiz7//3bFmcxdCyb6q2sYvMgGhxP3zW08tazxnPoQS748ueub8FJ6EdqXDdzoppggV+PjC079SFT6+cPdA3GQz+dhCy9gSTJ7nC5hCNb5bCm90vl+1vJEwl+9Wwlvs1zmFOX23EOb1pRfm9qUW5velFUrwpRTK8KUT5jv/+qXZaZI+X0AshVDW87sJhKJ8CYTCfLMLxflmFgr0zSmUdX35ai6hVN9cQrm+eYRy9hdf07c2KftnqKlC6b6pQvm+aUINvilCHT6+UIuPK9Tj4wlln3/96EJdPvpOI+nzibiIQsH7ZyiSUKGPJFTpIwiV+qKFan1xQsn3t+ONC3X7xoVJf//hJg3vNNr2F19DQk37dbiwsAxfWFiKLyQsx+cXluTzCcvyXQtL8/WFJZx//RbfHvV1tfb9xde+dR9v37HMv3i1eejapml+v5X5167+tlmvlfznigghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQKrE/YvE4caj3KcoAAAAASUVORK5CYII=";
	       model.addAttribute("komunikat1", komunikat1);
	       model.addAttribute("adreszdjecia", adreszdjecia);
	       model.addAttribute("hidden", "false");
	      return "shopregister";
	      
	      
	    }
	  
	  
	  
	  @RequestMapping("/shop")
	    public ModelAndView shop(HttpServletRequest requestContext, Principal principal) {
	      ModelAndView view = new ModelAndView("shop");
	      User user = userServices.userByName(principal.getName());
	     System.out.println(user.getUser_id());
	      List<Shop> shops = shopServices.listWhereIdUserIs(user);
	
	        view.addObject("username" , principal.getName());
	        
	        view.addObject("shops" , shops);
	        return view;
	    }
	  
	  @RequestMapping(value= "/shopcardadd" , method= RequestMethod.POST)
	    public ModelAndView shopcardadd(String shop_id ,HttpServletRequest requestContext, Principal principal) {
	      ModelAndView view = new ModelAndView("shopcardadd");
	      User user = userServices.userByName(principal.getName());
	      int shop_id_parse= Integer.parseInt(shop_id);
	    Shop shop = shopServices.shopById(shop_id_parse);
	      
	      System.out.println(shop);
		     
	        view.addObject("username" , principal.getName());
	        
	        view.addObject("shop_id" , shop.getShop_id());
	        
	        
	        return view;
	    }
	  @RequestMapping(value= "/shopstatistic" , method= RequestMethod.POST)
	    public ModelAndView shopStatistic(String shop_id ,HttpServletRequest requestContext, Principal principal) {
	      ModelAndView view = new ModelAndView("shopstatistic");
	      User user = userServices.userByName(principal.getName());
	      int shop_id_parse= Integer.parseInt(shop_id);
	    Shop shop = shopServices.shopById(shop_id_parse);
	      
	      
		    
	    
	    
	    
	        view.addObject("username" , principal.getName());
	        
	        
	        
	        view.addObject("shop_id" , shop.getShop_id());
	        view.addObject("shop", shop);
	        
	        return view;
	    }
	  @RequestMapping(value= "/shopcardaddsave" , method= RequestMethod.POST)
	    public String shopcardadd(String howmuch, String amount, String shop_id, Model model ,HttpServletRequest requestContext, Principal principal) {

	      User user = userServices.userByName(principal.getName());
	    
	      model.addAttribute("username" , principal.getName());
	      int shop_id_parse= Integer.parseInt(shop_id);
	      int howmuch_parse= Integer.parseInt(howmuch);
	      Double amount_parse = Double.parseDouble(amount);
	      ShopCard shopCard = new ShopCard();
	      Shop shop = shopServices.shopById(shop_id_parse);
	      
	      
	     
	      int x;
	      
	      Generator generator = new Generator();
	      
	      
	      for(int i = 0; i < howmuch_parse ; i++){
	      shopCard.setShop_card_id(generator.generate());
	      
	      while(shopCardServices.exist(shopCard.getShop_card_id())|| shopCard.getShop_card_id()<9999999){
	    		x = generator.generate();
	    		if(x > 9999999)
	    		shopCard.setShop_card_id(x);
	    	}
	      
	      shopCard.setActive(true);
	      shopCard.setAmount(amount_parse);
	      shopCard.setShop(shop);
	      
	      shopCardServices.saveOrUpdate(shopCard);
	      
	      }
	      String komunikat1 = "Dodawanie kart przebieg³o pomyœlnie! <a href=\"profil\"> Profil </a>";
	       String adreszdjecia = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOAAAADgCAMAAAAt85rTAAAAYFBMVEX///9mmTNelCNakhvX48xYkRLa5dBkmDBdlB+Kr2ifvYWkwIxilyyNsW2iv4nz9+/f6dfo7+L4+/ZrnDpyoEXL272pw5G60KiPsnCbun53o0zC1LLj7Nt+qFZVkAnQ3sOoTNHDAAADoUlEQVR4nO3dD1vaMBDH8aa1S3FBQBAU53z/73KwzT+UpM1dG3KX5/d9AXIfmc2Vp86qQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEUFWt3g+Hw+sm9xip2jzXTV3XXXN8yj1Kkg6NM/+yzeIx9zTz97MxX9W7Ve555u7CZ4zbFfYe9nzFCa98hQk9vqKEDz5fQcKArxhh0HcSbgsQ3od9RQgHfQUIR3zqhaM+5cIIn2rhwPXzQqj1tIj0qRVG+07CY+5hGRF8xnT73OOS8+7X4RptN8BEn6kPuSemRfUZt8g9Mimyz9hd7pkp0X3GarqOMnzGLXNPHR/HZ9xL7rGjI51/n3WvueeOjeczrZZzkOmr73MPHlnU/dF11inZtpk+0/7KPXlcbN+P3JPHBZ83q8XHvH7CN7G5Ls9cX3M30wC+1vvj1m7f9jNco1n758nXJfStlk3trLWubpdT9ySJvrVzny/k3HrS1xLpq+33l6qnCOX7pglF+jrbfzm2UIePL9TiO78kRyjx/PP7eEKRvsbvOwupRz57P0vpa0O+8zeWJmT6kt4fDfnO31rKw6oS7/+GfedrabxQo48i1OmLF2r1na+lMUKJn0+Ez4feEBHvocT799D57hnDjQnZ53tC36ON9Y0LJe4v1X1NGWVQKHG/rla0oYaEIn3Va0ccJyiU6ate3PgMlwNZv1Cor1pQgYH3UKqPAfQKxfqqZzrQI5Trq/aUU+JzsO3lJ8Iiz7//3bFmcxdCyb6q2sYvMgGhxP3zW08tazxnPoQS748ueub8FJ6EdqXDdzoppggV+PjC079SFT6+cPdA3GQz+dhCy9gSTJ7nC5hCNb5bCm90vl+1vJEwl+9Wwlvs1zmFOX23EOb1pRfm9qUW5velFUrwpRTK8KUT5jv/+qXZaZI+X0AshVDW87sJhKJ8CYTCfLMLxflmFgr0zSmUdX35ai6hVN9cQrm+eYRy9hdf07c2KftnqKlC6b6pQvm+aUINvilCHT6+UIuPK9Tj4wlln3/96EJdPvpOI+nzibiIQsH7ZyiSUKGPJFTpIwiV+qKFan1xQsn3t+ONC3X7xoVJf//hJg3vNNr2F19DQk37dbiwsAxfWFiKLyQsx+cXluTzCcvyXQtL8/WFJZx//RbfHvV1tfb9xde+dR9v37HMv3i1eejapml+v5X5167+tlmvlfznigghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQKrE/YvE4caj3KcoAAAAASUVORK5CYII=";
	       model.addAttribute("komunikat1", komunikat1);
	       model.addAttribute("adreszdjecia", adreszdjecia);
	       model.addAttribute("hidden", "false");
	        
	        return "shopcardadd";
	    }
	  
}

