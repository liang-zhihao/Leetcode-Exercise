package tree.simple.sameTree_100;
//Given two binary trees, write a function to check if they are the same or not.
//
//Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
//

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && helper(p.left, q.left) && helper(p.right, q.right);
    }
    @Test
    public void test(){
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        BinaryTree tree1 = new BinaryTree();
        TreeNode root1 = tree1.setTree(arr);
        BinaryTree tree2 = new BinaryTree();
        TreeNode root2 = tree2.setTree(arr);
        System.out.println(helper(root1,root2));
    }
}
