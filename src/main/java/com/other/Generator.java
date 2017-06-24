package com.other;

import java.util.Random;

public class Generator {
 private int x;
	
        public int generate(){
       Random random =	new Random();
      x =    random.nextInt(100000000); 

		System.out.println( x);
		
		return x;
	}
	
   
}
