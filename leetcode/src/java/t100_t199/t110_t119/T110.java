package java.t100_t199.t110_t119;

public class T110 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            //判断是否为平衡二叉树
            //那么无非就是通过遍历，获取树的左右高度进行对比
            //那么不难想到两种方法
            //1.从根节点往下遍历，对比左右子树的高度
            //2.从叶子节点往上遍历，对比左右子树的高度
            //这里采用方法2

            //调用方法
            return recursion(root) >= 0;
        }

        public int recursion(TreeNode root) {
            //先设立终止条件
            if (root == null) return 0;
            //遍历左节点
            int left = recursion(root.left);
            //遍历右节点
            int right = recursion(root.right);
            //只要存在左右不平衡则返回-1
            if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
            //返回左右节点的最大高度
            return Math.max(left, right) + 1;
        }
    }
}
