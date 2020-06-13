package tree.simple.checkBalanceLCCI;

//自底向上递归地返回结点的高度。
//递归的每一层要做的工作：根据向上返回得到的左右子结点的高度，判断是否平衡，若平衡，返回当前结点的高度（左右子节点高度的最大值加一）。若不平衡，则之后的高度都不必再计算了，这棵树必然不平衡，这种情况下向上返回-1。
//递归结束后，若树是平衡的，将得到根结点的高度（不断通过返回的子结点的高度计算得到）；若树是不平衡的，将得到-1。根据这个结果返回true/false即可。
//
//相对于解法一，这样做可以不断通过返回的子树高度计算当前结点高度，无需向解法一那样结点的高度会被重复计算。而且可以通过返回-1来指示树是不平衡的，提前结束结点高度的计算。
//
//代码：
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
