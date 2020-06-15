package tree.simple.binaryTreeTilt_563;

import tree.TreeNode;

//Given a binary tree, return the tilt of the whole tree.
//
//The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
//
//The tilt of the whole tree is defined as the sum of all nodes' tilt.
//
//Example:
//Input:
//         1
//       /   \
//      2     3
//Output: 1
//Explanation:
//Tilt of node 2 : 0
//Tilt of node 3 : 0
//Tilt of node 1 : |2-3| = 1
//Tilt of binary tree : 0 + 0 + 1 = 1
//Note:
//
//The sum of node values in any subtree won't exceed the range of 32-bit integer.
//All the tilt values won't exceed the range of 32-bit integer.
public class Solution {
//    post Order , bottom to up
//    from the problem statement, it is clear that we need to find the tilt value at every node of the given tree and add up all the tilt values to obtain the final result.
//    To find the tilt value at any node, we need to subtract the sum of all the nodes in its left subtree and the sum of all the nodes in its right subtree.
//
//Thus, to find the solution, we make use of a recursive function traverse which when called from any node,
// returns the sum of the nodes below the current node including itself.
// With the help of such sum values for the right and left subchild of any node,
// we can directly obtain the tilt value corresponding to that node.
    int tilt=0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return tilt;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
}
