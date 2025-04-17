package com.musthavejava.chapter22;

interface Unit9 {
    int calc(int a, int b);
}

public class Ex09_LambdaRule2 {
    public static void main(String[] args) {
        Unit9 unit;
        unit = (a, b) -> { return a + b; };
        // unit = a, b -> { return a + b; }; -> 잘못된 방식
        // unit = (a, b) -> return a + b; -> 잘못된 방식

        int num = unit.calc(10, 20);
        System.out.println(num);

        unit = (a, b) -> a * b;
        System.out.println(unit.calc(10, 20));

    }
}
