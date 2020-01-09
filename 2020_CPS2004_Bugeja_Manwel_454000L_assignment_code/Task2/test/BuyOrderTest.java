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


    //tests BuyOrder.exists()
    @Test
    public void buyOrderTest2(){

        String order = Generate.randomString(10);
        double price = Generate.randomDouble(1000000, 10);
        int quantity = (int) Generate.randomDouble(1000000, 10);
        String trader = Generate.randomString(10);
        double wallet = price * quantity;
        Trader.register(trader, wallet);

        assertTrue(BuyOrder.book(trader, order, price, quantity));

        //search buy order that doesn't exist
        boolean expected = false;
        boolean actual = BuyOrder.exists(Generate.randomString(9), price, quantity);
        assertEquals(expected, actual);

        //search buy order with incorrect price
        expected = false;
        actual = BuyOrder.exists(order, Generate.randomDouble(9, 0), quantity);
        assertEquals(expected, actual);

        //search buy order with incorrect quantity
        expected = false;
        actual = BuyOrder.exists(order, price, (int) Generate.randomDouble(8, 0));
        assertEquals(expected, actual);

        //successful buy order exists
        expected = true;
        actual = BuyOrder.exists(order, price, quantity);
        assertEquals(expected, actual);
    }
}
