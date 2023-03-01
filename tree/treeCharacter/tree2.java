package Offer.tree.treeCharacter;

import java.util.*;

public class tree2 {

    //二叉树的全部路径 前序递归（回溯） + stringBuffer
    List<String> list = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    //左叶子之和
    int result = 0;
    //106. 从中序与后序遍历序列构造二叉树
    int[] postorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    //验证二叉搜索树
    Long max_value = Long.MIN_VALUE;
    //二叉搜索树的最小绝对差
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    //二叉搜索树中的众数
    ArrayList<Integer> relist = new ArrayList<>();
    int count = 0;
    int max = 0;
    TreeNode preNode = null;

    //判断对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricLR(root.left, root.right);
    }

    private boolean isSymmetricLR(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (right.val == left.val) {
            return isSymmetricLR(right.left, left.right) && isSymmetricLR(left.left, right.right);
        }
        return true;
    }

    //二叉树最大深度
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }

    //二叉树叶子节点的最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right != null && root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        } else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    //完全二叉树的节点个数
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(right - left) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return list;
        }
        pringPath(root, path);
        return list;
    }

    private void pringPath(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        StringBuffer buffer = new StringBuffer();
        path.add(root.val);
        if (root.right == null && root.left == null) {
            for (int i = 0; i < path.size(); i++) {
                buffer.append(path.get(i));
                if (i % 2 == 1) {
                    buffer.append("->");
                }
            }
            list.add(buffer.toString());
        }
        if (root.left != null) {
            pringPath(root.left, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            pringPath(root.right, path);
            path.remove(path.size() - 1);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            result += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return result;
    }

    //找树左下角的值
    public int findBottomLeftValue(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0 && node.left == null && node.right == null) {
                    if (node.val < min) {
                        min = node.val;
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return min;
    }

    //112. 路径总和
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
//        return isSumTree(root, targetSum - root.val);
        return isSumTree2(root, targetSum);

    }

    private boolean isSumTree(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                return true;
            } else return false;
        }
        if (root.left != null) {
            if (isSumTree(root.left, sum - root.left.val)) {
                return true;
            }
        }
        if (root.right != null) {
            if (isSumTree(root.right, sum - root.right.val)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSumTree2(TreeNode root, int sum) {
        sum -= root.val;
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                return true;
            } else return false;
        }
        return isSumTree(root.left, sum) || isSumTree(root.right, sum);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(postorder[root]);
        }
        int root_value = postorder[root];
        //中序遍历root的索引
        int root_index = map.get(root_value);
        TreeNode node = new TreeNode(root_value);
        node.right = build(root - 1, root_index + 1, right);
        node.left = build(root - (right - root_index) - 1, left, root_index - 1);
        return node;
    }

    //最大二叉树
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getMax(nums, 0, nums.length - 1);
    }

    private TreeNode getMax(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int max = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = getMax(nums, left, max - 1);
        node.right = getMax(nums, max + 1, right);
        return node;
    }

    //合并二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode node = null;
        if (root1 != null && root2 != null) {
            int value = root1.val + root2.val;
            node = new TreeNode(value);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        } else if (root1 == null && root2 != null) {
            node = root2;
        } else if (root1 != null && root2 == null) {
            node = root1;
        } else {
            return null;
        }
        return node;
    }

    //二叉搜索树中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else return root;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (root.val <= max_value) {
            return false;
        }
        max_value = Long.valueOf(root.val);
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        getMinimumDifference(root.right);
        return min;
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        findMode(root.left);
        if (preNode == null) {
            count = 1;
        } else if (preNode.val == root.val) {
            count++;
        } else count = 0;
        if (count == max) {
            relist.add(root.val);
        }
        if (count > max) {
            relist.clear();
            relist.add(root.val);
            max = count;
        }
        preNode = root;
        findMode(root.right);
        return relist.stream().mapToInt(Integer::intValue).toArray();
    }

    //二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else return null;
    }

    //二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            TreeNode node = lowestCommonAncestor2(root.right, p, q);
            return node == null ? null : node;
        } else if (root.val > p.val && root.val > q.val) {
            TreeNode node = lowestCommonAncestor2(root.left, p, q);
            return node == null ? null : node;
        } else return root;
    }

    //二叉搜索树中的插入操作
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST(root.right, val);
            }
        }
        return root;
    }
    //删除二叉搜索树中的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    //修剪二叉搜索树
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    //有序数组转为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortTree(nums, 0, nums.length - 1);
    }

    private TreeNode sortTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortTree(nums, left, middle - 1);
        node.right = sortTree(nums, middle + 1, right);
        return node;
    }

    //把二叉搜索树转换为累加树
    int sumValue = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sumValue += root.val;
        root.val = sumValue;
        convertBST(root.left);
        return root;
    }


}
