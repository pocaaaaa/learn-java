package com.datastructure.common;

import java.util.NoSuchElementException;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] Queue 구현하기 in Java
 *  - FIFO
 */
public class Queue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<T>(item);

        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if(first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
