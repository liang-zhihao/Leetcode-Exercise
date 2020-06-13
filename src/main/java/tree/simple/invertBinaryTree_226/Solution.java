package tree.simple.invertBinaryTree_226;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

//Invert a binary tree.
//
//Example:
//
//Input:
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//Output:
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//Trivia:
//This problem was inspired by this original tweet by Max Howell:
//
//Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
//
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
//        子树不为空就转
        if (root.left != null || root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        helper(root.left);
        helper(root.right);
    }

    @Test
    public void test() {
        Integer[] arr = new Integer[]{1,2};
        BinaryTree tree1 = new BinaryTree();
        TreeNode root = tree1.setTree(arr);
        helper(root);
        System.out.println(root.right.val);


    }
}
