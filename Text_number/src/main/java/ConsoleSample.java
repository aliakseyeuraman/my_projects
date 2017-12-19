import dataInput.InputNumber;
import dataOutput.PrintResult;
import numbers.NumbersToString;

import java.util.InputMismatchException;


public class ConsoleSample {
    /**
     * entry point of program
     *
     * @param args is noy used
     * @throws InputMismatchException
     */
    public static void main(String[] args) throws InputMismatchException {
        try {
            NumbersToString numbersToString = new NumbersToString();
            InputNumber inputNumber = new InputNumber();
            PrintResult printResult = new PrintResult();
            printResult.print(numbersToString.format(inputNumber.input()));
        } catch (InputMismatchException e) {
            System.out.println("Please, enter only number!");
        }
    }
}
