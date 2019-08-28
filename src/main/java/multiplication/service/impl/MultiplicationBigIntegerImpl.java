package multiplication.service.impl;

import multiplication.service.Multiplication;

import java.math.BigInteger;

public class MultiplicationBigIntegerImpl implements Multiplication {

    private BigInteger firstNumber;
    private BigInteger secondNumber;

    public MultiplicationBigIntegerImpl(String firstNumber, String secondNumber) {
        this.firstNumber = new BigInteger(firstNumber);
        this.secondNumber = new BigInteger(secondNumber);
    }

    @Override
    public BigInteger multiply() {
        return firstNumber.multiply(secondNumber);
    }
}
