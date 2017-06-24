package com.controllers;

import java.io.IOException;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.TransactionDao;
import com.entities.Card;
import com.entities.Shop;
import com.entities.ShopCard;
import com.entities.Transaction;
import com.entities.User;
import com.entities.UserDetails;
import com.google.gson.Gson;
import com.lowagie.text.DocumentException;
import com.other.Email;
import com.other.Log;
import com.other.Pdf;
import com.other.RESTfull;
import com.services.CardServices;
import com.services.ShopCardServices;
import com.services.ShopServices;
import com.services.TransactionServices;
import com.services.UserActivitiesServices;
import com.services.UserDetailsServices;
import com.services.UserServices;

@Controller
@RequestMapping("users")
public class TransactionController {

	
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
   
   @Autowired
   ShopCardServices shopCardServices;
   
   /*
   @RequestMapping(value="/{user_id}", method=RequestMethod.GET)
   public ResponseEntity<UserDetails> get(@PathVariable("user_id") int user_id) {
   UserDetails userDetails = userDetailsServices.userById(user_id);
   
   System.out.println("Api: " + userDetails);
   return new ResponseEntity<UserDetails>(userDetails, new HttpHeaders(), HttpStatus.OK);
   }
   */
   
   @RequestMapping(value="transactions/{user_id}", method=RequestMethod.GET)
   public ResponseEntity<Transaction> get(@PathVariable("user_id") int user_id) {
  // UserDetails userDetails = userDetailsServices.userById(user_id);
   Transaction transaction = transactionServices.transacionById(user_id);
   System.out.println("Api: " + transaction);
   return new ResponseEntity<Transaction>(transaction, new HttpHeaders(), HttpStatus.OK);
   }
   
   @RequestMapping("/transactionadd")
   public ModelAndView transactionAdd( Principal principal) {
   	String name = principal.getName();
       
	System.out.println(principal.toString());
      
        
       ModelAndView view = new ModelAndView("transactionadd");
    
       
       
       
      view.addObject("username", name);
      view.addObject("hidden", "hidden");
    
       return view;
   }
   
