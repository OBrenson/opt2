package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Node<Integer> node = fromArray(new Integer[]{1, 2, 3, 4, 5, 8, 10, 8, 1, 3, 2, 11, 1, null, 12});
        System.out.println(getHeight(node, 1));
        printTree(node);
        Node<Integer> subNode = fromArray(new Integer[]{2,4,5,null,3,null});
        System.out.println(getHeight(subNode, 1));
        printTree(subNode);
        boolean isSub = isSub(node, subNode);
        System.out.println("Result: " + isSub);

        Node<Integer> subNodeN = fromArray(new Integer[]{2,4,5, 8, 1,null,2});
        printTree(subNodeN);
        isSub = isSub(subNodeN, node);
        System.out.println("Result: " + isSub);
    }

    public static <T>boolean isSub(Node<T> fNode, Node<T> sNode) {
        int fHeight = getHeight(fNode, 1);
        int sHeight = getHeight(sNode, 1);
        boolean res;
        if(fHeight > sHeight) {
            res = check(fNode, sNode, 0, fHeight - sHeight);
        } else {
            res = check(sNode, fNode, 0, sHeight - fHeight);
        }
        return res;
    }

    public static <T>int getHeight(Node<T> node, int height) {
        if(node.val == null) {
            return height;
        }
        if(node.left != null) {
            return getHeight(node.left, ++height);
        }
        if(node.right != null) {
            return getHeight(node.right, ++height);
        }
        return height;
    }

    public static <T>boolean check(Node<T> root, Node<T> subRoot, int height, int border) {
        if(height > border) {
            return false;
        }
        boolean res = isSubTree(root, subRoot);
        if(res) {
            return res;
        } else {
            if (root.left != null) {
                res = check(root.left, subRoot, ++height, border);
                if(res) {
                    return res;
                }
            }
            if(root.right != null) {
                res = check(root.right, subRoot, ++height, border);
                if(res) {
                    return res;
                }
            }
        }
        return res;
    }

    public static <T>boolean isSubTree(Node<T> root, Node<T> subRoot) {
        if(subRoot == null || subRoot.val == null) {
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

    public static <T>void printTree(Node<T> node) {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        printTree(node, sb, "   ");
        System.out.println(sb);
        System.out.println();
    }

    public static <T>void printTree(Node<T> root, StringBuilder stringBuilder, String space) {
        stringBuilder.append(root.val);
        if(root.left != null) {
            stringBuilder.append("\n").append(space).append("├──");
            printTree(root.left, stringBuilder, space + "│" + "  ");
        }
        if(root.right != null) {
            stringBuilder.append("\n").append(space).append("│  ");
            stringBuilder.append("\n").append(space).append("├──");
            printTree(root.right, stringBuilder, space + "│  ");
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
