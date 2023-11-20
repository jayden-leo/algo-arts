package c07_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class C002_LterativeTraversal {

    public List<Integer> lterativeTraversal(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
//        preOrder(root, result);
//        inOrder(root,result);
        postOrder(root, result);
        Collections.reverse(result);
        return result;
    }

    private void postOrder(BinaryTree root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTree node = stack.pop();
            result.add(node.val);
            if (node.leftChild !=null){
                stack.push(node.leftChild);
            }
            if (node.rightChild!=null){
                stack.push(node.rightChild);
            }
        }
    }

    private void inOrder(BinaryTree root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.leftChild;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.rightChild;
            }
        }
    }

    private void preOrder(BinaryTree root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        stack.add(root);
        BinaryTree node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val);
            if (node.rightChild != null) {
                stack.add(node.rightChild);
            }
            if (node.leftChild != null) {
                stack.add(node.leftChild);
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree head = new BinaryTree(1);
        head.leftChild = new BinaryTree(2, new BinaryTree(4), null);
        head.rightChild = new BinaryTree(3, new BinaryTree(5), null);

        C002_LterativeTraversal c002_lterativeTraversal = new C002_LterativeTraversal();
        List<Integer> result = c002_lterativeTraversal.lterativeTraversal(head);
        for (Integer nodeVal : result) {
            System.out.print(nodeVal + " ");
        }
    }
}
