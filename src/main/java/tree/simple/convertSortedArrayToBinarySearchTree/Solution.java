package tree.simple.convertSortedArrayToBinarySearchTree;
//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//Example:
//
//Given the sorted array: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//

import org.junit.Test;
import tree.TreeNode;
//根据中序遍历还原一颗树，又想到了 105 题 和 106 题，通过中序遍历加前序遍历或者中序遍历加后序遍历来还原一棵树。前序（后序）遍历的作用呢？提供根节点！然后根据根节点，就可以递归的生成左右子树。
//
//这里的话怎么知道根节点呢？平衡二叉树，既然要做到平衡，我们只要把根节点选为数组的中点即可。
//
//综上，和之前一样，找到了根节点，然后把数组一分为二，进入递归即可。注意这里的边界情况，包括左边界，不包括右边界。
//

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int m = (i + j) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, i, m - 1);
        root.right = helper(nums, m + 1, j);
        return root;
    }
    public void order(TreeNode rot ){
        if(rot==null){
            return;
        }
        order(rot.left);
        System.out.println(rot.val);
        order(rot.right);
    }

    @Test
    public void test() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root=helper(nums,0,nums.length-1);
       order(root);
    }
}
