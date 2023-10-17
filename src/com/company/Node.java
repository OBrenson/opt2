package com.company;

public class Node<T> {

    public Node() {
    }

    public Node(T val) {
        this.val = val;
    }

    public Node(Node<T> left, Node<T> right, T val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public Node<T> left;
    public Node<T> right;

    public T val;
}
