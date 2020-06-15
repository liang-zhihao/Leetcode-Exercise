package tree.medium.deepestLeavesSum_1302;

import tree.TreeNode;

import java.util.LinkedList;

//Given a binary tree, return the sum of values of its deepest leaves.
public class Solution {
//    Time: O(N), N is the number of nodes in the tree
//Space: O(N/2), size of the largest level
    public int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        LinkedList<TreeNode> list=new LinkedList<TreeNode>();
        int sum=0;
        list.add(root);
        while(!list.isEmpty()){
            sum=0;
            int len=list.size();
            for(int i=0;i<len;i++){
                TreeNode tmp= list.poll();
                sum+=tmp.val;
                if(tmp.left!=null){
                    list.add(tmp.left);
                }
                if(tmp.right!=null){
                    list.add(tmp.right);
                }
            }
        }
        return sum;
    }
}
