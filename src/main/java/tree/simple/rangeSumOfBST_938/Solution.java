package tree.simple.rangeSumOfBST_938;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }

        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

    }



    @Test
    public void test() {
        Integer[] arr = new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.setTree(arr);
//        System.out.println(helper(root, 6, 10));

    }
}
