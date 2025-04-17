package com.musthavejava.chapter22;

interface Unit5 {
    void move(String s);
}

class Human5 implements Unit5 {
    @Override
    public void move(String s) {
        System.out.println(s);
    }
}

public class Ex05_Lambda1 {
    public static void main(String[] args) {
        Unit5 unit5 = new Human5();
        unit5.move("named : Unit 5");
    }
}
