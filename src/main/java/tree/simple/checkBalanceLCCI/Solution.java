package tree.simple.checkBalanceLCCI;

import org.junit.Test;

import java.util.*;

/**
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//对于这个顶点，左子树的高度和右子树的高度之差的绝对值小于等于1。
//其次：左子树为平衡二叉树，右子树也为平衡二叉树。
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    @Test
    public void test() {
//        TreeNode root = new TreeNode(3);
//        root.addLeft(9);
//        TreeNode node = root.addLeft(20);
//        node.addLeft(15);
//        node.addRight(7);
//        System.out.println(treeLength(root));
        List<Integer> list = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        Integer[] arr = new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        BinaryTree tree=new BinaryTree();
        TreeNode root= tree.setTree(arr);
        System.out.println(root.left.val);


    }
}

class BinaryTree {
    private Integer[] arr;
    private TreeNode root;

    public TreeNode setTree(Integer[] arr) {
        this.arr=arr;
        root=createNode(root,0);
        return root;
    }

    public TreeNode createNode(TreeNode rot, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        rot = new TreeNode(arr[index]);
        rot.left = createNode(rot.left, index * 2 + 1);
        rot.right = createNode(rot.right, index * 2 + 2);
        return rot;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}