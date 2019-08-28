package multiplication;

import multiplication.service.Multiplication;
import multiplication.service.impl.MultiplicationBigIntegerImpl;
import multiplication.service.impl.MultiplicationScratchImpl;

import java.util.Scanner;

public class RunApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstNumber;
        String secondNumber;
        int choice;
        Multiplication multiplication;

        System.out.println("Please input first number");
        firstNumber = scanner.nextLine();
        System.out.println("Please input second number");
        secondNumber = scanner.nextLine();
        System.out.println("How do you want to make calculation:\n" +
                "1) algorithm from scratch\n" +
                "2) BigInteger class algorithm");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                multiplication = new MultiplicationScratchImpl(firstNumber, secondNumber);
                break;
            case 2:
            default:
                multiplication = new MultiplicationBigIntegerImpl(firstNumber, secondNumber);
        }
        System.out.println(multiplication.multiply());
    }
}
