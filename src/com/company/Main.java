package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Node<Integer> node = fromArray(new Integer[]{1, 2, 3, 4, 5, 8, 10, 8, 1, 3, 2, 11, null, 12});
        Node<Integer> subNode = fromArray(new Integer[]{5, 3, 2});
        boolean isSub = check(node, subNode);
        System.out.println(isSub);
    }

    public static <T>boolean check(Node<T> root, Node<T> subRoot) {
        boolean res = isSubTree(root, subRoot);
        if(res) {
            return res;
        } else {
            if (root.left != null) {
                res = check(root.left, subRoot);
                if(res) {
                    return res;
                }
            }
            if(root.right != null) {
                res = check(root.right, subRoot);
                if(res) {
                    return res;
                }
            }
        }
        return res;
    }

    public static <T>boolean isSubTree(Node<T> root, Node<T> subRoot) {
        if(subRoot == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        if(root.val == subRoot.val) {
            return isSubTree(root.left, subRoot.left) && isSubTree(root.right, subRoot.right);
        }
        return false;
    }

    public static <T>void printTree(Node<T> root) {
        if(root.left == null || root.right == null) {
            return;
        }

    }

    public static  <T>Node<T> fromArray(T[] tree) {
        if (tree.length == 0) {
            return null;
        }
        Node<T> root = new Node<>(tree[0]);
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < tree.length; i++) {
            Node<T> node = q.peek();
            if (node.left == null) {
                node.left = new Node<>(tree[i]);
                if (tree[i] != null) {
                    q.add(node.left);
                }
            } else if (node.right == null) {
                node.right = new Node<>(tree[i]);
                if (tree[i] != null) {
                    q.add(node.right);
                }
                q.remove();
            }
        }
        return root;
    }
}
