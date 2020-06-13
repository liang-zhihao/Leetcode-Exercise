package tree.simple.binaryTreePaths_257;

import tree.TreeNode;
import tree.BinaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        helper(root, new StringBuilder(), list);
        return list;
    }

    public void helper(TreeNode root, StringBuilder str, List<String> list) {
        if (root == null) {
            return;
        }

        if (root.right == null && root.left == null) {
            str.append(root.val);
            list.add(str.toString());
            return;
        } else {
            str.append(root.val + "->");
        }
        helper(root.left, new StringBuilder().append(str), list);
        helper(root.right, new StringBuilder().append(str), list);
    }

    @Test
    public void test() {
        Integer[] arr = new Integer[]{1, 2, 3, null, 5};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.setTree(arr);
        List<String> list = new ArrayList<String>();
        helper(root, new StringBuilder(), list);

    }
}
