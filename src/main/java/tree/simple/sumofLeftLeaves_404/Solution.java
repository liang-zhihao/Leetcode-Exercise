package tree.simple.sumofLeftLeaves_404;

import tree.TreeNode;
import tree.BinaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

//Find the sum of all left leaves in a given binary tree.
//思路：首先需要遍历整个二叉树，在遍历的过程中确定左叶子，并求和。
//遍历方法有深度优先遍历(前序，中序，后序），不太推荐广度优先遍历(层序遍历)。
//选择自己熟悉的遍历方式，先写出遍历过程（递归和迭代均可，优先考虑迭代）
//然后考虑满足左叶子的条件：1.首先该节点不能有左右孩子节点。2.该节点是父节点的左孩子。两个条件即可满足所有判断条件。
//
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root,0);
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum = helper(root.left, sum);
        sum = helper(root.right, sum);
        return sum;

    }

    @Test
    public void test() {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.setTree(arr);
        System.out.println(helper(root,0));

    }
}
