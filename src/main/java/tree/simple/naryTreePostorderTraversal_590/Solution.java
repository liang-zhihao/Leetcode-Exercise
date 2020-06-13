package tree.simple.naryTreePostorderTraversal_590;


//Given an n-ary tree, return the postorder traversal of its nodes' values.
//
//Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
//
// 
//
//Follow up:
//
//Recursive solution is trivial, could you do it iteratively?

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }

    public void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i), list);
        }
        list.add(root.val);
    }

    @Test
    public void test() {
        Node root = new Node(1, new ArrayList<Node>());
        root.children.add(new Node(3, new ArrayList<Node>()));
        root.children.get(0).children.add(new Node(5, new ArrayList<Node>()));
        root.children.get(0).children.add(new Node(6, new ArrayList<Node>()));
        root.children.add(new Node(2, new ArrayList<Node>()));
        root.children.add(new Node(4, new ArrayList<Node>()));
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        Solution2 s2=new Solution2();
        System.out.println(s2.postorder(root).toString());
    }

}
//首先，我们需要的遍历顺序为：左->右->根。
//
//其次，上面链接的题解提到了，如果对层序遍历进行改造，即结点每次都从队尾出列，然后再将子结点从左到右入列，很容易发现，这是一种根->右->左的前序遍历。
//根->右->左，而我们需要的是左->右->根。
//是否得到了什么启发？
//显然，把根->右->左得到的顺序颠倒，就是答案左->右->根，即后序遍历。
//由于还是从队尾出列，还是后进先出，故还是使用栈代替队列。
//颠倒的方式很简单，就是每次都把值添加到结果List的开头即可。

class Solution2 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if(root==null){
            return res;
        }
        LinkedList<Node> list = new LinkedList<Node>();

        list.push(root);
        while (!list.isEmpty()) {
            Node node = list.pop();
            res.push(node.val);
            for (Node n :
                    node.children) {
                list.push(n);

            }
        }
        return res;
    }


    @Test
    public void test() {
        Node root = new Node(1, new ArrayList<Node>());
        root.children.add(new Node(3, new ArrayList<Node>()));
        root.children.get(0).children.add(new Node(5, new ArrayList<Node>()));
        root.children.get(0).children.add(new Node(6, new ArrayList<Node>()));
        root.children.add(new Node(2, new ArrayList<Node>()));
        root.children.add(new Node(4, new ArrayList<Node>()));
        System.out.println(postorder(root).toString());

    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
