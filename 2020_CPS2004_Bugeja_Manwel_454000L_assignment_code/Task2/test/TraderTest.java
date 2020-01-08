
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TraderTest {

    private String randomString(int length){
        byte[] array = new byte[length];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }

    private double randomDouble(double max, double min){
        return (Math.random() * (max - min)) + min;
    }

    //tests creating a new user successfully
    @Test
    public void TraderTest0(){


        double maxWallet = 100000000;
        double minWallet = 0;

        //successfully creating a new user
        String generatedString = randomString(10);
        boolean expected = true;
        double wallet = randomDouble(maxWallet, minWallet);
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
        String generatedString1 = randomString(10);
        double wallet1 = randomDouble(maxWallet, minWallet);
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
        actual = Trader.register(generatedString, randomDouble(maxWallet, minWallet));
        assertEquals(expected, actual);

        //creating a user with negative wallet amount
        String generatedString2 = randomString(10);
        expected = false;
        actual = Trader.register(generatedString2, randomDouble(0, -100));
        assertEquals(expected, actual);

        //checking created users
        assertEquals(generatedString, Trader.getList().get(0).getName());
        assertEquals(generatedString1, Trader.getList().get(1).getName());

        //adding wallet to a non-existing user
        expected = false;
        actual = Trader.increaseWallet(generatedString2, randomDouble(maxWallet, minWallet));
        assertEquals(expected, actual);

        //adding wallet with negative amount to user
        expected = false;
        actual = Trader.increaseWallet(generatedString, randomDouble(0, -100));
        assertEquals(expected, actual);

        //adding to a wallet of a user
        double walletIncrease = randomDouble(maxWallet, minWallet);
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
        actual = Trader.decreaseWallet(generatedString2, randomDouble(maxWallet, minWallet));
        assertEquals(expected, actual);

        //subtracting wallet with a negative number
        expected = false;
        actual = Trader.decreaseWallet(generatedString1, randomDouble(0, -100));
        assertEquals(expected, actual);

        //subtracting wallet with a number greater than the current amount
        expected = false;
        actual = Trader.decreaseWallet(generatedString1, wallet1 + randomDouble(100, 1));
        assertEquals(expected, actual);

        //subtracting to a wallet of a user
        double walletDecrease = randomDouble(wallet1, minWallet);
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
    }
}
