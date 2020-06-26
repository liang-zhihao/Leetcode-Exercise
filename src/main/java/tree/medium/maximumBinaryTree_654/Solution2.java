package tree.medium.maximumBinaryTree_654;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
//    Each node went into stack once, and went out stack once. Worst case time complexity O(N).
//TODO: confused
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }

}