   @RequestMapping("/test")
   public ModelAndView test( Principal principal) {
   	String name = principal.getName();
       
	System.out.println(principal.toString());
      
        
       ModelAndView view = new ModelAndView("transactionadd");
    
       User userTake = userServices.userByName("tester24@interia.pl");
       User userGive = userServices.userByName("tester25@interia.pl");
       
       userServices.moneyTransfer(userTake, userGive, 20.00);
       
       return view;
   }
   
   
   @RequestMapping(value= "/transactionshop", method=RequestMethod.POST)
   public ModelAndView transactionShopReciver(Model model,
		  
		   String id_sklepu,  
		   String id, 
		   String ilosc, 
		   String cena, 
		   String transaction_id,
		   HttpServletRequest request,
		   Principal principal) {
   	String name = principal.getName();
   	User user = userServices.userByName(name);
   	
  Double lacznakwota = Double.parseDouble(cena) * (double) Integer.parseInt(ilosc);
     String errorbalance = "";
       ModelAndView view = new ModelAndView("transactionshop");
       if(user.getBalance() < lacznakwota ){
      errorbalance = "Brak œrodków! Do³aduj konto lub zap³aæ kart¹ podarunkow¹.";
       }
       view.addObject("errorbalance", errorbalance);
     
       Shop shop = shopServices.shopById(Integer.parseInt(id_sklepu));
       request.getSession().setAttribute("shop_id", shop.getShop_id());
       request.getSession().setAttribute("shop", shop);
       request.getSession().setAttribute("transaction_id", transaction_id);
       
      view.addObject("nazwasklepu", shop.getName() );
     view.addObject("emailsklepu" , shop.getUser().getUsername());
      view.addObject("adressklepu", shop.getAddress());
      view.addObject("kodpocztowysklepu", shop.getPostalcode());
      view.addObject("username", name);
      view.addObject("id" , id);
    //view.addObject("produkt" , produkt);
      view.addObject("ilosc", ilosc);
      view.addObject("cena", cena);
      view.addObject("lacznakwota",  lacznakwota);
      view.addObject("balance", user.getBalance() );
      view.addObject("transaction_id", transaction_id);
      
      
       return view;
       
   }
   //Komunikat o transakcji czy siê wykona³a poprawnie czy nie
   @RequestMapping(value= "/transactionshopreciveview" )
   public ModelAndView transactionShopReciveView( Principal principal) {
   	String name = principal.getName();
       
	System.out.println(principal.toString());
   
       
       ModelAndView view = new ModelAndView("transactionshopreciveview");
    

       
       
      view.addObject("username", name);
      view.addObject("hidden", "hidden");
    
       return view;
   }
   //Transakcja miêdzy systemem a sklepem
   @RequestMapping(value= "/transactionshoprecive", method= RequestMethod.POST)
   public String transactionshoprecive(
		   Model model, 
		   String name1, 
		   String amount, 
		   String title_operation, 
		   String status, 
		   String transaction_id, 
		   String rodzajPlatnosci,
		   HttpServletRequest request,
		  
		   Principal principal) throws DocumentException, IOException, MessagingException {
       
	   List<ShopCard> list = new ArrayList<ShopCard>();
	   
	   
	   
	   String name = principal.getName();
   
       Double amountt = Double.parseDouble(amount);
     
   	   Transaction transaction= new Transaction();
   	 
   	 
       User user= userServices.userByName(name);
       
       User user1= userServices.userByName(name1);
       
    
	   
    
       
       Shop shop = shopServices.shopById(  (Integer) request.getSession().getAttribute("shop_id"))   ;
      

       
       
       
       
       
       
	   //DODAWANIE DO SESJI ARGUMENTÓW
       
	   request.getSession().setAttribute("listauzytychkart", list);
	   request.getSession().setAttribute("shopUser", name1);
	   request.getSession().setAttribute("shop", shop);
	   request.getSession().setAttribute("transaction_id", transaction_id);
	   request.getSession().setAttribute("cardOverfillExist", "false");
       
	   
	   
	   
	   
      System.out.println(shop);
      
      //P³atnoœæ Kart¹ Podarunkow¹
      if(rodzajPlatnosci.equals("KartaPodarunkowa")){
    	 model.addAttribute("lacznakwota", amount);
    	 model.addAttribute("suma", "0.00");
    	 model.addAttribute("balance", user.getBalance());
    	  return "shopcardpayment";
      }
      
      
      if(!(userServices.exist(name1))){
       String error = "U¿ytkownik o podanym adresie nie istnieje!";
    
    
       model.addAttribute("balance", user.getBalance());
       model.addAttribute("username", name);
       model.addAttribute("error", error);
       model.addAttribute("user",user);
      return "transactionshopreciveview";
      }
     
       if(user.getBalance() < amountt){
          
    
    		   String komunikat1 = "Transakcja zosta³a anulowana z powodu braku œrodków na koncie!";
    	       String adreszdjecia = "http://download.seaicons.com/download/i33269/visualpharm/must-have/visualpharm-must-have-cancel.ico";
    	       model.addAttribute("komunikat1", komunikat1);
    	       model.addAttribute("adreszdjecia", adreszdjecia);
    	       model.addAttribute("hidden", "false");
    	       model.addAttribute("username", name);
    	       model.addAttribute("transaction_id", (String) request.getSession().getAttribute("transaction_id"));
    	       model.addAttribute("status", "Canceled");
    	       model.addAttribute("user",user);
    	       model.addAttribute("shoplink","cos");
    	       RESTfull rest = new RESTfull();
    	       try {
				rest.sendPost(shop.getLink_send_data(), "Canceled", (String) request.getSession().getAttribute("transaction_id"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	       return "transactionshopreciveview";
    	 
          }
       
       String komunikat1 = "Transakcja przebieg³a pomyœlnie!";
       String adreszdjecia = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOAAAADgCAMAAAAt85rTAAAAYFBMVEX///9mmTNelCNakhvX48xYkRLa5dBkmDBdlB+Kr2ifvYWkwIxilyyNsW2iv4nz9+/f6dfo7+L4+/ZrnDpyoEXL272pw5G60KiPsnCbun53o0zC1LLj7Nt+qFZVkAnQ3sOoTNHDAAADoUlEQVR4nO3dD1vaMBDH8aa1S3FBQBAU53z/73KwzT+UpM1dG3KX5/d9AXIfmc2Vp86qQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEUFWt3g+Hw+sm9xip2jzXTV3XXXN8yj1Kkg6NM/+yzeIx9zTz97MxX9W7Ve555u7CZ4zbFfYe9nzFCa98hQk9vqKEDz5fQcKArxhh0HcSbgsQ3od9RQgHfQUIR3zqhaM+5cIIn2rhwPXzQqj1tIj0qRVG+07CY+5hGRF8xnT73OOS8+7X4RptN8BEn6kPuSemRfUZt8g9Mimyz9hd7pkp0X3GarqOMnzGLXNPHR/HZ9xL7rGjI51/n3WvueeOjeczrZZzkOmr73MPHlnU/dF11inZtpk+0/7KPXlcbN+P3JPHBZ83q8XHvH7CN7G5Ls9cX3M30wC+1vvj1m7f9jNco1n758nXJfStlk3trLWubpdT9ySJvrVzny/k3HrS1xLpq+33l6qnCOX7pglF+jrbfzm2UIePL9TiO78kRyjx/PP7eEKRvsbvOwupRz57P0vpa0O+8zeWJmT6kt4fDfnO31rKw6oS7/+GfedrabxQo48i1OmLF2r1na+lMUKJn0+Ez4feEBHvocT799D57hnDjQnZ53tC36ON9Y0LJe4v1X1NGWVQKHG/rla0oYaEIn3Va0ccJyiU6ate3PgMlwNZv1Cor1pQgYH3UKqPAfQKxfqqZzrQI5Trq/aUU+JzsO3lJ8Iiz7//3bFmcxdCyb6q2sYvMgGhxP3zW08tazxnPoQS748ueub8FJ6EdqXDdzoppggV+PjC079SFT6+cPdA3GQz+dhCy9gSTJ7nC5hCNb5bCm90vl+1vJEwl+9Wwlvs1zmFOX23EOb1pRfm9qUW5velFUrwpRTK8KUT5jv/+qXZaZI+X0AshVDW87sJhKJ8CYTCfLMLxflmFgr0zSmUdX35ai6hVN9cQrm+eYRy9hdf07c2KftnqKlC6b6pQvm+aUINvilCHT6+UIuPK9Tj4wlln3/96EJdPvpOI+nzibiIQsH7ZyiSUKGPJFTpIwiV+qKFan1xQsn3t+ONC3X7xoVJf//hJg3vNNr2F19DQk37dbiwsAxfWFiKLyQsx+cXluTzCcvyXQtL8/WFJZx//RbfHvV1tfb9xde+dR9v37HMv3i1eejapml+v5X5167+tlmvlfznigghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQKrE/YvE4caj3KcoAAAAASUVORK5CYII=";
       model.addAttribute("komunikat1", komunikat1);
       model.addAttribute("adreszdjecia", adreszdjecia);
       model.addAttribute("hidden", "false");
       model.addAttribute("username", name);
       model.addAttribute("transaction_id", transaction_id);
       model.addAttribute("status", status);
       model.addAttribute("shoplink", shop.getLink_send_data());
       model.addAttribute("user",user);
       
       //Transfer pieniêdzy
       Boolean statusTransaction = false;
     statusTransaction = userServices.moneyTransferToShop(user, user1, amountt, (Shop) request.getSession().getAttribute("shop"),   (String) request.getSession().getAttribute("transaction_id"));

	   if(!statusTransaction){
		  komunikat1 = "Transakcja zosta³a anulowana z powodu awarii lub braku po³¹czenia ze sklepem!";
	      adreszdjecia = "http://download.seaicons.com/download/i33269/visualpharm/must-have/visualpharm-must-have-cancel.ico";
	       model.addAttribute("komunikat1", komunikat1);
	       model.addAttribute("adreszdjecia", adreszdjecia);
	       model.addAttribute("hidden", "false");
	       model.addAttribute("username", name);
	       model.addAttribute("transaction_id", (String) request.getSession().getAttribute("transaction_id"));
	       model.addAttribute("status", "Canceled");
	       model.addAttribute("user",user);
	       model.addAttribute("shoplink","cos");
	       return "transactionshopreciveview";
	   }
       
//   	transaction.setSender(user);
   	
 //  	transaction.setRecipent(user1);
   	
  // 	transaction.setAmount(amountt);
   	
 
      UserDetails userSenderDetails = userDetailsServices.userById(user.getUser_details_id());
      UserDetails userReciverDetails = userDetailsServices.userById(user1.getUser_details_id());
       
      //Calendar calendar = Calendar.getInstance();
     //  transaction.setDate(calendar.getTime());
     //  transactionServices.saveOrUpdate(transaction);
       
       Log log = new Log();
       
       Pdf pdf = new Pdf(userSenderDetails.getName() + " " + userSenderDetails.getLastname(), 
    		             userSenderDetails.getAdress(), 
    		             userSenderDetails.getPostalcode(), 
    		             shop.getName(),
    		             shop.getAddress(),
    		             shop.getPostalcode(),
    		             amountt + " PLN",
    		             log.actual_date(), 
    		             title_operation);
       pdf.create();
       Email email = new Email(name1 , "PotwierdzeniePrzelewu", "PotwierdzeniePrzelewu");
       Email email2 = new Email(name, "PotwierdzeniePrzelewu", "PotwierdzeniePrzelewu");
       email.send();
       email2.send();
       return "transactionshopreciveview";
   }
   
   
   
   @RequestMapping(value= "/shopcardpayment" )
   public ModelAndView shopCardPayment( Principal principal) {
	   
	   
	   
		
	   
   	String name = principal.getName();
       
	System.out.println(principal.toString());
   
       
       ModelAndView view = new ModelAndView("shopcardpayment");
    
     
       
       
      view.addObject("username", name);
      view.addObject("hidden", "hidden");
      view.addObject("user", userServices.userByName(name));
    
       return view;
   }
   
   @RequestMapping(value= "/shopcardpaymentsave" , method= RequestMethod.POST)
   public String shopCardPaymentSave(String number, String suma,  String lacznakwota,HttpServletRequest request, Model model ,Principal principal) {

	   String name = principal.getName();
		User user= userServices.userByName(name);
		 Double sumap = Double.parseDouble(suma);
		 
		 
		 if(!(shopCardServices.exist(Integer.parseInt(number)))){ 
		    	String error_active = "Karta o podanym numerze nie istnieje!";
		    model.addAttribute("number", number);
		    model.addAttribute("error_active" , error_active);	
		    model.addAttribute("username", name);
		    model.addAttribute("lacznakwota", lacznakwota);
		    model.addAttribute("user", user);
		    model.addAttribute("balance", user.getBalance());
		    model.addAttribute("suma" , sumap );
		    model.addAttribute("konto", user.getBalance());
		    return "shopcardpayment";
		    }
	  
   	
    ShopCard shopCard = shopCardServices.cardByNumber(Integer.parseInt(number));

	
	Boolean checkIfUsed = false;
	
    Integer parseNumber = Integer.parseInt(number);
 
    Double lacznakwotap = Double.parseDouble(lacznakwota);
    
    
    
    
    
    //Sprawdz czy karta nie zostala juz podana
    List<ShopCard> lista = (List<ShopCard>)request.getSession().getAttribute("listauzytychkart");
	  
	for(ShopCard a: lista){
		
		System.out.println("Karty w sesji: "  + a.getShop_card_id());
		
		if(shopCard.getShop_card_id().equals(a.getShop_card_id())){
		checkIfUsed = true; break;
		}
	}
	System.out.println("Karta wpisana: "  + parseNumber);
	System.out.println(checkIfUsed);
	


	    
	
	  if(checkIfUsed){ 
		   	String error_active = "Karta o podanym numerze istnieje w tej transakcji!";
		   model.addAttribute("error_active" , error_active);	
		   model.addAttribute("username", name);
		   model.addAttribute("lacznakwota", lacznakwota);
		   model.addAttribute("user", user);
		   model.addAttribute("balance", user.getBalance());
		   model.addAttribute("suma" , sumap );
		   return "shopcardpayment";
		   }
	 
	 
   if(!(shopCard.isActive())){ 
   	String error_active = "Karta o podanym numerze zosta³a wykorzystana!";
   model.addAttribute("error_active" , error_active);	
   model.addAttribute("username", name);
   model.addAttribute("lacznakwota", lacznakwota);
   model.addAttribute("user", user);
   model.addAttribute("balance", user.getBalance());
   model.addAttribute("suma" , sumap );
   return "shopcardpayment";
   }
   
  
   
   if(Double.parseDouble(lacznakwota) < sumap + shopCard.getAmount()){
	   request.getSession().setAttribute("cardThatOverfill", shopCard.getShop_card_id());
	   request.getSession().setAttribute("cardThatOverfillMoneyToTake", (lacznakwotap - sumap));
	   request.getSession().setAttribute("cardOverfillExist", "true");
	   model.addAttribute("error_money" , "Na ostatnio wprowadzonej karcie po zatwierdzeniu pozostanie: " + ( sumap + shopCard.getAmount() - Double.parseDouble(lacznakwota) ) + " z³" );	
   }
   
   sumap = sumap + shopCard.getAmount();
   shopCard = shopCardServices.cardByNumber(Integer.parseInt(number));
   
   
   
   
   
 
   
   if(shopCard.isActive()){
  // shopCard.setActive(false);
   //shopCardServices.saveOrUpdate(shopCard);

	   
	   //Dodawanie do sesji karty
	  List<ShopCard> list = (List<ShopCard>)request.getSession().getAttribute("listauzytychkart");
	   
	   
	
	   
	   list.add(shopCard);
	   request.getSession().setAttribute("listauzytychkart", list);
	   
   String error_active = "Karta dodana!";
   model.addAttribute("error_active" , error_active);	
   model.addAttribute("username", name);
   model.addAttribute("lacznakwota", lacznakwota);
   model.addAttribute("balance", user.getBalance());
   model.addAttribute("amount_card" , shopCard.getAmount());
   model.addAttribute("suma" , sumap );
   }
   
  
   return "shopcardpayment";
   }
   //Dop³ata gotówk¹ do karty podarunkowej
   @RequestMapping(value= "/shopcardpaymentbalancepay" , method= RequestMethod.POST)
   public String shopCardPaymentBalancePay( String suma,  String lacznakwota, HttpServletRequest request, Model model ,Principal principal) {

       
   	String name = principal.getName();
  
	User user= userServices.userByName(name);
	
	
    
    Double sumap = Double.parseDouble(suma);
    Double lacznakwotap = Double.parseDouble(lacznakwota);
       Double amounttopay;
       
   amounttopay = lacznakwotap - sumap;
   
   
   sumap = sumap + amounttopay;
  
  
  if(sumap == lacznakwotap){
	  String error_active = "£¹czna kwota równa siê kwocie potrzebnej do zrealizowania transakcji!";
	  model.addAttribute("error_active" , error_active);	
  }
  
   
   String error_active = "Dodano œrodki z konta!";
   model.addAttribute("error_active" , error_active);	
   model.addAttribute("username", name);
   model.addAttribute("lacznakwota", lacznakwota);
   model.addAttribute("balance", user.getBalance() - amounttopay );
   request.getSession().setAttribute("balance", user.getBalance() - amounttopay);
   model.addAttribute("suma" , sumap );
   
   
   
   return "shopcardpayment";
   }
   
   //potwierdzenie transakcji kart do³¹dowuj¹cych po wprowadzeniu kwoty odpowiedniej do przeprowadzenia transakcji
   
   @RequestMapping(value= "/shopcardpaymentcommit" , method= RequestMethod.POST)
   public String shopCardPaymentCommit(String suma,  String lacznakwota,HttpServletRequest request, Model model ,Principal principal) {
       
	   	String name = principal.getName();
	    boolean statusTransaction = false; 
		User user= userServices.userByName(name);
		
	   //Jeœli nie uzyskano kwoty koniecznej do zatwierdzenia transakcji to wyœwietl komunikat
	   if(Double.parseDouble(lacznakwota) > Double.parseDouble(suma) ){
	   String error_active = "Musisz uzyskaæ kwotê " + lacznakwota + " z³ aby dokoñczyæ transakcjê!";
	   model.addAttribute("error_active" , error_active);	
	   model.addAttribute("username", name);
	   model.addAttribute("lacznakwota", lacznakwota);
	   model.addAttribute("balance", user.getBalance());
	   
	   model.addAttribute("suma" , suma );
	   
	 //wykonaj serwis zmiany aktywnoœci kart u¿ytych oraz zmien stan konta jeœli dop³acono

	
	   
	   return "shopcardpayment";
	   }
	   
	    if(((String) request.getSession().getAttribute("cardOverfillExist")).equals("false")){
	    	System.out.println("Wysz³o CI");
	    	
	    	 statusTransaction = transactionServices.cardPayment(
	   			  ((List<ShopCard>) request.getSession().getAttribute("listauzytychkart")),
	   			  
	   			  (Double)  request.getSession().getAttribute("balance"), 
	   			   user ,
	   			  (String) request.getSession().getAttribute("shopUser"),
	   			  (String) request.getSession().getAttribute("transaction_id"),
	   			 (Shop) request.getSession().getAttribute("shop")
	    			 
	    			 );
	   	   
	    	   if(!statusTransaction){
	    		   String komunikat1 = "Transakcja zosta³a anulowana!";
	    	       String adreszdjecia = "http://download.seaicons.com/download/i33269/visualpharm/must-have/visualpharm-must-have-cancel.ico";
	    	       model.addAttribute("komunikat1", komunikat1);
	    	       model.addAttribute("adreszdjecia", adreszdjecia);
	    	       model.addAttribute("hidden", "false");
	    	       model.addAttribute("username", name);
	    	       model.addAttribute("transaction_id", (String) request.getSession().getAttribute("transaction_id"));
	    	       model.addAttribute("status", "Canceled");
	    	       model.addAttribute("user",user);
	    	       model.addAttribute("shoplink","cos");
	    	       return "transactionshopreciveview";
	    	   }
	    	 
	    	 
	    	   String komunikat1 = "Transakcja przebieg³a pomyœlnie!";
	           String adreszdjecia = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOAAAADgCAMAAAAt85rTAAAAYFBMVEX///9mmTNelCNakhvX48xYkRLa5dBkmDBdlB+Kr2ifvYWkwIxilyyNsW2iv4nz9+/f6dfo7+L4+/ZrnDpyoEXL272pw5G60KiPsnCbun53o0zC1LLj7Nt+qFZVkAnQ3sOoTNHDAAADoUlEQVR4nO3dD1vaMBDH8aa1S3FBQBAU53z/73KwzT+UpM1dG3KX5/d9AXIfmc2Vp86qQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEUFWt3g+Hw+sm9xip2jzXTV3XXXN8yj1Kkg6NM/+yzeIx9zTz97MxX9W7Ve555u7CZ4zbFfYe9nzFCa98hQk9vqKEDz5fQcKArxhh0HcSbgsQ3od9RQgHfQUIR3zqhaM+5cIIn2rhwPXzQqj1tIj0qRVG+07CY+5hGRF8xnT73OOS8+7X4RptN8BEn6kPuSemRfUZt8g9Mimyz9hd7pkp0X3GarqOMnzGLXNPHR/HZ9xL7rGjI51/n3WvueeOjeczrZZzkOmr73MPHlnU/dF11inZtpk+0/7KPXlcbN+P3JPHBZ83q8XHvH7CN7G5Ls9cX3M30wC+1vvj1m7f9jNco1n758nXJfStlk3trLWubpdT9ySJvrVzny/k3HrS1xLpq+33l6qnCOX7pglF+jrbfzm2UIePL9TiO78kRyjx/PP7eEKRvsbvOwupRz57P0vpa0O+8zeWJmT6kt4fDfnO31rKw6oS7/+GfedrabxQo48i1OmLF2r1na+lMUKJn0+Ez4feEBHvocT799D57hnDjQnZ53tC36ON9Y0LJe4v1X1NGWVQKHG/rla0oYaEIn3Va0ccJyiU6ate3PgMlwNZv1Cor1pQgYH3UKqPAfQKxfqqZzrQI5Trq/aUU+JzsO3lJ8Iiz7//3bFmcxdCyb6q2sYvMgGhxP3zW08tazxnPoQS748ueub8FJ6EdqXDdzoppggV+PjC079SFT6+cPdA3GQz+dhCy9gSTJ7nC5hCNb5bCm90vl+1vJEwl+9Wwlvs1zmFOX23EOb1pRfm9qUW5velFUrwpRTK8KUT5jv/+qXZaZI+X0AshVDW87sJhKJ8CYTCfLMLxflmFgr0zSmUdX35ai6hVN9cQrm+eYRy9hdf07c2KftnqKlC6b6pQvm+aUINvilCHT6+UIuPK9Tj4wlln3/96EJdPvpOI+nzibiIQsH7ZyiSUKGPJFTpIwiV+qKFan1xQsn3t+ONC3X7xoVJf//hJg3vNNr2F19DQk37dbiwsAxfWFiKLyQsx+cXluTzCcvyXQtL8/WFJZx//RbfHvV1tfb9xde+dR9v37HMv3i1eejapml+v5X5167+tlmvlfznigghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQKrE/YvE4caj3KcoAAAAASUVORK5CYII=";
	           model.addAttribute("komunikat1", komunikat1);
	           model.addAttribute("adreszdjecia", adreszdjecia);
	           model.addAttribute("hidden", "false");
	           model.addAttribute("username", name);
	           model.addAttribute("transaction_id", (String) request.getSession().getAttribute("transaction_id"));
	           model.addAttribute("status", "Positive");
	           model.addAttribute("shoplink", "cos");
	           model.addAttribute("user",user);
	    	   
	    	   
	    	   return "transactionshopreciveview";
	    	
	    }
		  
	 
	statusTransaction =    transactionServices.cardPayment(
			  ((List<ShopCard>) request.getSession().getAttribute("listauzytychkart")),
			   (Integer) request.getSession().getAttribute("cardThatOverfill") ,
			  (Double) request.getSession().getAttribute("cardThatOverfillMoneyToTake"),
			  (Double)  request.getSession().getAttribute("balance"), 
			   user ,
			  (String) request.getSession().getAttribute("shopUser"),
			  (String) request.getSession().getAttribute("transaction_id"),
	   			 (Shop) request.getSession().getAttribute("shop")
			  );
	
	System.out.println("STATUS TRANSAKCJI JEST TAKI : "  + statusTransaction);
	   if(!statusTransaction){
		   String komunikat1 = "Transakcja zosta³a anulowana z powodu awarii lub braku po³¹czenia ze sklepem!";
	       String adreszdjecia = "http://download.seaicons.com/download/i33269/visualpharm/must-have/visualpharm-must-have-cancel.ico";
	       model.addAttribute("komunikat1", komunikat1);
	       model.addAttribute("adreszdjecia", adreszdjecia);
	       model.addAttribute("hidden", "false");
	       model.addAttribute("username", name);
	       model.addAttribute("transaction_id", (String) request.getSession().getAttribute("transaction_id"));
	       model.addAttribute("status", "Canceled");
	       model.addAttribute("user",user);
	       model.addAttribute("shoplink","cos");
	       return "transactionshopreciveview";
	   }
	   
	   String komunikat1 = "Transakcja przebieg³a pomyœlnie!";
       String adreszdjecia = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOAAAADgCAMAAAAt85rTAAAAYFBMVEX///9mmTNelCNakhvX48xYkRLa5dBkmDBdlB+Kr2ifvYWkwIxilyyNsW2iv4nz9+/f6dfo7+L4+/ZrnDpyoEXL272pw5G60KiPsnCbun53o0zC1LLj7Nt+qFZVkAnQ3sOoTNHDAAADoUlEQVR4nO3dD1vaMBDH8aa1S3FBQBAU53z/73KwzT+UpM1dG3KX5/d9AXIfmc2Vp86qQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEUFWt3g+Hw+sm9xip2jzXTV3XXXN8yj1Kkg6NM/+yzeIx9zTz97MxX9W7Ve555u7CZ4zbFfYe9nzFCa98hQk9vqKEDz5fQcKArxhh0HcSbgsQ3od9RQgHfQUIR3zqhaM+5cIIn2rhwPXzQqj1tIj0qRVG+07CY+5hGRF8xnT73OOS8+7X4RptN8BEn6kPuSemRfUZt8g9Mimyz9hd7pkp0X3GarqOMnzGLXNPHR/HZ9xL7rGjI51/n3WvueeOjeczrZZzkOmr73MPHlnU/dF11inZtpk+0/7KPXlcbN+P3JPHBZ83q8XHvH7CN7G5Ls9cX3M30wC+1vvj1m7f9jNco1n758nXJfStlk3trLWubpdT9ySJvrVzny/k3HrS1xLpq+33l6qnCOX7pglF+jrbfzm2UIePL9TiO78kRyjx/PP7eEKRvsbvOwupRz57P0vpa0O+8zeWJmT6kt4fDfnO31rKw6oS7/+GfedrabxQo48i1OmLF2r1na+lMUKJn0+Ez4feEBHvocT799D57hnDjQnZ53tC36ON9Y0LJe4v1X1NGWVQKHG/rla0oYaEIn3Va0ccJyiU6ate3PgMlwNZv1Cor1pQgYH3UKqPAfQKxfqqZzrQI5Trq/aUU+JzsO3lJ8Iiz7//3bFmcxdCyb6q2sYvMgGhxP3zW08tazxnPoQS748ueub8FJ6EdqXDdzoppggV+PjC079SFT6+cPdA3GQz+dhCy9gSTJ7nC5hCNb5bCm90vl+1vJEwl+9Wwlvs1zmFOX23EOb1pRfm9qUW5velFUrwpRTK8KUT5jv/+qXZaZI+X0AshVDW87sJhKJ8CYTCfLMLxflmFgr0zSmUdX35ai6hVN9cQrm+eYRy9hdf07c2KftnqKlC6b6pQvm+aUINvilCHT6+UIuPK9Tj4wlln3/96EJdPvpOI+nzibiIQsH7ZyiSUKGPJFTpIwiV+qKFan1xQsn3t+ONC3X7xoVJf//hJg3vNNr2F19DQk37dbiwsAxfWFiKLyQsx+cXluTzCcvyXQtL8/WFJZx//RbfHvV1tfb9xde+dR9v37HMv3i1eejapml+v5X5167+tlmvlfznigghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQKrE/YvE4caj3KcoAAAAASUVORK5CYII=";
       model.addAttribute("komunikat1", komunikat1);
       model.addAttribute("adreszdjecia", adreszdjecia);
       model.addAttribute("hidden", "false");
       model.addAttribute("username", name);
       model.addAttribute("transaction_id", (String) request.getSession().getAttribute("transaction_id"));
       model.addAttribute("status", "Positive");
       model.addAttribute("shoplink", "cos");
       model.addAttribute("user",user);
	   
	   
	   return "transactionshopreciveview";
	   
   }
   
   
   @RequestMapping("/transactioncancel")
   public String transactionCancel(HttpServletRequest request, Model model ,Principal principal) {
       
	   	String name = principal.getName();
	   
		User user= userServices.userByName(name);
        
		Shop shop =  (Shop) request.getSession().getAttribute("shop");
		
		 String komunikat1 = "Transakcja zosta³a anulowana z powodu awarii lub braku po³¹czenia ze sklepem!";
	       String adreszdjecia = "http://download.seaicons.com/download/i33269/visualpharm/must-have/visualpharm-must-have-cancel.ico";
	       model.addAttribute("komunikat1", komunikat1);
	       model.addAttribute("adreszdjecia", adreszdjecia);
	       model.addAttribute("hidden", "false");
	       model.addAttribute("username", name);
	       model.addAttribute("transaction_id", (String) request.getSession().getAttribute("transaction_id"));
	       model.addAttribute("status", "Canceled");
	       model.addAttribute("user",user);
	       model.addAttribute("shoplink",shop.getLink_send_data());
		RESTfull rest = new RESTfull();
		try {
			rest.sendPost(shop.getLink_send_data(), "Canceled", (String) request.getSession().getAttribute("transaction_id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return "transactionshopreciveview";
		
		
			
   }
   
   
   //Transakcja miêdzy u¿ytkownikami systemu
   @RequestMapping(value= "/transaction", method= RequestMethod.POST)
   public String transactionUser(Model model, String name1, String amount, String title_operation, Principal principal) throws DocumentException, IOException, MessagingException {
   	String name = principal.getName();
      
       Double amountt = Double.parseDouble(amount);;
  
   	   Transaction transaction= new Transaction();
   	
   	 
       User user= userServices.userByName(name);
      
       User user1= userServices.userByName(name1);
       
      
       if(!(userServices.exist(name1))){
       String error = "U¿ytkownik o podanym adresie nie istnieje!";
    
    
       model.addAttribute("balance", user.getBalance());
       model.addAttribute("username", name);
       model.addAttribute("error", error);
      
      return "transactionadd";
      }
     
       if(user.getBalance() < amountt){
          
           String komunikat = "Nie masz tyle œrodków na koncie!";
           model.addAttribute("komunikat", komunikat);
           model.addAttribute("balance", user.getBalance());
           model.addAttribute("username", name);
     
          
          return "transactionadd";
          }
       
       String komunikat1 = "Transakcja przebieg³a pomyœlnie!";
       String adreszdjecia = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOAAAADgCAMAAAAt85rTAAAAYFBMVEX///9mmTNelCNakhvX48xYkRLa5dBkmDBdlB+Kr2ifvYWkwIxilyyNsW2iv4nz9+/f6dfo7+L4+/ZrnDpyoEXL272pw5G60KiPsnCbun53o0zC1LLj7Nt+qFZVkAnQ3sOoTNHDAAADoUlEQVR4nO3dD1vaMBDH8aa1S3FBQBAU53z/73KwzT+UpM1dG3KX5/d9AXIfmc2Vp86qQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEUFWt3g+Hw+sm9xip2jzXTV3XXXN8yj1Kkg6NM/+yzeIx9zTz97MxX9W7Ve555u7CZ4zbFfYe9nzFCa98hQk9vqKEDz5fQcKArxhh0HcSbgsQ3od9RQgHfQUIR3zqhaM+5cIIn2rhwPXzQqj1tIj0qRVG+07CY+5hGRF8xnT73OOS8+7X4RptN8BEn6kPuSemRfUZt8g9Mimyz9hd7pkp0X3GarqOMnzGLXNPHR/HZ9xL7rGjI51/n3WvueeOjeczrZZzkOmr73MPHlnU/dF11inZtpk+0/7KPXlcbN+P3JPHBZ83q8XHvH7CN7G5Ls9cX3M30wC+1vvj1m7f9jNco1n758nXJfStlk3trLWubpdT9ySJvrVzny/k3HrS1xLpq+33l6qnCOX7pglF+jrbfzm2UIePL9TiO78kRyjx/PP7eEKRvsbvOwupRz57P0vpa0O+8zeWJmT6kt4fDfnO31rKw6oS7/+GfedrabxQo48i1OmLF2r1na+lMUKJn0+Ez4feEBHvocT799D57hnDjQnZ53tC36ON9Y0LJe4v1X1NGWVQKHG/rla0oYaEIn3Va0ccJyiU6ate3PgMlwNZv1Cor1pQgYH3UKqPAfQKxfqqZzrQI5Trq/aUU+JzsO3lJ8Iiz7//3bFmcxdCyb6q2sYvMgGhxP3zW08tazxnPoQS748ueub8FJ6EdqXDdzoppggV+PjC079SFT6+cPdA3GQz+dhCy9gSTJ7nC5hCNb5bCm90vl+1vJEwl+9Wwlvs1zmFOX23EOb1pRfm9qUW5velFUrwpRTK8KUT5jv/+qXZaZI+X0AshVDW87sJhKJ8CYTCfLMLxflmFgr0zSmUdX35ai6hVN9cQrm+eYRy9hdf07c2KftnqKlC6b6pQvm+aUINvilCHT6+UIuPK9Tj4wlln3/96EJdPvpOI+nzibiIQsH7ZyiSUKGPJFTpIwiV+qKFan1xQsn3t+ONC3X7xoVJf//hJg3vNNr2F19DQk37dbiwsAxfWFiKLyQsx+cXluTzCcvyXQtL8/WFJZx//RbfHvV1tfb9xde+dR9v37HMv3i1eejapml+v5X5167+tlmvlfznigghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQKrE/YvE4caj3KcoAAAAASUVORK5CYII=";
       model.addAttribute("komunikat1", komunikat1);
       model.addAttribute("adreszdjecia", adreszdjecia);
       model.addAttribute("hidden", "false");
       
       userServices.moneyTransfer(user, user1, amountt);

   	transaction.setSender(user);
   	
   	transaction.setRecipent(user1);
   	
   	transaction.setAmount(amountt);
   	
    transaction.setTitle(title_operation);
      UserDetails userSenderDetails = userDetailsServices.userById(user.getUser_details_id());
      UserDetails userReciverDetails = userDetailsServices.userById(user1.getUser_details_id());
       
      Calendar calendar = Calendar.getInstance();
       transaction.setDate(calendar.getTime());
       transactionServices.saveOrUpdate(transaction);
       
       Log log = new Log();
       
       Pdf pdf = new Pdf(userSenderDetails.getName() + " " + userSenderDetails.getLastname(), 
    		             userSenderDetails.getAdress(), 
    		             userSenderDetails.getPostalcode(), 
    		             userReciverDetails.getName() + " " + userReciverDetails.getLastname(),
    		             userReciverDetails.getAdress(),
    		             userReciverDetails.getPostalcode(),
    		             amountt + " PLN",
    		             log.actual_date(), 
    		             title_operation);
       pdf.create();
       Email email = new Email(name1 , "PotwierdzeniePrzelewu", "PotwierdzeniePrzelewu");
       Email email2 = new Email(name, "PotwierdzeniePrzelewu", "PotwierdzeniePrzelewu");
       email.send();
       email2.send();
       return "transactionadd";
   }
   
   
   
   
   
   
   //lista transakcji wys³anych
   @RequestMapping("/transactionsender")
   public ModelAndView transactionSender( Principal principal) {
   	String name = principal.getName();
       
   	Transaction transaction= new Transaction();
   	
       User user= userServices.userByName(name);
       
       
   	transaction.setSender(user);
   	
       Gson gson = new Gson();
       for(Transaction t:transactionServices.list(user)){
       	
       	
       }
       
       ModelAndView view = new ModelAndView("transactionsender");
       view.addObject("lista" , gson.toJson(transactionServices.list(user))); 
      view.addObject("username", name);
      view.addObject("user", user);
     
       return view;
   }
   
   //lista transakcji odebranych
   @RequestMapping("/transactionrecipent")
   public ModelAndView transactionRecipent( Principal principal) {
	  	String name = principal.getName();
	       
	   	Transaction transaction= new Transaction();
	   	
	       User user= userServices.userByName(name);
	       
	       
	   	transaction.setSender(user);
	   	
	       Gson gson = new Gson();
	       for(Transaction t:transactionServices.list(user)){
	       	
	    	   
	       }
	       
	       ModelAndView view = new ModelAndView("transactionsender");
	       view.addObject("lista" , gson.toJson(transactionServices.list_recipent(user))); 
	      view.addObject("username", name);
	      view.addObject("user", user);
	     
	       return view;
   }
   
   
   @RequestMapping(value= "/pdfsend", method= RequestMethod.POST)
   public String pdfSend(Model model, String emailadress, String transaction_id, Principal principal) throws DocumentException, IOException, MessagingException {
   	
   
   	   Transaction transaction = transactionServices.transacionById(Integer.parseInt(transaction_id));
     
       User user= transaction.getSender();
      
       User user1= transaction.getRecipent();

       UserDetails userSenderDetails = userDetailsServices.userById(user.getUser_details_id());
      
       UserDetails userReciverDetails = userDetailsServices.userById(user1.getUser_details_id());
       
       Pdf pdf = new Pdf(userSenderDetails.getName() + " " + userSenderDetails.getLastname(), 
    		             userSenderDetails.getAdress(),
    		             userSenderDetails.getPostalcode(), 
    		             userReciverDetails.getName() + " " + userReciverDetails.getLastname(),
    		             userReciverDetails.getAdress(),
    		             userReciverDetails.getPostalcode(),
    		             transaction.getAmount() + " PLN",
    		             transaction.getDate().toString(), 
    		             "Przelew");
       pdf.create();
       
       Email email = new Email(emailadress , "PotwierdzeniePrzelewu", "PotwierdzeniePrzelewu");
      
       email.send();
       
       return "redirect:/users/transactionsender";
   }
   
   
   
   
}
