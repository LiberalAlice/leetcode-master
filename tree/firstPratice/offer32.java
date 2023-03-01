package Offer.tree.firstPratice;

import java.util.*;

public class offer32 {

    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    //226. 翻转二叉树 前序递归法
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;


        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    //前序迭代法翻转二叉树
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return root;
    }

    //101. 对称二叉树 再遍历两颗子树
    public boolean isSymmetric(TreeNode root) {
//        invertTree(root.left);
        return is_the_same(root.left, root.right);
    }

    private boolean is_the_same(TreeNode left, TreeNode right) {
        if (left == null && right == null || left.val != right.val) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return is_the_same(left.right, right.left) && is_the_same(left.left, right.right);
    }

    //104  二叉树的最大深度 后序递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //层序遍历
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.peek();
                queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
            result++;
        }
        return result;
    }

    //最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null && root.left != null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    //迭代法
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int min, deep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            deep++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right == null && node.left == null) {
                    return deep;
                }
            }
        }
        return deep;
    }

    //222. 满二叉树的节点个数
    public int countNodes(TreeNode root) {
        int i = maxDepth(root);
        return (int) Math.pow(2, i) - 1;
    }


    //平衡树
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) == -1 ? false : true;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    //二叉树的全部路径
    ArrayList<String> list = new ArrayList();

    public List<String> binaryTreePaths(TreeNode root) {
        backtracing(root);
        return list;
    }

    private void backtracing(TreeNode root) {
        if (root == null) {
//            list.add()
            return;
        }
        String s = null;
        StringBuffer buffer = new StringBuffer(s);
        buffer.append(root.toString() + "->");
        backtracing(root.right);
        backtracing(root.left);
    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumOfLeftLeaves(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.right);
        return sum;
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    //112
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return getValue(root, targetSum - root.val);
    }

    private boolean getValue(TreeNode root, int count) {
        if (root.right == null && root.left == null) {
            if (count == 0) {
                return true;
            }
        }
        if (root.left != null) {
            if (getValue(root.left, count - root.left.val)) {
                return true;
            }
        }
        if (root.right != null) {
            if (getValue(root.right, count - root.right.val)) {
                return true;
            }
        }
        return false;
    }


    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return count_node(root, targetSum - root.val);
    }

    private boolean count_node(TreeNode node, int count) {
        if (node.right == null && node.left == null) {
            return 0 == count;
        }
        if (node.left != null) {
            if (count_node(node.left, count - node.left.val)) {
                return true;
            }
        }
        if (node.right != null) {
            if (count_node(node.right, count - node.right.val)) {
                return true;
            }
        }
        return false;
    }

    int postorder[];
    HashMap<Integer, Integer> map = new HashMap();

    //后序和中序构造二叉树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findRoot(postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode findRoot(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        Integer root_index = map.get(postorder[root]);
        TreeNode node = new TreeNode(postorder[root]);

        node.right = findRoot(root - 1, root_index + 1, right);
        node.left = findRoot(root - (right - root_index) - 1, left, root_index - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 3, 15, 20, 7};
        int[] b = new int[]{9, 15, 7, 20, 3};
        offer32 offer32 = new offer32();
        System.out.println(offer32.buildTree(a, b));
    }

    //前序和中序
    int[] preorder;
    HashMap<Integer, Integer> hashMapmap = new HashMap<>();

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return find_root(0, 0, inorder.length - 1);
    }

    private TreeNode find_root(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        int value = preorder[root];
        int index_root = hashMapmap.get(value);
        TreeNode node = new TreeNode(value);

        node.left = find_root(root + 1, left, index_root - 1);
        node.right = find_root(root + (index_root - left) + 1, index_root + 1, right);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct_Maxtree(0, nums.length - 1, nums);
    }

    private TreeNode construct_Maxtree(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        if (left - right == 1) {// 只有一个元素
            return new TreeNode(nums[left]);
        }
        int max = nums[left];
        int root_index = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                root_index = i;
            }
        }
        int value = nums[root_index];
        TreeNode node = new TreeNode(value);

        node.left = construct_Maxtree(left, root_index - 1, nums);
        node.right = construct_Maxtree(root_index + 1, right, nums);
        return node;
    }


}
