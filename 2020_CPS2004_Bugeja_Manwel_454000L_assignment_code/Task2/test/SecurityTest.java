import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SecurityTest {

    //ths test assumes lister tests passed


    //testing listing a security with non-existing user
    @Test
    public void SecurityTest0(){
        boolean expected = false;
        boolean actual = Security.list(Generate.randomString(10), Generate.randomString(10), Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));
        assertEquals(expected, actual);
    }

    //testing creating a security with negative price
    @Test
    public void SecurityTest1(){
        boolean expected = false;
        String lister = Generate.randomString(10);
        Lister.register(lister, Generate.randomDouble(1000000, 0));

        boolean actual = Security.list(lister, Generate.randomString(10), Generate.randomDouble(0, -1000000), (int) Generate.randomDouble(100000, 0));
        assertEquals(expected, actual);
    }

    //testing creating a security with negative supply
    @Test
    public void SecurityTest2(){
        boolean expected = false;
        String lister = Generate.randomString(10);
        Lister.register(lister, Generate.randomDouble(1000000, 0));

        boolean actual = Security.list(lister, Generate.randomString(10), Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(0, -100));
        assertEquals(expected, actual);
    }

    //creating multiple securities by same user
    @Test
    public void SecurityTest3(){
        boolean expected = true;
        String lister = Generate.randomString(10);
        Lister.register(lister, Generate.randomDouble(1000000, 0));

        String security = Generate.randomString(10);
        String security1 = Generate.randomString(100);
        String security2 = Generate.randomString(1000);

        boolean actual = Security.list(lister, security, Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));
        assertEquals(expected, actual);

        actual = Security.list(lister, security1, Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));
        assertEquals(expected, actual);

        actual = Security.list(lister, security2, Generate.randomDouble(1000000, 0), (int) Generate.randomDouble(1000000, 0));
        assertEquals(expected, actual);

        actual = Security.exists(security);
        assertEquals(expected, actual);

        actual = Security.exists(security1);
        assertEquals(expected, actual);

        actual = Security.exists(security2);
        assertEquals(expected, actual);
    }


}
