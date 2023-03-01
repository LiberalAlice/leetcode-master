package Offer.tree.firstPratice;

import Offer.tree.firstPratice.TreeNode;

public class tree26 {

    //判断树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recursion(A, B) || isSubStructure(A.right, B) || isSubStructure(A.left, B);
    }

    private boolean recursion(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) return false;
        return recursion(a.left, b.left) && recursion(a.right, b.right);
    }
}
