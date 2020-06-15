package tree.simple.convertBSTToGreaterTree_538;

import sun.reflect.generics.tree.Tree;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class Solution2 {

    public TreeNode convertBST(TreeNode root) {

        if (root == null) {
            return null;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
