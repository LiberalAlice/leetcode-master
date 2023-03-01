package Offer.tree.firstPratice;

import Offer.tree.firstPratice.TreeNode;

public class tree617 {




    //617. 合并二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return root2;
        }
        if (root2 == null && root1 != null) {
            return root1;
        }
        if (root1 == null && root2 == null) {
            return null;
        }
        int value = root1.val + root2.val;
        TreeNode node = new TreeNode(value);

        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    //700. 二叉搜索树中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }

    //98. 验证二叉搜索树
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            return false;
        }
        int value = root.val;
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        return isValidBST(root.right);
    }


    int min = Integer.MAX_VALUE;
    TreeNode node;
    //530.二叉搜索树的最小绝对差
    public int getMinimumDifference(TreeNode root) {
        update_min(root);
        return min;
    }

    private void update_min(TreeNode root) {
        if (root == null) {
            return;
        }
        update_min(root.left);
        if (node != null) {
            min = Math.min(min, root.val - node.val);
        }
        node = root;
        update_min(root.right);
    }

    //501. 二叉搜索树中的众数

    //236. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null && right == null) {
            return left;
        }
        if (right != null && left == null) {
            return right;
        }
        return null;
    }

    //235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    //701. 二叉搜索树中的插入操作
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            TreeNode node = insert(root.left, val);
            if (node == null) {
                root.left = new TreeNode(val);
            }
        }
        if (root.val < val) {
            TreeNode node = insert(root.right, val);
            if (node == null) {
                root.right = new TreeNode(val);
            }
        }
        return root;
    }

    //迭代法
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode parent = root;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                cur = cur.left;
            }else cur = cur.right;
            parent = cur;
        }
        if (parent.val < val) {
            parent.right = new TreeNode(val);
        }else parent.left = new TreeNode(val);
        return root;
    }

    //450. 删除二叉搜索树中的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.left != null && root.right == null) {
                return root.left;
            }else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }


    //669. 修剪二叉搜索树
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    //108. 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
       return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);

        root.left = construct(nums, left, mid - 1);
        root.right = construct(nums, mid + 1, right);
        return root;
    }

    //538. 把二叉搜索树转换为累加树
    public TreeNode convertBST(TreeNode root) {
        mid_visit(root);
        return root;
    }
    int pre = 0;
    private void mid_visit(TreeNode root) {
        if (root == null) {
            return ;
        }
        convertBST(root.right);
        root.val += pre;
        pre = root.val;
        convertBST(root.left);
        return ;
    }


}
