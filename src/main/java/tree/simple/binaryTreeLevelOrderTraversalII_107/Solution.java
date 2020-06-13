package tree.simple.binaryTreeLevelOrderTraversalII_107;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans=new LinkedList<List<Integer>>();
        helper(root,0,ans);
        return ans;
    }

    //    用 level 记录层数，问题解决！
    public void helper(TreeNode node, int level, LinkedList<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        if(ans.size()<=level){
            ans.push(new LinkedList<Integer>());

        }
        ans.get(ans.size()-1-level).add(node.val);
        helper(node.left, level +1, ans);
        helper(node.right, level +1, ans);
    }

    @Test
    public void test() {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        int len=arr.length;
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.setTree(arr);
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        helper(root, 0, ans);
        System.out.println(ans.toString());
    }
}

