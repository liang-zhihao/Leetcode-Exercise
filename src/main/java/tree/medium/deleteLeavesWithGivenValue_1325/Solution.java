package tree.medium.deleteLeavesWithGivenValue_1325;

import tree.TreeNode;

//Given a binary tree root and an integer target, delete all the leaf nodes with value target.
//
//Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).
//
//
//
//Example 1:
//
//
//
//Input: root = [1,2,3,2,null,2,4], target = 2
//Output: [1,null,3,null,4]
//Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
//After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
//Example 2:
//
//
//
//Input: root = [1,3,3,3,2], target = 3
//Output: [1,3,null,null,2]
public class Solution {
//    classic bottom to up
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null){
            return root;
        }
        root.left=removeLeafNodes(root.left, target);
        root.right=removeLeafNodes(root.right, target);
        if(isLeaf(root.left)&&root.left.val==target){
            root.left=null;
        }
        if(isLeaf(root.right)&&root.right.val==target){
            root.right=null;
        }
        if(isLeaf(root)&&root.val==target){
            root=null;
        }
        return root;
    }
    public boolean isLeaf(TreeNode node){
        return node!=null&&node.left==null&&node.right==null;    }
}
