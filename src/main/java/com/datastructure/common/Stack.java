package com.datastructure.common;

import java.util.EmptyStackException;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] Stack 구현하기 in Java
 *  - LIFO
 */
public class Stack<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public T pop() {
        if(top == null) {
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> t = new Node<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if(top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
