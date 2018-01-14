package numbers;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class DataDrivenTest {
    private NumbersToString r = new NumbersToString();

    @Test
    public void testFormat() throws Exception {
        assertEquals("ноль", r.format(0));
        assertEquals("один", r.format(1));
        assertEquals("два", r.format(2));
        assertEquals("три", r.format(3));
        assertEquals("четыре", r.format(4));
        assertEquals("пять", r.format(5));
        assertEquals("шесть", r.format(6));
        assertEquals("семь", r.format(7));
        assertEquals("восемь", r.format(8));
        assertEquals("девять", r.format(9));
        assertEquals("десять", r.format(10));

        assertEquals("две тысячи", r.format(2000));
        assertEquals("одна тысяча", r.format(1000));
        assertEquals("четыре тысячи", r.format(4000));
        assertEquals("сто двадцать две тысячи", r.format(122000));
        assertEquals("сто двадцать одна тысяча", r.format(121000));
        assertEquals("одиннадцать тысяч", r.format(11000));

        assertEquals("один триллион", r.format(new BigInteger("1000000000000")));
        assertEquals("десять триллионов", r.format(new BigInteger("10000000000000")));
        assertEquals("сто триллионов", r.format(new BigInteger("100000000000000")));
        assertEquals("сто квадриллионов", r.format(new BigInteger("100000000000000000")));
        assertEquals("сто миллионов", r.format(new BigInteger("100000000")));
    }

    @Test
    public void negativeTestFormat() throws Exception {
        assertNotEquals("нуль", r.format(0));
        assertNotEquals("адин", r.format(1));
        assertNotEquals("две", r.format(2));
        assertNotEquals("тре", r.format(3));
        assertNotEquals("четыри", r.format(4));
        assertNotEquals("пяти", r.format(5));
        assertNotEquals("шэсть", r.format(6));
        assertNotEquals("сем", r.format(7));
        assertNotEquals("восем", r.format(8));
        assertNotEquals("девяти", r.format(9));
        assertNotEquals("ста", r.format(100));
        assertNotEquals("тысяч", r.format(1000));
        assertNotEquals("десять тысячи", r.format(10000));
        assertNotEquals("ста тысяч", r.format(100000));
        assertNotEquals("миллиона", r.format(1000000));
        assertNotEquals("десяти миллионов", r.format(10000000));
        assertNotEquals("ста миллионов", r.format(100000000));
        assertNotEquals("миллиардов", r.format(1000000000));
        assertNotEquals("десять миллиардов", r.format(new BigInteger("1000000000000")));
    }

    @Test
    public void testNegativeNumber() throws Exception {
        assertEquals("ноль", r.format(0));
        assertEquals("минус один", r.format(-1));
        assertEquals("минус два", r.format(-2));
        assertEquals("минус три", r.format(-3));
        assertEquals("минус четыре", r.format(-4));
        assertEquals("минус пять", r.format(-5));
        assertEquals("минус шесть", r.format(-6));
        assertEquals("минус семь", r.format(-7));
        assertEquals("минус восемь", r.format(-8));
        assertEquals("минус девять", r.format(-9));
        assertEquals("минус десять", r.format(-10));

        assertEquals("минус две тысячи", r.format(-2000));
        assertEquals("минус одна тысяча", r.format(-1000));
        assertEquals("минус четыре тысячи", r.format(-4000));
        assertEquals("минус сто двадцать две тысячи", r.format(-122000));
        assertEquals("минус сто двадцать одна тысяча", r.format(-121000));
        assertEquals("минус одиннадцать тысяч", r.format(-11000));

        assertEquals("минус один триллион", r.format(new BigInteger("-1000000000000")));
        assertEquals("минус десять триллионов", r.format(new BigInteger("-10000000000000")));
        assertEquals("минус сто триллионов", r.format(new BigInteger("-100000000000000")));
        assertEquals("минус сто квадриллионов", r.format(new BigInteger("-100000000000000000")));
        assertEquals("минус сто миллионов", r.format(new BigInteger("-100000000")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringNumber() throws Exception {
        r.format(new BigInteger("AAAAAAAAAAA"));
        r.format(new BigInteger("aaaaaaaaaaa"));
        r.format(new BigInteger("aAaAaAaAaAa"));
        r.format(new BigInteger("123abc"));
        r.format(new BigInteger("123ABC"));
        r.format(new BigInteger("1a2b3c"));
        r.format(new BigInteger("1A2B3C"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBigNumbers() throws Exception {
        r.format(new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999"));
        r.format(new BigInteger("99999999999999999999999999999999999999999999999999999999999"));
    }
}