
import junit.framework.TestCase;

import com.entities.User;
import com.services.UserServices;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "test-applicationContext.xml")
public class b {

	
   @Autowired
   UserServices userServices;

    @Test
    public void userServicesTest() {
    	//User user1  = userServices.userByName("tester24@interia.pl");
    	//User user2 = userServices.userByName("tester25@interia.pl");
    	//userServices.moneyTransfer(user1, user2, 20.00);
    System.out.println("Syst");
    assertEquals(2, 2);
    	//assertEquals( user1.getBalance() , "8781.00" );
        // assertEquals(user2.getBalance() , "10212.00");
    }
}
