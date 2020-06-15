package tree;

import org.junit.Test;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    @Test
    public void test() {

        Integer[] arr = new Integer[]{1, 2};
        BinaryTree tree1 = new BinaryTree();
        TreeNode root = tree1.setTree(arr);
//        System.out.println(helper(root, 1));

    }
}