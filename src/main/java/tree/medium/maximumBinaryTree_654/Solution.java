package tree.medium.maximumBinaryTree_654;

import tree.TreeNode;

//Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//
//The root is the maximum number in the array.
//The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//Construct the maximum tree by the given array and output the root node of this tree.
//
//Example 1:
//Input: [3,2,1,6,0,5]
//Output: return the tree root node representing the following tree:
//
//      6
//    /   \
//   3     5
//    \    /
//     2  0
//       \
//        1
//Note:
//The size of the given array will be in the range [1,1000].
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int st,int ed){
        if(st>ed){
            return null;
        }
        int index=findMaxIndex(nums,st,ed);
        TreeNode root=new TreeNode(nums[index]);
        root.left=helper(nums,st,index-1);
        root.right=helper(nums,index+1,ed);
        return root;
    }
    public int findMaxIndex(int[] nums,int st,int ed){
        int max=-1,index=-1;
        for(int i=st;i<=ed;i++){
            if(max<nums[i]){
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
}
