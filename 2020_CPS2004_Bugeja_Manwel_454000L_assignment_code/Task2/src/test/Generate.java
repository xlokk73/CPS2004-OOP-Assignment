import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Generate {
    static public String randomString(int length){
        byte[] array = new byte[length];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }

    static public double randomDouble(double max, double min){
        return (Math.random() * (max - min)) + min;
    }
}
