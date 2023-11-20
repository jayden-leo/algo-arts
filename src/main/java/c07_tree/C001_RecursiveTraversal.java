package c07_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归遍历
 * link: 前序 https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * link: 中序 https://leetcode.cn/problems/binary-tree-inorder-traversal/submissions/483379797/
 * link: 后序 https://leetcode.cn/problems/binary-tree-postorder-traversal/submissions/483380025/
 */
public class C001_RecursiveTraversal {

    public void preOrder(BinaryTree node,List<Integer> result){
        if (node==null){
            return;
        }
        result.add(node.val); //前序
        preOrder(node.leftChild,result);
        preOrder(node.rightChild,result);
    }

    public void inOrder(BinaryTree node,List<Integer> result){
        if (node==null){
            return;
        }
        inOrder(node.leftChild,result);
        result.add(node.val); //中序
        inOrder(node.rightChild,result);
    }

    public void postOrder(BinaryTree node,List<Integer> result){
        if (node==null){
            return;
        }
        postOrder(node.leftChild,result);
        postOrder(node.rightChild,result);
        result.add(node.val); //后序
    }

    public List<Integer> traversal(BinaryTree node){
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(node,result);
//        inOrder(node,result);
//        postOrder(node,result);
        return result;
    }

    public static void main(String[] args) {
        BinaryTree head = new BinaryTree(1);
        head.leftChild = new BinaryTree(2, new BinaryTree(4),null);
        head.rightChild = new BinaryTree(3,new BinaryTree(5),null);

        C001_RecursiveTraversal c001_recursiveTraversal = new C001_RecursiveTraversal();
        List<Integer> result = c001_recursiveTraversal.traversal(head);
        for (Integer nodeVal : result) {
            System.out.print(nodeVal+" ");
        }
    }
}
