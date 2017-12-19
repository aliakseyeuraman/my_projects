package dataInput;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class for input number
 */
public class InputNumber {
    private Scanner in = new Scanner(System.in);

    public Number input() throws InputMismatchException {
        try {
            System.out.println("Enter number: ");
            return in.nextBigInteger();
        } catch (InputMismatchException e) {
            System.out.println("Please, enter only number!");
        }
        return null;
    }
}
