package Offer.tree.treeCharacter;

import java.util.*;

public class tree1 {
    ArrayList<Integer> integers = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return integers;
        }
        frontTraverse(root);
        generate(root);
        return integers;
    }

    //前序迭代遍历
    private void generate(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            integers.add(node.val);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
    }

    //递归前序遍历
    private void frontTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        integers.add(root.val);
        if (root.left != null) {
            frontTraverse(root.left);
        }
        if (root.right != null) {
            frontTraverse(root.right);
        }
    }

    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(new ArrayList<>(list));
            list.clear();
        }
        return result;
    }

    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(-1);
        node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //n叉树的递归遍历
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return null;
        }
        list.add(root.val);
        for (Node node : root.children
        ) {
            if (node != null) {
                preorder(node);
            }
        }
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}

