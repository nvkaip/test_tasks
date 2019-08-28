package multiplication.service.impl;

import multiplication.service.Multiplication;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class MultiplicationScratchImpl implements Multiplication {

    private String firstNumber;
    private String secondNumber;

    public MultiplicationScratchImpl(String firstNumber, String secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public BigInteger multiply() {

        if (firstNumber.equals("0") || secondNumber.equals("0")) {
            return new BigInteger("0");
        }
        int sign = 1;
        if (firstNumber.charAt(0) == '-' & secondNumber.charAt(0) != '-' ||
                firstNumber.charAt(0) != '-' & secondNumber.charAt(0) == '-') {
            sign = -1;
            firstNumber = firstNumber.replace("-", "");
            secondNumber = secondNumber.replace("-", "");
        }
        int[] firstNumberToArray = Stream.of(firstNumber.split("")).mapToInt(Integer::parseInt).toArray();
        int[] secondNumberToArray = Stream.of(secondNumber.split("")).mapToInt(Integer::parseInt).toArray();
        int[] resultArray = new int[firstNumberToArray.length + secondNumberToArray.length];

        int count = 1;
        for (int i = secondNumberToArray.length - 1; i >= 0; i--) {
            int k = resultArray.length - count;
            for (int j = firstNumberToArray.length - 1; j >= 0; j--) {
                resultArray[k] += (firstNumberToArray[j] * secondNumberToArray[i]) % 10;
                resultArray[k - 1] += (firstNumberToArray[j] * secondNumberToArray[i]) / 10;
                k--;
            }
            count++;
        }
        for (int i = resultArray.length - 1; i > 0; i--) {
            resultArray[i - 1] += resultArray[i] / 10;
            resultArray[i] = resultArray[i] % 10;
        }

        String result = Arrays.toString(resultArray).replaceAll("\\D*", "");
        result = (sign < 0) ? "-".concat(result) : result;

        return new BigInteger(result);
    }
}
