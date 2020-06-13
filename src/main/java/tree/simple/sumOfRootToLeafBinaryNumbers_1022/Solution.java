package tree.simple.sumOfRootToLeafBinaryNumbers_1022;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

import java.util.LinkedList;

public class Solution {
    LinkedList<String> list=new LinkedList<String>();
    public int sumRootToLeaf(TreeNode root) {
        helper(root,new StringBuilder());
        int sum=0;
        for(String str:list){
//            System.out.println(str);
            sum+=Integer.parseInt(str,2);
        }
        return sum;
    }
    public void helper(TreeNode root, StringBuilder str){
        if(root==null){
            return ;
        }
        str.append(root.val);
        if(root.left==null&&root.right==null){
            list.add(str.toString());
            return;
        }
        helper(root.left,new StringBuilder().append(str));
        helper(root.right,new StringBuilder().append(str));
    }
    @Test
    public void test(){
        Integer[] arr = new Integer[]{1,0,1,0,1,0,1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.setTree(arr);
        System.out.println(sumRootToLeaf(root));
    }
}
