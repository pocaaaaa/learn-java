package com.udemy.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericsRunner {

    static <X> X doubleValue(X value) {
        return value;
    }

    static <X extends List> void duplicate(X list) {
        list.addAll(list);
    }

    // 상한 경계 와일드카드
    // ? : 와일드카드
    // 숫자 클래스를 연장하는 어떠한 리스트에나 매개변수로 입력될 수 있음.
    static double sumOfNumberList(List<? extends Number> numbers) {
        double sum = 0.0;
        for(Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    // 하한 경계 와일드카드
    static void addCoupleOfValues(List<? super Number> numbers) {
        numbers.add(1);
        numbers.add(1.0);
        numbers.add(1.0f);
        numbers.add(1L);
    }

    public static void main(String[] args) {
        List emptyList = new ArrayList<Number>();
        addCoupleOfValues(emptyList);
        System.out.println(emptyList);

        System.out.println(sumOfNumberList(List.of(1,2,3,4,5)));
        System.out.println(sumOfNumberList(List.of(1.1,2.1,3.1,4.1,5.1)));
        System.out.println(sumOfNumberList(List.of(1L,2L,3L,4L,5L)));

        String value4 = doubleValue(new String());
        Integer number4 = doubleValue(Integer.valueOf("5"));
        ArrayList list4 = doubleValue(new ArrayList());

        ArrayList numbers = new ArrayList<>(List.of("1", "2", "3"));
        duplicate(numbers);

        LinkedList numbers2 = new LinkedList(List.of("1", "2", "3"));
        duplicate(numbers2);

        System.out.println(numbers);
        System.out.println(numbers2);

//        MyCustomList<String> list = new MyCustomList<>();
//        list.addElement("Element 1");
//        list.addElement("Element 2");
//        String value = list.get(0);
//        System.out.println(list.toString());
//        System.out.println(value);

        MyCustomList<Integer> list2 = new MyCustomList<>();
        list2.addElement(Integer.valueOf("1"));
        list2.addElement(Integer.valueOf("2"));
        Integer number = list2.get(0);
        System.out.println(list2.toString());
        System.out.println(number);

        MyCustomList<Long> list3 = new MyCustomList<>();
        list3.addElement(5L);
        list3.addElement(7L);
        Long number2 = list3.get(0);
        System.out.println(list3.toString());
        System.out.println(number2);
    }
}
