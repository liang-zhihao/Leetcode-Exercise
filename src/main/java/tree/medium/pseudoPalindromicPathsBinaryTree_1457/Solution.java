package tree.medium.pseudoPalindromicPathsBinaryTree_1457;

import org.junit.Test;
import tree.BinaryTree;
import tree.TreeNode;

import java.util.LinkedList;

//Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
//
//Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
//
//
//
//Example 1:
//
//
//
//Input: root = [2,3,1,3,1,null,1]
//Output: 2
//Explanation: The figure above represents the given binary tree.
// There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1].
// Among these paths only red path and green path are pseudo-palindromic paths
// since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1]
// can be rearranged in [1,2,1] (palindrome).
public class Solution {
    int ans = 0;
    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int path[] = new int[100000];
        getPaths(root, path, 0);
        return ans;
    }

    public void getPaths(TreeNode root, int[] path, int len) {
        if (root == null) {
            return;
        }
        path[len++] = root.val;

        if (root.left == null && root.right == null) {
            if (isPal(path, len)) {
                ans++;
            }
            return;
        }
        getPaths(root.left, path, len);
        getPaths(root.right, path, len);

    }

    public boolean isPal(int[] path, int len) {
        int[] a = new int[10];
        int miss = 0;
        for (int i = 0; i < len; i++) {
            a[path[i]]++;
        }
        for (int i = 0; i < 10; i++) {
            if (a[i] % 2 != 0) {
                miss++;
            }
            if (miss > 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Integer[] arr = new Integer[]{2, 3, 1, 3, 1, null, 1};
        BinaryTree tree1 = new BinaryTree();
        TreeNode root = tree1.setTree(arr);
        pseudoPalindromicPaths(root);
        System.out.println(ans);

    }
}
