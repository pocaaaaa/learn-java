package com.datastructure;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] 단방향 Linked List 뒤부터 세기 in Java
 * 단방향 LinkedList의 끝에서 K번째 노드를 찾는 알고리즘을 구현 하시오.
 */
class LinkedList3 {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList3() {
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
        Node n = first;
        int total = 1;
        while(n.next != null) {
            total++;
            n = n.next;
        }
        n = first;
        for(int i=1; i<total-k+1; i++) {
            n = n.next;
        }
        return n;
    }
}

public class SinglyLinkedListAlg1 {
    public static void main(String[] args) {
        LinkedList3 ll = new LinkedList3();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        int k = 3;
        System.out.println("Last k(" + k + ")th data is "+ll.KthToLast(ll.getFirst(), k).data);
    }
}
