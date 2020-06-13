package tree.simple.searchInBinarySearchTree_700;

import tree.BinaryTree;
import tree.TreeNode;
import org.junit.Test;
//Given the root node of a binary search tree (BST) and a value.
// You need to find the node in the BST that the node's value equals the given value.
// Return the subtree rooted with that node.
// If such node doesn't exist, you should return NULL.


public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return  null;
        }
        if(root.val<val){
           return   searchBST(root.right,val);
        }else if(root.val>val){
            return searchBST(root.left,val);
        }else {
            return root;
        }

    }
    @Test
    public void test(){
        Integer[] arr = new Integer[]{4, 2, 7, 1, 3, };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.setTree(arr);
        System.out.println(searchBST(root,2).val);
    }
}
