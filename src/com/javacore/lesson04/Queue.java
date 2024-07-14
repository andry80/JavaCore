package com.javacore.lesson04;

import java.util.LinkedList;

public class Queue {
    LinkedList<Integer> integersLinkedList = new LinkedList<Integer>();
    int size = 0;

    public void push(int num) {
        integersLinkedList.add(0, num);
        size++;


    }

    public void poll() {
        integersLinkedList.remove(--size);
    }

    public String toString() {
        String str = "";
        for (int i :integersLinkedList) {
            str += i+" ";
        }
        return str;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.push(0);
        queue.push(1);
        queue.push(2);

        System.out.println(queue);

        queue.poll();

        System.out.println(queue);

    }
}
