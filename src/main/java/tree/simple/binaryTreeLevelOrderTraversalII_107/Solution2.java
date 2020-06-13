package tree.simple.binaryTreeLevelOrderTraversalII_107;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        if (root == null) {
            return ans;
        }
        list.push(root);
        while (!list.isEmpty()) {
//            总是压到底
            ans.push(new LinkedList<Integer>());
            int len = list.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = list.poll();
//            总是取第一
                ans.getFirst().add(tmp.val);
                if (tmp.left != null) {
                    list.add(tmp.left);
                }
                if (tmp.right != null) {
                    list.add(tmp.right);
                }
            }

        }
        return ans;
    }

    @Test
    public void test() {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        int len = arr.length;
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.setTree(arr);
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();

        System.out.println(levelOrderBottom(root));
    }
}
