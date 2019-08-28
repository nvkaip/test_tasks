package multiplication.service.impl;

import multiplication.service.Multiplication;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationScratchImplTest {

    @Test
    public void multiply() {

        String firstNumber = "-12345678901234567890";
        String secondNumber = "11111111111111111111";

        Multiplication expected = new MultiplicationScratchImpl(firstNumber, secondNumber);
        Multiplication actual = new MultiplicationBigIntegerImpl(firstNumber, secondNumber);

        Assert.assertEquals(expected.multiply(), actual.multiply());
    }
}