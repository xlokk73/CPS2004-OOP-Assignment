import org.junit.Test;
import static org.junit.Assert.*;

public class BuyOrderTest {
    @Test
    public void buyOrderTest1(){
        String trader = Generate.randomString(10);
        String lister = Generate.randomString(10);
        double wallet = Generate.randomDouble(1000000, 0);

        Trader.register(trader, wallet);
        Lister.register(lister, wallet);

        String security = Generate.randomString(10);
        int supply = (int) Generate.randomDouble(1000000, 0);

        Security.list(lister, security, wallet, supply);
        Trader.addOwnedProduct(trader, security, supply);

        //creating a sell order with non-existing trader
        boolean expected = false;
        boolean actual = SellOrder.book(Generate.randomString(9), security, wallet, supply);
        assertEquals(expected, actual);

        //creating a sell order with non-existing security
        expected = false;
        actual = SellOrder.book(trader, Generate.randomString(9), wallet, supply);
        assertEquals(expected, actual);

        //creating a sell order with supply greater than security
        expected = false;
        actual = SellOrder.book(trader, security, wallet, supply + (int) Generate.randomDouble(10, 1));
        assertEquals(expected, actual);

        //successfully creating a sell order
        expected = true;
        actual = SellOrder.book(trader, security, wallet, supply);
        assertEquals(expected, actual);
    }
}
