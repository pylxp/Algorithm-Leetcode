package java.t100_t199.t110_t119;

public class T111 {
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
        public int minDepth(TreeNode root) {
            //这题跟110相似，建议放在一起做
            //判断树的最小高度，要求从根节点到最近叶子节点
            //那么这里要注意，最小叶子节点，左右都为空
            //换个角度看，即null节点所在的层数-1，即为最小高度

            //先设立终止条件
            if (root == null) return 0;
            //遍历左子树
            int left = minDepth(root.left);
            //遍历右子树
            int right = minDepth(root.right);
            //如果已经遇到null，则不用再往下遍历
            if (left == 0 || right == 0) return left + right + 1;
            //返回结果
            return Math.min(left, right) + 1;
        }
    }
}
