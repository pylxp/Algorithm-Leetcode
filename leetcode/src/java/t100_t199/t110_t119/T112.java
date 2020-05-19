package java.t100_t199.t110_t119;

public class T112 {
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
        public boolean hasPathSum(TreeNode root, int sum) {
            //判断从根节点到叶子节点，是否有路径和等于sum
            //即每次遍历后，sum的值可以理解为 sum-=root.val
            //直到左右节点都为空，同时sum==root.val，即为true

            //先设立终止条件
            if (root == null) return false;
            //左右节点都为空，同时sum==root.val，即为true
            if (root.left == null && root.right == null) return sum == root.val;
            //更新sum的值，同时往左右递归
            return hasPathSum(root.left, sum - root.val)
                    || hasPathSum(root.right, sum - root.val);
        }
    }
}
