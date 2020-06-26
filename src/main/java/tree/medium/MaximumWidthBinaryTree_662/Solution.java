package tree.medium.MaximumWidthBinaryTree_662;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

import java.util.LinkedList;

//Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
//
//The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
//
//Example 1:
//
//Input:
//
//           1
//         /   \
//        3     2
//       / \     \
//      5   3     9
//
//Output: 4
//Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
//Example 2:
//
//Input:
//
//          1
//         /
//        3
//       / \
//      5   3
//
//Output: 2
//Explanation: The maximum width existing in the third level with the length 2 (5,3).
//Example 3:
//
//Input:
//
//          1
//         / \
//        3   2
//       /
//      5
//
//Output: 2
//Explanation: The maximum width existing in the second level with the length 2 (3,2).
//Example 4:
//
//Input:
//
//          1
//         / \
//        3   2
//       /     \
//      5       9
//     /         \
//    6           7
//Output: 8
//Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
public class Solution {
    LinkedList<TreeNode> list=new LinkedList<TreeNode>();
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        root.val=0;
        list.add(root);
        int max=0;
        while(!list.isEmpty()){
            int len=list.size(),first=-1,end=-1;
            for(int i=0;i<len;i++){
                TreeNode tmp=list.poll();
                if(i==0){
                    first=tmp.val;
                }
                if(i==len-1){
                    end=tmp.val;
                }
                if(tmp.left!=null){
                    tmp.left.val=2*tmp.val+1;
                    list.add(tmp.left);
                }
                if(tmp.right!=null){
                    tmp.right.val=2*tmp.val+2;
                    list.add(tmp.right);

                }
            }
            max=Math.max(end-first+1,max);

        }
        return max;
    }
    @Test
    public void test() {

        Integer[] arr = new Integer[]{1,3,2,5,3,null,9};
        BinaryTree tree1 = new BinaryTree();
        TreeNode root = tree1.setTree(arr);
        System.out.println(widthOfBinaryTree(root));

    }
}
