package scorekeep;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Identifiers {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String random() {
        return new BigInteger(40, secureRandom).toString(32).toUpperCase();
    }

}
