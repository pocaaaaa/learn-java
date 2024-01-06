package com.datastructure;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] 단방향 Linked List 중간노드 삭제 in JAVA
 * 단방향 Linked List에서 중간에 있는 노드를 삭제하시오.
 * (단, 당신은 첫번쨰 노드가 어디있는지 모르고, 오직 삭제할 노드만 가지고 있다.)
 */
class LinkedList6 {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList6() {
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

    Node get(int index) {
        Node n = header;
        for(int i=0; i<index; i++) {
            n = n.next;
        }
        return n;
    }

    Boolean deleteNode(Node n) {
        if(n == null || n.next == null) {
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}

public class LinkedListNodeAlg1 {
    public static void main(String[] args) {
        LinkedList6 ll = new LinkedList6();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.deleteNode(ll.get(2));
        ll.retrieve();
    }
}
