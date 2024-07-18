package com.javacore.lesson03;

import java.util.Iterator;

public class MyArrayList implements Iterable<String> {

    private String[] stringsArray = new String[0];

    private int size = 0;

    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return this.size;
    }


    public String get(int index) {
        rangeCheck(index);
        return stringsArray[index];
    }


    public boolean set(int index, String str) {
        rangeCheck(index);
        if (this.isEmpty()) {
            return false;
        }else {
            stringsArray[index] = str;
            return true;
        }
    }


    public boolean remove(int index) {
        rangeCheck(index);
        final String[] m = stringsArray;
        stringsArray = new String[this.size-1];
        size--;

        for (int i = 0; i < index; i++) {
            stringsArray[i] = m[i];
        }
        for (int i = index; i < this.size(); i++) {
            stringsArray[i] = m[i+1];
        }

        return true;
    }

    public boolean remove(String text) {
       Iterator<String> strIterator = this.iterator();
       while (strIterator.hasNext()) {
           String str = strIterator.next();
           if (str.equals(text)) {
               strIterator.remove();
               return true;
           }
       }
       return false;
    }

    public boolean add(int index, String text) {
        rangeCheckForAdd(index);
        final String[] m = stringsArray;
        stringsArray = new String[this.size+1];

        for (int i = 0; i < index; i++) {
            stringsArray[i] = m[i];
        }
        stringsArray[index] = text;
        for (int i = index; i < this.size(); i++) {
            stringsArray[i+1] = m[i];
        }
        size++;
        return true;
    }

    public boolean add(String text) {
        final String[] m = stringsArray;
        stringsArray = new String[this.size+1];

        for (int i = 0; i < this.size(); i++) {
            stringsArray[i] = m[i];
        }
        stringsArray[this.size()] = text;
        size++;
        return true;
    }

    public boolean isEmpty() {
        if (size==0) {
            return true;
        }
        return false;
    }

    public String toString() {
        String tempStr = "";
        for (String str: stringsArray) {
            tempStr = tempStr + "|" + str + "|\n";
        }
        return tempStr;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return MyArrayList.this.stringsArray.length > index;
        }

        @Override
        public String next() {
            return MyArrayList.this.stringsArray[index++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(index-1);
            index--;
        }
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0, "text1");
        myArrayList.add(1, "text2");
        myArrayList.add(2, "text3");
        myArrayList.add("text4");
        System.out.println(myArrayList);
        myArrayList.remove("text3");
        myArrayList.remove("text1");

        System.out.println(myArrayList);
        myArrayList.remove(0);
        System.out.println(myArrayList);
        System.out.println();
        myArrayList.add("text1");
        System.out.println(myArrayList);
        System.out.println();


        try {
            myArrayList.add(10,"fffffffffff");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException add");
        }

        try {
            myArrayList.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException get");
        }

        try {
            myArrayList.remove(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException remove");
        }


        myArrayList.set(1, "textset");
        myArrayList.add(1, "text1");
        System.out.println(myArrayList);
        System.out.println();
        System.out.println(myArrayList.get(0));
        System.out.println();

        for (String str:myArrayList) {
            System.out.println(str);
        }
        System.out.println();

        System.out.println(myArrayList.size());
    }
}
