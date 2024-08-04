package com.javacore.lesson04;

import java.util.ArrayList;

public class Stack {

    ArrayList<Integer> integersArrayList = new ArrayList<>();

    int size = 0;

    public void push(int num) {
        integersArrayList.add(size, num);
        size++;
    }

    public void pop() {
        integersArrayList.remove(--size);

    }

    public String toString() {
        String str = "";
        for (int i : integersArrayList) {
            str += i+" ";
        }
        return str;
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(0);
        st.push(1);
        st.push(2);

        System.out.println(st);

        st.pop();

        System.out.println(st);
    }
}
