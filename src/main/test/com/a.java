

import junit.framework.TestCase;

import com.entities.User;
import com.services.UserServices;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


public class a {

	
   @Autowired
   UserServices userServices;

    @Test
    public void userServicesTest() {
    	//User user1  = userServices.userByName("tester24@interia.pl");
    //	User user2 = userServices.userByName("tester25@interia.pl");
    	//userServices.moneyTransfer(user1, user2, 20.00);
    	User user1 = userServices.userByName("tester24@interia.pl");
    System.out.println(user1);
   
        assertEquals("tester24@interia.pl", "tester24@interia.pl");
    }
    
    @Test
    public void userServicesTesta() {
    	
        assertEquals("tester24@interia.pl", "tester24@interia.pl");
    }
}
