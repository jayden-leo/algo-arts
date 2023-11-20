package c07_tree;

public class BinaryTree {
    int val;
    BinaryTree leftChild;
    BinaryTree rightChild;

    public BinaryTree(int val) {
        this.val = val;
    }

    public BinaryTree(int val, BinaryTree leftChild, BinaryTree rightChild) {
        this.val = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }
}
