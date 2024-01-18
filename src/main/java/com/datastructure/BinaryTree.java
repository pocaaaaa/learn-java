package com.datastructure;

/**
 * 출처 : [YouTube] 엔지니어 대한민국 - [자료구조 알고리즘] Binary Tree의 3가지 순회방법 구현하기
 *          (1)
 *        /    \
 *      (2)    (3)
 *     /  \
 *   (4)  (5)
 * Inorder (Left, Root, Right): 4 2 5 1 3
 * Preorder (Root, Left, Right): 1 2 4 5 3
 * Postorder (Left, Right, Root): 4 5 2 3 1
 */
class BinaryNode {
    int data;
    BinaryNode left;
    BinaryNode right;
}

class Tree {
    public BinaryNode root;

    public void setRoot(BinaryNode binaryNode) {
        this.root = binaryNode;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public BinaryNode makeNode(BinaryNode left, int data, BinaryNode right) {
        BinaryNode binaryNode = new BinaryNode();
        binaryNode.data = data;
        binaryNode.left = left;
        binaryNode.right = right;
        return binaryNode;
    }

    public void inorder(BinaryNode binaryNode) {
        if(binaryNode != null) {
            inorder(binaryNode.left);
            System.out.println(binaryNode.data);
            inorder(binaryNode.right);
        }
    }

    public void preorder(BinaryNode binaryNode) {
        if(binaryNode != null) {
            System.out.println(binaryNode.data);
            preorder(binaryNode.left);
            preorder(binaryNode.right);
        }
    }

    public void postorder(BinaryNode binaryNode) {
        if(binaryNode != null) {
            postorder(binaryNode.left);
            postorder(binaryNode.right);
            System.out.println(binaryNode.data);
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Tree t = new Tree();
        BinaryNode n4 = t.makeNode(null, 4, null);
        BinaryNode n5 = t.makeNode(null, 5, null);
        BinaryNode n2 = t.makeNode(n4, 2, n5);
        BinaryNode n3 = t.makeNode(null, 3, null);
        BinaryNode n1 = t.makeNode(n2, 1, n3);
        t.setRoot(n1);
        //t.inorder(t.getRoot());
        //t.preorder(t.getRoot());
        t.postorder(t.getRoot());
    }
}
