package tree;

public class BinaryTree {
    public Integer[] arr;
    public TreeNode root;

    public TreeNode setTree(Integer[] arr) {
        this.arr = arr;
        root = createNode(root, 0);
        return root;
    }

    public TreeNode createNode(TreeNode rot, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        rot = new TreeNode(arr[index]);
        rot.left = createNode(rot.left, index * 2 + 1);
        rot.right = createNode(rot.right, index * 2 + 2);
        return rot;
    }

    public BinaryTree(Integer[] arr) {
        this.arr = arr;
        root = createNode(root, 0);
    }

    public BinaryTree() {
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}

