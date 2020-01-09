import org.junit.Test;
import static org.junit.Assert.*;

public class BuyOrderTest {
    @Test
    public void buyOrderTest1(){

        String trader = Generate.randomString(10);
        double price = Generate.randomDouble(1000000, 0);
        int quantity = (int) Generate.randomDouble(1000000, 0);
        Trader.register(trader, price * quantity);


        //buy order with non-existing user
        boolean expected = false;
        boolean actual = BuyOrder.book(Generate.randomString(9), Generate.randomString(10), price, quantity);
        assertEquals(expected, actual);

        //successful buy order
        expected = true;
        actual = BuyOrder.book(trader, Generate.randomString(10), price, quantity);
        assertEquals(expected, actual);
    }

}
