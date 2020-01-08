import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ListerTest {

    //same tests from trader
    @Test
    public void ListerTest0(){


        double maxWallet = 100000000;
        double minWallet = 0;

        //successfully creating a new user
        String generatedString = Generate.randomString(10);
        boolean expected = true;
        double wallet = Generate.randomDouble(maxWallet, minWallet);
        boolean actual = Lister.register(generatedString, wallet);
        assertEquals(expected, actual);

        double returnedWallet = 0;
        try{
            returnedWallet = Lister.getWallet(generatedString);
        }
        catch (NonExistingException e){
            fail();
        }
        assertEquals(returnedWallet, wallet, 0.001);

        //creating a second user
        String generatedString1 = Generate.randomString(10);
        double wallet1 = Generate.randomDouble(maxWallet, minWallet);
        actual = Lister.register(generatedString1, wallet1);
        assertEquals(expected, actual);
        try{
            returnedWallet = Lister.getWallet(generatedString1);
        }
        catch (NonExistingException e){
            fail();
        }
        assertEquals(returnedWallet, wallet1, 0.001);

        //creating a user that already exists
        expected = false;
        actual = Lister.register(generatedString, Generate.randomDouble(maxWallet, minWallet));
        assertEquals(expected, actual);

        //creating a user with negative wallet amount
        String generatedString2 = Generate.randomString(10);
        expected = false;
        actual = Lister.register(generatedString2, Generate.randomDouble(0, -100));
        assertEquals(expected, actual);

        //checking created users
        assertEquals(generatedString, Lister.getList().get(0).getName());
        assertEquals(generatedString1, Lister.getList().get(1).getName());

        expected = true;
        actual = Lister.exists(generatedString);
        assertEquals(expected, actual);
        actual = Lister.exists(generatedString1);
        assertEquals(expected, actual);

        expected = false;
        actual = Lister.exists(generatedString2);
        assertEquals(expected, actual);

        //adding wallet to a non-existing user
        expected = false;
        actual = Lister.increaseWallet(generatedString2, Generate.randomDouble(maxWallet, minWallet));
        assertEquals(expected, actual);

        //adding wallet with negative amount to user
        expected = false;
        actual = Lister.increaseWallet(generatedString, Generate.randomDouble(0, -100));
        assertEquals(expected, actual);

        //adding to a wallet of a user
        double walletIncrease = Generate.randomDouble(maxWallet, minWallet);
        expected = true;
        actual = Lister.increaseWallet(generatedString, walletIncrease);
        assertEquals(expected, actual);
        try{
            returnedWallet = Lister.getWallet(generatedString);
        }
        catch (NonExistingException e){
            fail();
        }
        assertEquals(returnedWallet, wallet + walletIncrease, 0.001);

        //subtracting wallet of a non-existing user
        expected = false;
        actual = Lister.decreaseWallet(generatedString2, Generate.randomDouble(maxWallet, minWallet));
        assertEquals(expected, actual);

        //subtracting wallet with a negative number
        expected = false;
        actual = Lister.decreaseWallet(generatedString1, Generate.randomDouble(0, -100));
        assertEquals(expected, actual);

        //subtracting wallet with a number greater than the current amount
        expected = false;
        actual = Lister.decreaseWallet(generatedString1, wallet1 + Generate.randomDouble(100, 1));
        assertEquals(expected, actual);

        //subtracting to a wallet of a user
        double walletDecrease = Generate.randomDouble(wallet1, minWallet);
        expected = true;
        actual = Lister.decreaseWallet(generatedString1, walletDecrease);
        assertEquals(expected, actual);
        try{
            returnedWallet = Lister.getWallet(generatedString1);
        }
        catch (NonExistingException e){
            fail();
        }
        assertEquals(returnedWallet, wallet1 - walletDecrease, 0.001);
    }

    @Test
    public void ListerTest1(){

    }
}
