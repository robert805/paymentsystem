package com.other;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PasswordEncoder {
	
	
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
           public String encode(String password){
				
				
				String hashedPassword = 	bcrypt.encode(password);
				
				
     
				
				
           return hashedPassword;
		  }
           public static void main(String[] args) {
        	   PasswordEncoder passwordEncoder = new PasswordEncoder();
        	   for(int i = 0; i< 10 ; i++){
        	   System.out.println(passwordEncoder.encode("haslo123"));
        	  

        	   }
        	
        		
           }
}





 

 
