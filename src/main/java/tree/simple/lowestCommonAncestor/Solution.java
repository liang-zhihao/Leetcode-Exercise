package tree.simple.lowestCommonAncestor;

import tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
// (where we allow a node to be a descendant of itself).”
//
//Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//二叉搜索树（BST）的性质：
//
//节点 NN 左子树上的所有节点的值都小于等于节点 NN 的值
//节点 NN 右子树上的所有节点的值都大于等于节点 NN 的值
//左子树和右子树也都是 BST
//

//从根节点开始遍历树
//如果节点 pp 和节点 qq 都在右子树上，那么以右孩子为根节点继续 1 的操作
//如果节点 pp 和节点 qq 都在左子树上，那么以左孩子为根节点继续 1 的操作
//如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 pp 和节点 qq 的 LCA 了

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }


    @Test
    public void test() {

//        BinaryTree tree = new BinaryTree(arr);
//        TreeNode root = tree.root;
//        System.out.println(lowestCommonAncestorNum(root, 1209, 8931));
    }
}
