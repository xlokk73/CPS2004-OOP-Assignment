
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.Assert.*;

public class TraderTest {



    //tests creating a new user successfully
    @Test
    public void TraderTest1(){


        double maxWallet = 100000000;
        double minWallet = 0;

        //successfully creating a new user
        String generatedString = Generate.randomString(10);
        boolean expected = true;
        double wallet = Generate.randomDouble(maxWallet, minWallet);
        boolean actual = Trader.register(generatedString, wallet);
        assertEquals(expected, actual);

        double returnedWallet = 0;
        try{
            returnedWallet = Trader.getWallet(generatedString);
        }
        catch (NonExistingException e){
            fail();
        }
        assertEquals(returnedWallet, wallet, 0.001);

        //creating a second user
        String generatedString1 = Generate.randomString(10);
        double wallet1 = Generate.randomDouble(maxWallet, minWallet);
        actual = Trader.register(generatedString1, wallet1);
        assertEquals(expected, actual);
        try{
            returnedWallet = Trader.getWallet(generatedString1);
        }
        catch (NonExistingException e){
            fail();
        }
        assertEquals(returnedWallet, wallet1, 0.001);

        //creating a user that already exists
        expected = false;
        actual = Trader.register(generatedString, Generate.randomDouble(maxWallet, minWallet));
        assertEquals(expected, actual);

        //creating a user with negative wallet amount
        String generatedString2 = Generate.randomString(10);
        expected = false;
        actual = Trader.register(generatedString2, Generate.randomDouble(0, -100));
        assertEquals(expected, actual);

        //checking created users
        assertEquals(generatedString, Trader.getList().get(0).getName());
        assertEquals(generatedString1, Trader.getList().get(1).getName());

        expected = true;
        actual = Trader.exists(generatedString);
        assertEquals(expected, actual);
        actual = Trader.exists(generatedString1);
        assertEquals(expected, actual);

        expected = false;
        actual = Trader.exists(generatedString2);
        assertEquals(expected, actual);

        //adding wallet to a non-existing user
        expected = false;
        actual = Trader.increaseWallet(generatedString2, Generate.randomDouble(maxWallet, minWallet));
        assertEquals(expected, actual);

        //adding wallet with negative amount to user
        expected = false;
        actual = Trader.increaseWallet(generatedString, Generate.randomDouble(0, -100));
        assertEquals(expected, actual);

        //adding to a wallet of a user
        double walletIncrease = Generate.randomDouble(maxWallet, minWallet);
        expected = true;
        actual = Trader.increaseWallet(generatedString, walletIncrease);
        assertEquals(expected, actual);
        try{
            returnedWallet = Trader.getWallet(generatedString);
        }
        catch (NonExistingException e){
            fail();
        }
        assertEquals(returnedWallet, wallet + walletIncrease, 0.001);

        //subtracting wallet of a non-existing user
        expected = false;
        actual = Trader.decreaseWallet(generatedString2, Generate.randomDouble(maxWallet, minWallet));
        assertEquals(expected, actual);

        //subtracting wallet with a negative number
        expected = false;
        actual = Trader.decreaseWallet(generatedString1, Generate.randomDouble(0, -100));
        assertEquals(expected, actual);

        //subtracting wallet with a number greater than the current amount
        expected = false;
        actual = Trader.decreaseWallet(generatedString1, wallet1 + Generate.randomDouble(100, 1));
        assertEquals(expected, actual);

        //subtracting to a wallet of a user
        double walletDecrease = Generate.randomDouble(wallet1, minWallet);
        expected = true;
        actual = Trader.decreaseWallet(generatedString1, walletDecrease);
        assertEquals(expected, actual);
        try{
            returnedWallet = Trader.getWallet(generatedString1);
        }
        catch (NonExistingException e){
            fail();
        }
        assertEquals(returnedWallet, wallet1 - walletDecrease, 0.001);

        //check that no listers have been created with trader creation
        int expectedSize = 0;
        int actualSize = Lister.getList().size();
        assertEquals(expectedSize, actualSize);
    }

    //testing addOwnedProduct
    @Test
    public void TraderTest2(){
        String lister = Generate.randomString(10);
        String trader = Generate.randomString(8);
        double wallet = Generate.randomDouble(1000000, 0);
        String security = Generate.randomString(10);
        int supply = (int) Generate.randomDouble(1000000, 0);


        Trader.register(trader, wallet);
        Lister.register(lister, wallet);
        Security.list(lister, security, Generate.randomDouble(1000000, 0), supply);

        //adding an OwnedProduct with non-existing user
        boolean expected = false;
        boolean actual = Trader.addOwnedProduct(Generate.randomString(9), security, supply);

        assertEquals(expected, actual);


        //adding an OwnedProduct with non-existing security
        expected = false;
        actual = Trader.addOwnedProduct(trader, Generate.randomString(9), supply);
        assertEquals(expected, actual);

        //adding an Owned Product with amount larger than supply
        expected = false;
        actual = Trader.addOwnedProduct(trader, security, supply + (int) Generate.randomDouble(10,1));
        assertEquals(expected, actual);

        //successfully adding an owned product
        expected = true;
        actual = Trader.addOwnedProduct(trader, security, supply);
        assertEquals(expected, actual);

        //checking that product was successfully added
        expected = true;
        actual = false;
        try {
            actual = Trader.owns(trader, security, supply);
        }
        catch(NonExistingException e){
            fail();
        }
        assertEquals(expected, actual);

        //checking owns function with a product that doesn't exist
        expected = false;
        actual = true;
        try{
            actual = Trader.owns(trader, Generate.randomString(9), supply);
        }
        catch(NonExistingException e){
            fail();
        }
        assertEquals(expected, actual);

        //checking owns function with trader that doesn't exist
        try{
            Trader.owns(Generate.randomString(10), security, supply);
            fail();
        }
        catch(NonExistingException e){
            assertTrue(true);
        }

        //checking owns function with supply greater that owner has
        expected = false;
        try {
            actual = Trader.owns(trader, security, supply + (int) Generate.randomDouble(10, 1));
        }
        catch (NonExistingException e){
            fail();
        }
        assertEquals(expected, actual);


        assertTrue(Trader.removeOwnedProduct(trader, security, supply));
        try{
            assertFalse(Trader.owns(trader, security, supply));
        }
        catch(NonExistingException e){
            fail();
        }
    }

}
