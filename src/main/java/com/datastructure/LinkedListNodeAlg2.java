package com.datastructure;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] Linked List 값에 따라 나누기 in JAVA
 * Linked List에 있는 노드을을 x값을 기준으로 값이 작은것들은 왼쪽, 큰것들은 오른쪽 두 파트로 나누시오.
 * (단, x는 오른쪽 파트 어디에 놔도 상관없음)
 * 1. 두 줄로 세우기
 * 2. 앞 뒤로 붙이기
 */
class LinkedList7 {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList7() {
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

    Node partition1(Node n, int x) {
      Node s1 = null;
      Node e1 = null;
      Node s2 = null;
      Node e2 = null;

      while(n != null) {
          Node next = n.next;
          n.next = null;
          if(n.data < x) {
              if(s1 == null) {
                  s1 = n;
                  e1 = s1;
              } else {
                  e1.next = n;
                  e1 = n;
              }
          } else {
              if(s2 == null) {
                  s2 = n;
                  e2 = s2;
              } else {
                  e2.next = n;
                  e2 = n;
              }
          }
          n = next;
      }
      if(s1 == null) {
          return s2;
      }
      e1.next = s2;
      return s1;
    }

    Node partition2(Node n, int x) {
        Node head = n;
        Node tail = n;

        while (n != null) {
            Node next = n.next;
            if(n.data < x) {
                n.next = head;
                head = n;
            } else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null;
        return head;
    }
}

public class LinkedListNodeAlg2 {
    public static void main(String[] args) {
        LinkedList7 ll = new LinkedList7();
        ll.append(7);
        ll.append(2);
        ll.append(8);
        ll.append(5);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        // 1. 두 줄로 세우기
        LinkedList7.Node n = ll.partition1(ll.get(1), 5);
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        };
        System.out.println(n.data);

        ll = new LinkedList7();
        ll.append(7);
        ll.append(2);
        ll.append(8);
        ll.append(5);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        // 2. 앞 뒤로 붙이기
        LinkedList7.Node n2 = ll.partition2(ll.get(1), 5);
        while(n2.next != null) {
            System.out.print(n2.data + " -> ");
            n2 = n2.next;
        };
        System.out.println(n2.data);

    }
}
