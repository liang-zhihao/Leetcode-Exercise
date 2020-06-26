package tree.medium.constructBinarySearchTreeFromPreorderTraversal_1008;

import org.junit.Test;
import tree.TreeNode;

import java.util.LinkedList;

//Return the root node of a binary search tree that matches the given preorder traversal.
//
//(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val,
// and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first,
// then traverses node.left, then traverses node.right.)
//
//It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
//
//Example 1:
//
//Input: [8,5,1,7,10,12]
//Output: [8,5,10,1,7,null,12]
//
//
//
//Constraints:
//
//1 <= preorder.length <= 100
//1 <= preorder[i] <= 10^8
//The values of preorder are distinct.
public class Solution {
    //    ok lets do this!!
//so we are given an array which is the preorder traversal of the some tree!
//we are used to traverse a tree a but are not privy to reconstruct the tree from the array!!
//anyways!!!
//so we are given an array whose first element is the root of out tree!!(because of preorder traversal)!
//NOTE:this is not a linear solution!i have posted linear solutions here https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/589801/JAVA-3-WAYS-TO-DO-THE-PROBLEM!-O(N)-APPROACH
//BUT i strongly suggest you go through this soution below so that you can get the gist of the logic and then move on to the more complex linear solutions i posted!
//
//LETS DO THIS:
//
//so we follow steps:
//1>we create the node
//2>we traverse the array for values which are less than the current node!-- these values will become our left subtree.
// we stop whenever we get a value larger than the current root of the subtree!
//3>we take the rest of the array(values whuch are greater than the value of the current root)-these are the values which will make out right subtree!
//
//so we make a root!
//make the left subtree(recursively)
//then make right subtree(recursively)
// TODO:   know the left tree and the right tree by array
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int i;
        TreeNode root = new TreeNode(preorder[st]);
        for (i = st; i <= ed; i++) {
            if (root.val < preorder[i]) {
                break;
            }
        }
        root.left = helper(preorder, st + 1, i - 1);
        root.right = helper(preorder, i, ed);
        return root;
    }
    @Test
    public void test(){
        LinkedList<Integer> list=new LinkedList<Integer>();
        list.add(9,1);
    }
}
