import org.junit.Test;
import static org.junit.Assert.*;

public class ExchangePlatformTest {

    @Test
    public void exchangePlatformTest1(){
        Lister.register("Manwel", 10000);
        Security.list("Manwel", "building", 100, 5);

        try{
            assertTrue(Trader.owns("Manwel", "building", 5));
        }
        catch(NonExistingException e){
            fail();
        }

        Trader.register("Christian", 10000);
        BuyOrder.book("Christian", "building", 100, 5);

        assertTrue(BuyOrder.exists("building", 100, 5));

        try{
            assertFalse(Trader.owns("Christian", "building", 5));
        }
        catch(NonExistingException e){
            fail();
        }

        ExchangePlatform.match();

        try{
            assertFalse(Trader.owns("Manwel", "building", 5));
        }
        catch(NonExistingException e){
            fail();
        }

        try{
            assertTrue(Trader.owns("Christian", "building", 5));
        }
        catch(NonExistingException e){
            fail();
        }
    }
}
