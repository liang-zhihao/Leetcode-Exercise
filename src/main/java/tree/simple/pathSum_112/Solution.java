package tree.simple.pathSum_112;
//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Given the below binary tree and sum = 22,
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
//

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return helper(root, sum);
    }

    public boolean helper(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        sum -= node.val;
//        isLeaf or not !!!
        if(node.left==null&&node.right==null&&sum==0){
            return true;
        }
        return helper(node.left, sum) || helper(node.right, sum);

    }

    @Test
    public void test() {

        Integer[] arr = new Integer[]{1,2};
        BinaryTree tree1 = new BinaryTree();
        TreeNode root = tree1.setTree(arr);
        System.out.println(helper(root, 1));

    }
}
