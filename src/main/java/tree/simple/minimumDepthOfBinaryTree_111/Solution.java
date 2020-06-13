package tree.simple.minimumDepthOfBinaryTree_111;

import tree.BinaryTree;
import tree.TreeNode;
import org.junit.Test;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int mina = minDepth(root.left);
        int minb = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return mina + minb + 1;
        }
        return Math.min(mina,minb) + 1;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.min(helper(root.left), helper(root.right)) + 1;
    }

    @Test
    public void test() {
        BinaryTree tree = new BinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
//        BinaryTree tree=new BinaryTree(new Integer[]{1,2});
        TreeNode r = tree.root;
        System.out.println(helper(r));
    }
}
