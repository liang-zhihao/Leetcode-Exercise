package tree.simple.subtreeOfAnotherTree_572;

import tree.TreeNode;

import java.util.LinkedList;

//Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
//
//Example 1:
//Given tree s:
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//Given tree t:
//   4
//  / \
// 1   2
//Return true, because t has the same structure and node values with a subtree of s.
//
//
//Example 2:
//Given tree s:
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
//Given tree t:
//   4
//  / \
// 1   2
//Return false.
public class Solution {
//For each node during pre-order traversal of s,
// use a recursive function isSame to validate if sub-tree started with this node is the same with t.
public boolean isSubtree(TreeNode s, TreeNode t) {
    if(s==null){
        return false;
    }
    LinkedList<TreeNode> list=new   LinkedList <TreeNode>();
    list.add(s);
    while(!list.isEmpty()){
        int len=list.size();
        for(int i=0;i<len;i++){
            TreeNode tmp=list.poll();
            if(tmp.val==t.val&&isSame(tmp,t)){
                return true;
            }
            if(tmp.left!=null){
                list.add(tmp.left);
            }
            if(tmp.right!=null){
                list.add(tmp.right);
            }
        }

    }
    return false;

}
    public boolean isSame(TreeNode s,TreeNode t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        return s.val==t.val&&isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
}
