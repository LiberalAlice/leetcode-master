package Offer.tree.firstPratice;


import Offer.tree.firstPratice.TreeNode;

import java.util.HashMap;

public class offer07 {
    //通过前序和中序遍历构造二叉树

    int [] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return find_node(0,0, inorder.length - 1) ;
    }

    private TreeNode find_node(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        Integer root_index = map.get(preorder[root]);
        TreeNode node = new TreeNode(preorder[root]);
        node.left = find_node(root + 1, left, root_index - 1);
        node.right = find_node(root + (root_index - left) + 1, root_index + 1, right);
        return node;
    }


}
