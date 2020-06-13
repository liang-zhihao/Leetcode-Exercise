package tree.simple.leafSimilarTrees_872;

import tree.TreeNode;

import java.util.LinkedList;

//Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
//
//
//
//For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
//Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
//Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
//
public class Solution {
    private LinkedList<Integer> list1 = new LinkedList<Integer>();
    private LinkedList<Integer> list2 = new LinkedList<Integer>();
//1. traverse 2. compare
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        helper(root1, list1);
        helper(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        int len = list1.size();
        for (int i = 0; i < len; i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void helper(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == root.right) {
            list.add(root.val);
            return;
        }
        helper(root.left, list);
        helper(root.right, list);
    }
}
