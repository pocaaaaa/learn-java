package com.musthavejava.chapter22;

interface Unit6 {
    void move(String s);
}

public class Ex06_Lambda2 {
    public static void main(String[] args) {
        Unit6 unit6 = new Unit6() {
            @Override
            public void move(String s) {
                System.out.println(s);
            }
        };

        unit6.move("anonymous : Unit 6");
    }
}
