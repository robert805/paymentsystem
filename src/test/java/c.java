import static org.junit.Assert.*;

import org.junit.Test;

import com.other.RESTfull;

public class c {

	@Test
	public void test() {
		
		
	  
		
	  RESTfull http = new RESTfull();
		
	  try {
		assertEquals(false,  http.sendPost("localhost:8080/", "Commited", "43"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Test
	public void test1() {
		
		
	  
		
	  RESTfull http = new RESTfull();
		
	  try {
		assertEquals(false,  http.sendPost("localhost:8080/", "Commited", "43"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
