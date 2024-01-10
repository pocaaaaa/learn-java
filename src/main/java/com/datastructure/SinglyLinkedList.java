package com.datastructure;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] 단방향 Linked List 구현 in Java 실습
 */
class Node {
    int data;
    Node next = null;
    Node (int d) {
        this.data = d;
    }

    // 추가
    void append (int d) {
        Node end = new Node(d);
        Node n = this;

        // 맨 마지막 노드를 찾음
        while(n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    // 삭제
    void delete(int d) {
        Node n = this;
        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = this;
        while(n.next != null) {
            System.out.print(n.data+ " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    public Node addNext(int i) {
        Node n = new Node(i);
        this.next = n;
        return n;
    }

    public Node addNext(Node n) {
        this.next = n;
        return n;
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        head.delete(2);
        head.delete(3);
        head.retrieve();
    }
}
