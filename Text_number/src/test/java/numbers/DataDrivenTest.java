package numbers;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class DataDrivenTest {

    @Test
    public void format() throws Exception {
        NumbersToString r = new NumbersToString();

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
}