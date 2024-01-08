package com.datastructure;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] Linked List Digit 합산 알고리즘 in Java
 * Linked List 알고리즘 - 재귀호출
 * 어떤 숫자를 자리수 별로 한 개씩 Linked List에 담았다.
 * 그런데 1의 자리가 헤더에 오도록 거꾸로 담았다.
 * 이런식의 Linked List 두 갤ㄹ 받아서 합산하고 같은 식으로 Linked List에 담아서 반환하라.
 *
 * [심화학습] Linked List에 숫자가 거꾸로가 아니면?
 *  - 좀 더 복잡.
 *  - 4 -> 1 -> 9 / 3 -> 4 이면 첫 번째 노드끼리 계산할 수 없음.
 *  - 두 개의 노드의 길이를 알아야 함.
 *  - 짧은 노드의 앞에 값을 0으로 채움.
 */
class LinkedList8 {
    Node header;

    static class Node {
        int data;
        Node next = null;

        public Node() {
            super();
        }

        public Node(int data) {
            this.data = data;
        }
    }

    LinkedList8() {
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

    Node sumLists(Node l1, Node l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int value = carry;

        if(l1 != null) {
            value += l1.data;
        }
        if(l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;

        if(l1 != null || l2 != null) {
            Node next = sumLists(l1 == null ? null : l1.next,
                                 l2 == null ? null : l2.next,
                                 value >= 10 ? 1 : 0);
            result.next = next;
        }

        return result;
    }

    Node sumLists2(Node l1, Node l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if(len1 < len2) {
            l1 = LPadList(l1, len2 - len1);
        } else {
            l2 = LPadList(l2, len1 - len2);
        }

        Storage storage = addLists(l1, l2);
        if(storage.carry != 0) {
            storage.result = insertBefore(storage.result, storage.carry);
        }
        return storage.result;
    }

    Storage addLists(Node l1, Node l2) {
        if(l1 == null && l2 == null) {
            Storage storage = new Storage();
            return storage;
        }
        Storage storage = addLists(l1.next, l2.next);
        int value = storage.carry + l1.data + l2.data;
        int data = value % 10;
        storage.result = insertBefore(storage.result, data);
        storage.carry = value / 10;
        return storage;
    }

    int getListLength(Node l) {
        int total = 0;
        while(l != null) {
            total++;
            l = l.next;
        }
        return total;
    }

    Node insertBefore(Node node, int data) {
        Node before = new Node(data);
        if(node != null) {
            before.next = node;
        }
        return before;
    }

    Node LPadList(Node l, int length) {
        Node head = l;
        for(int i = 0; i < length; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }
}

class Storage {
    int carry = 0;
    LinkedList8.Node result = null;
}

public class LinkedListNodeAlg3 {
    public static void main(String[] args) {
        LinkedList8 l1 = new LinkedList8();
        //l1.append(9);
        //l1.append(1);
        //l1.append(4);
        l1.append(1);
        l1.retrieve();

        LinkedList8 l2 = new LinkedList8();
        //l2.append(6);
        //l2.append(4);
        //l2.append(3);
        l2.append(9);
        l2.append(9);
        l2.retrieve();

        //LinkedList8.Node n = l2.sumLists(l1.get(1), l2.get(1), 0);
        LinkedList8.Node n = l2.sumLists2(l1.get(1), l2.get(1));
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);

        // 심화학습

    }
}
