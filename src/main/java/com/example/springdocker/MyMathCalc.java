package com.example.springdocker;

public class MyMathCalc {

    public int add(int a, int b){
        return a + b;
    }
  
    public int sub(int a, int b){
        return a - b;
    }
  
    public double div(double a, double b){
        if(b == 0){
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
