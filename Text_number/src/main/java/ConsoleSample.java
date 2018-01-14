import dataInput.InputNumber;
import dataOutput.PrintResult;
import numbers.NumbersToString;

import java.util.InputMismatchException;


public class ConsoleSample {
    /**
     * entry point of program
     *
     * @param args is not used
     * @throws InputMismatchException
     */
    public static void main(String[] args) throws InputMismatchException {
            NumbersToString numbersToString = new NumbersToString();
            InputNumber inputNumber = new InputNumber();
            PrintResult printResult = new PrintResult();
            printResult.print(numbersToString.format(inputNumber.input()));

    }
}
