package com.musthavejava.chapter22;

interface Unit4 {
    void move();
}

class HumanCamp4 {
    private int speed = 10;

    public Unit4 getMarine() {
        return new Unit4() {
            @Override
            public void move() {
                System.out.printf("인간형 유닛이 %d 속도로 이동합니다.\n", speed);
            }
        };
    }
}

public class Ex04_AnonymousInner2 {
    public static void main(String[] args) {
        HumanCamp4 hc = new HumanCamp4();
        Unit4 unit = hc.getMarine();
        unit.move();
    }
}
