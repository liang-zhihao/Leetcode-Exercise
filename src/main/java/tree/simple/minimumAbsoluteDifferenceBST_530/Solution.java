package tree.simple.minimumAbsoluteDifferenceBST_530;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

import java.util.Stack;

//Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
//
//Example:
//
//Input:
//
//   1
//    \
//     3
//    /
//   2
//
//Output:
//1
//
//Explanation:
//The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
//
//
//Note:
//
//There are at least two nodes in this BST.
//This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
public class Solution {
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;
//The most common idea is to first inOrder traverse the tree and compare the delta between each of the adjacent values.
// It's guaranteed to have the correct answer because it is a BST thus inOrder traversal values are sorted.
    public int getMinimumDifference(TreeNode root) {
//        System.out.println(root.val);
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        dfs(root.right);

    }

    @Test
    public void test() {
        Integer[] arr = new Integer[]{1, null, 2, 3};
        BinaryTree tree1 = new BinaryTree();
        TreeNode root = tree1.setTree(arr);
        System.out.println(getMinimumDifference(root));

    }
}
