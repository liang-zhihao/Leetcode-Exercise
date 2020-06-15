package tree.simple.twoSumIV_653;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

import java.util.HashSet;

//Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
//
//Example 1:
//
//Input:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//Output: True
//
//
//Example 2:
//
//Input:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//Output: False
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set=new  HashSet<Integer>();
        return dfs(root,k,set);

    }
    public boolean dfs(TreeNode root, int k, HashSet<Integer> set){
        if(root==null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return dfs(root.left,k,set)||dfs(root.right,k,set);
    }
//    @Test
//    public void test() {
//
//        Integer[] arr = new Integer[]{5,2,13};
//        BinaryTree tree1 = new BinaryTree();
//        TreeNode root = tree1.setTree(arr);
//        System.out.println(helper(root, 1));
//
//    }
}
