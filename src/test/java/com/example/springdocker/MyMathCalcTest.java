package com.example.springdocker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathCalcTest {

    MyMathCalc mathCalc;

    @BeforeEach
    void init(){
        mathCalc = new MyMathCalc();
    }

    @Test
    void add() {
        int value1 = 1;
        int value2 = 2;
        int expected = value1 + value2;

        int result = mathCalc.add(value1,value2);

        assertEquals(expected,result);
    }

    @Test
    void sub() {
        int value1 = 1;
        int value2 = 2;
        int expected = value1 - value2;

        int result = mathCalc.sub(value1,value2);

        assertEquals(expected,result);
    }

    @Test
    void div() {
        double value1 = 10;
        double value2 = 2;
        double expected = value1 / value2;

        double result = mathCalc.div(value1,value2);

        assertEquals(expected,result);
    }

    @Test
    void divThrowsErrorWhenDivBy0() {
        double value1 = 10;
        double value2 = 0;

        assertThrows(ArithmeticException.class, () -> mathCalc.div(value1,value2));

    }
}