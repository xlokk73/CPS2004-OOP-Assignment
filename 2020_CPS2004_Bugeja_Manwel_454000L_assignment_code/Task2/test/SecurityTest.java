import com.sun.tools.attach.AgentInitializationException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class SecurityTest {

    //ths test assumes lister tests passed


    //testing listing a security with non-existing user
    @Test
    public void SecurityTest1(){
        boolean expected = false;
        boolean actual = Security.list(Generate.randomString(10), Generate.randomString(10), Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));
        assertEquals(expected, actual);
    }

    //testing creating a security with negative price
    @Test
    public void SecurityTest2(){
        boolean expected = false;
        String lister = Generate.randomString(10);
        Lister.register(lister, Generate.randomDouble(1000000, 0));

        boolean actual = Security.list(lister, Generate.randomString(10), Generate.randomDouble(0, -1000000), (int) Generate.randomDouble(100000, 0));
        assertEquals(expected, actual);
    }

    //testing creating a security with negative supply
    @Test
    public void SecurityTest3(){
        boolean expected = false;
        String lister = Generate.randomString(10);
        Lister.register(lister, Generate.randomDouble(1000000, 0));

        boolean actual = Security.list(lister, Generate.randomString(10), Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(0, -100));
        assertEquals(expected, actual);
    }

    //creating multiple different securities by multiple users
    @Test
    public void SecurityTest4(){
        boolean expected = true;
        String lister = Generate.randomString(10);
        Lister.register(lister, Generate.randomDouble(1000000, 0));

        String lister1 = Generate.randomString(10);
        Lister.register(lister1, Generate.randomDouble(1000000, 0));

        String security = Generate.randomString(10);
        String security1 = Generate.randomString(100);
        String security2 = Generate.randomString(1000);

        boolean actual = Security.list(lister, security, Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));
        assertEquals(expected, actual);

        actual = Security.list(lister, security1, Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));
        assertEquals(expected, actual);

        actual = Security.list(lister1, security2, Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));
        assertEquals(expected, actual);

        actual = Security.exists(security);
        assertEquals(expected, actual);

        actual = Security.exists(security1);
        assertEquals(expected, actual);

        actual = Security.exists(security2);
        assertEquals(expected, actual);
    }

    //creating same security from multiple users
    @Test
    public void SecurityTest5(){
        boolean expected = false;
        String lister = Generate.randomString(10);
        String lister1 = Generate.randomString(10);

        String description = Generate.randomString(10);

        Security.list(lister, description, Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));
        boolean actual = Security.list(lister1, description, Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));

        assertEquals(expected, actual);
    }

    //check that product is added to owned products of the trader
    @Test
    public void SecurityTest6(){
        String lister = Generate.randomString(10);
        double wallet = Generate.randomDouble(1000000, 0);
        double price = Generate.randomDouble(1000000, 0);
        int supply = (int) Generate.randomDouble(1000000, 0);
        Lister.register(lister, wallet);
        String description = Generate.randomString(10);

        boolean expected = true;
        boolean actual = Security.list(lister, description, price, supply);
        assertEquals(expected, actual);

        expected = true;
        actual = false;
        try {
            actual = Trader.owns(lister, description, supply);
        }
        catch(NonExistingException e){
            fail();
        }

        assertEquals(expected, actual);
    }

    //check if sell order has been created when a security is listed
    @Test
    public void securityTest7(){
        String lister = Generate.randomString(10);
        double wallet = Generate.randomDouble(1000000, 0);
        double price = Generate.randomDouble(1000000, 0);
        int supply = (int) Generate.randomDouble(1000000, 0);
        Lister.register(lister, wallet);
        String description = Generate.randomString(10);

        boolean expected = true;
        boolean actual = Security.list(lister, description, price, supply);
        assertEquals(expected, actual);
    }


}
