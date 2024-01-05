package com.datastructure;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] 단방향 Linked List 뒤부터 세기 in Java (포인터)
 * 단방향 LinkedList의 끝에서 K번째 노드를 찾는 알고리즘을 구현 하시오.
 *  -> O(N) 의 시간을 사용하는 알고리즘
 *  -> O(1) 의 공간을 사용하는 알고리즘
 */
class LinkedList5 {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList5() {
        header = new Node();
    }

    void append (int d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // 삭제
    void delete(int d) {
        Node n = header;
        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = header.next;
        while(n.next != null) {
            System.out.print(n.data+ " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDups() {
        Node n = header;
        while(n != null && n.next != null) {
            Node r = n;
            while(r.next != null) {
                if(n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    Node getFirst() {
        return header;
    }

    Node KthToLast(Node first, int k) {
        Node p1 = first;
        Node p2 = first;

        for(int i=0; i<k; i++) {
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}

public class SinglyLinkedListAlg3 {
    public static void main(String[] args) {
        LinkedList5 ll = new LinkedList5();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        int k = 1;
        System.out.println(ll.KthToLast(ll.getFirst(), k).data);
    }
}
