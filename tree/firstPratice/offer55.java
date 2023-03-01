package Offer.tree.firstPratice;

import Offer.tree.firstPratice.TreeNode;

public class offer55 {

    //平衡树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int right = maxDepth(root.right);
        int left = maxDepth(root.left);
        return Math.abs(right - left) <= 1 &&  isBalanced(root.right) && isBalanced(root.left);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
