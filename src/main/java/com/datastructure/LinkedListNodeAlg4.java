package com.datastructure;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] Linked List 교차점 찾기 in Java
 *  - 주어진 두 개의 단방향 Linked List에서 교차되는 노드를 찾으시오. => 교차점 : 두 개의 리스트가 하나로 합쳐지는 지점.
 *    (단, 교차점은 값이 아닌 주소로 찾아야함.)
 *  - Node로 구현해야 하는데 잘 못 한듯함... 의미만 이해하는걸로!
 */
public class LinkedListNodeAlg4 {
    public static void main(String[] args) {
        LinkedList8 l1 = new LinkedList8();
        l1.append(5);
        l1.append(7);
        l1.append(9);
        l1.append(10);
        l1.append(7);
        l1.append(6);

        LinkedList8 l2 = new LinkedList8();
        l2.append(6);
        l2.append(8);
        l2.append(10);
        l2.append(7);
        l2.append(6);

        l1.retrieve();
        l2.retrieve();
        LinkedList8.Node n = getIntersection(l1, l2, l1.getListLength(l1.get(1)), l2.getListLength(l2.get(1)));
        if(n != null) {
            System.out.println("Intersection: "+n.data);
        } else {
            System.out.println("Not Found");
        }
    }

    private static LinkedList8.Node getIntersection(LinkedList8 l1, LinkedList8 l2, int len1, int len2) {
        LinkedList8.Node n1 = l1.get(1);
        LinkedList8.Node n2 = l2.get(1);

        if(len1 > len2) {
            n1 = l1.get((len1 - len2) + 1);
        } else if(len1 < len2) {
            n2 = l2.get(len2 - len1);
        }

        while(n1 != null && n2 != null) {
            System.out.println("n1.data : "+n1.data+", n2.data : "+n2.data);
            if(n1.data == n2.data) {
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return null;
    }

}
