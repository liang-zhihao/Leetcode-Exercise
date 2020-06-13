package tree.simple.averageOfLevelsInBinaryTree_637;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

//Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//Example 1:
//Input:
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Output: [3, 14.5, 11]
//Explanation:
//The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
//Note:
//The range of node's value is in the range of 32-bit signed integer.
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> nodeList=new   LinkedList<TreeNode>();
        LinkedList<Double> ansList=new LinkedList<Double>();
        if(root==null){
            return ansList;
        }
        nodeList.add(root);
//        BFS to solve
        while(!nodeList.isEmpty()){
            int len=nodeList.size();
            Double sum=0.0;
            for(int i=0;i<len;i++){
                TreeNode tmp=nodeList.poll();
                sum+=tmp.val;
                if(tmp.left!=null){
                    nodeList.add(tmp.left);
                }
                if(tmp.right!=null){
                    nodeList.add(tmp.right);
                }
            }
            ansList.add(sum/len);
        }
        return ansList;
    }
}
