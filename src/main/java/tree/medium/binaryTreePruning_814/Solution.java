package tree.medium.binaryTreePruning_814;

import tree.TreeNode;

//814. Binary Tree Pruning
//Medium
//
//963
//
//38
//
//Add to List
//
//Share
//We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
//
//Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
//
//(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
//
//Example 1:
//Input: [1,null,0,0,1]
//Output: [1,null,0,null,1]
//
//Explanation:
//Only the red nodes satisfy the property "every subtree not containing a 1".
//The diagram on the right represents the answer.
public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return isLeaf(root) && root.val == 0 ? null : root;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == node.right;
    }
}
