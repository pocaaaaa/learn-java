package com.musthavejava.chapter21;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex15_HashMapKeySet {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("홍길동", 20);
        map.put("전우치", 25);
        map.put("손오공", 27);

        Set<String> ks = map.keySet();

        for(String s : ks)
            System.out.print(s + '\t');
        System.out.println();

        for(String s : ks)
            System.out.print(map.get(s).toString() + '\t');
        System.out.println();

        for(Iterator<String> itr = ks.iterator(); itr.hasNext(); )
            System.out.print(map.get(itr.next()).toString() + '\t');
        System.out.println();
    }
}
