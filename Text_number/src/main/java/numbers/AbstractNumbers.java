package numbers;

import java.math.BigInteger;

/**
 * class for checking numbers for correctness and format numbers to string
 */
public abstract class AbstractNumbers {
    private static final BigInteger MAX_SUPPORTED = new BigInteger("1000000000000000000000000000000000000").subtract(BigInteger.ONE);
    private static final String EXEPTION = "Support only Integer numbers: BigInteger, Integer, Long and Short."
            + "Floating-point is not supported";

    void checkSupported(Number number) {
        if (number instanceof Integer
                || number instanceof Long
                || number instanceof Short
                || number instanceof Byte) {
        } else if (number instanceof BigInteger) {
            BigInteger bi = (BigInteger) number;
            if (bi.abs().compareTo(MAX_SUPPORTED) > 0) {
                throw new IllegalArgumentException("Max supported number:" + MAX_SUPPORTED);
            }
        } else {
            throw new IllegalArgumentException(EXEPTION);
        }
    }

    public abstract String format(Number number);
}
