package tree.simple.pathSum_112;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//我们可以利用一个队列对二叉树进行层次遍历。同时还需要一个队列，保存当前从根节点到当前节点已经累加的和。BFS的基本框架不用改变，参考 102 题。只需要多一个队列，进行细微的改变即可
//

public class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        if (root == null) {
            return false;
        }
        queue.offer(root);
        queueSum.offer(root.val);
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // 当前层元素的个数
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                int curSum = queueSum.poll();
                if (curNode != null) {
                    //判断叶子节点是否满足了条件
                    if (curNode.left == null && curNode.right == null && curSum == sum) {
                        return true;
                    }
                    //当前节点和累计的和加入队列
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                        queueSum.offer(curSum + curNode.left.val);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                        queueSum.offer(curSum + curNode.right.val);
                    }
                }
            }
        }
        return false;
    }


    @Test
    public void test() {

        Integer[] arr = new Integer[]{1, 2};
        BinaryTree tree1 = new BinaryTree();
        TreeNode root = tree1.setTree(arr);
//        System.out.println(helper(root, 1));

    }
}
