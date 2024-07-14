package com.javacore.lesson04;

public class MyLinkedList {

    private Node node;

    private int size = 0;

    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return this.size;
    }

    public boolean nodeIsNull(Node node) {
        return node == null;
    }

    public boolean nextIsNull(Node node) {
        return node.getNext()==null;
    }

    public int get(int index) {
        rangeCheck(index);
        int i  = 0;
        Node nextNode = node;
        while (true) {
            if (i == index) {
                return nextNode.getElement();
            } else {
                i++;
                nextNode = nextNode.getNext();
            }
        }
    }

    public void set(int index, int num) {
        rangeCheck(index);
        int i  = 0;
        Node nextNode = node;
        while (true) {
            if (i == index) {
                nextNode.setElement(num);
                break;
            } else {
                i++;
                nextNode = nextNode.getNext();
            }
        }
    }

    public void remove(int index) {
        rangeCheck(index);
        int i  = 0;
        Node nextNode = node;
        if (index==0) {
            Node nextNode1 = nextNode.getNext();
            nextNode1.setPrev(null);
            nextNode.setNext(null);
            node = nextNode1;
            size--;
        } else {
            while (true) {
                if (i == index - 1) {
                    if (nextIsNull(nextNode.getNext())) {
                        nextNode.setNext(null);
                        size--;
                        break;
                    } else {
                        Node prewNode = nextNode;
                        nextNode = nextNode.getNext().getNext() ;

                        nextNode.setPrev(prewNode);
                        prewNode.setNext(nextNode);
                        size--;
                        break;
                    }
                } else {
                    nextNode = nextNode.getNext();
                    i++;
                }
            }
        }
    }

    public void add(int index, int num) {
        rangeCheck(index);
        int i  = 0;
        Node nextNode = node;
        Node headNode = nextNode;
        if (index==0) {
            headNode = new Node(num);
            headNode.setNext(nextNode);
            nextNode.setPrev(headNode);
            node = headNode;
        } else {
            while (true) {
                headNode = headNode.getNext();
                if (i != index - 1) {
                    i++;
                    nextNode = nextNode.getNext();
                } else {
                    nextNode.setNext(new Node(num));
                    Node nextNode1 = nextNode.getNext();
                    nextNode1.setPrev(nextNode);
                    nextNode1.setNext(headNode);
                    size++;
                    break;
                }
            }
        }
    }

    public void add(int num) {
        if (nodeIsNull(node)) {
            this.node = new Node(num);
        } else {
            node.setPrev(new Node(num));
            Node prevNode = node.getPrev();
            prevNode.setNext(node);
            node = prevNode;
        }
        size++;
    }

    @Override
    public String toString() {
        String str = "[";
        Node nextNode = node;
        while (true) {
            str += nextNode.getElement()+ " ";
            if (nodeIsNull(nextNode.getNext())) {
                str += "]";
                break;
            } else {
                nextNode = nextNode.getNext();
            }
        }
        return str;
    }

    private static class Node {
        private Integer element;
        private Node next;
        private Node prev;

        public Node(Integer element) {
            this.element = element;
        }

        public Integer getElement() {
            return element;
        }

        public void setElement(Integer element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        MyLinkedList mylinckedlist = new MyLinkedList();
        mylinckedlist.add(0);
        mylinckedlist.add(1);
        mylinckedlist.add(2);
        mylinckedlist.add(3);
        mylinckedlist.add(1, 4);

        try {
            mylinckedlist.add(100, 100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("add exception");
        }

        try {
            mylinckedlist.remove(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("remove exception");
        }

        try {
            mylinckedlist.set(100, 100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("set exception");
        }

        try {
            mylinckedlist.get(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("get exception");
        }

        System.out.println(mylinckedlist.get(4));

        System.out.println(mylinckedlist);

        mylinckedlist.set(3, 10);

        System.out.println(mylinckedlist);

        mylinckedlist.remove(4);

        System.out.println(mylinckedlist);

    }
}
