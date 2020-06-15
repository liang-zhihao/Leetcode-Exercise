package tree.simple.convertBSTToGreaterTree_538;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

import java.util.LinkedList;

//Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
//
//Example:
//
//Input: The root of a Binary Search Tree like this:
//              5
//            /   \
//           2     13
//
//Output: The root of a Greater Tree like this:
//             18
//            /   \
//          20     13
//Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class Solution {
    //The basic idea is to do a reversed inorder traversal. When we visit a node we add the sum of all previous nodes (to the right) to its value and also update the sum.
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;

    }

    @Test
    public void test() {

        Integer[] arr = new Integer[]{2, 0, 3, -4, 1};
        BinaryTree tree1 = new BinaryTree();
        TreeNode root = tree1.setTree(arr);
        System.out.println(convertBST(root).right.val);

    }
}
