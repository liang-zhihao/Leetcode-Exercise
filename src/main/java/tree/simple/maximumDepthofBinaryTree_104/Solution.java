package tree.simple.maximumDepthofBinaryTree_104;

import tree.BinaryTree;
import tree.TreeNode;
import org.junit.Test;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    @Test
    public void test(){
        BinaryTree tree=new BinaryTree(new Integer[]{3,9,20,null,null,15,7});
        TreeNode r=tree.root;
        System.out.println(maxDepth(r));
    }
}
