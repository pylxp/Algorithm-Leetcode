package java.t100_t199.t100_t109;

public class T104 {
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
        public int maxDepth(TreeNode root) {
            //这题跟102、103相似，建议放在一起做
            //返回树的最大深度
            //不难发现，本质上还是个遍历计数
            //为了确保获得的层数最大，那么最少每个节点都得遍历一次
            //那么这题不难想到两种解法
            //1.bfs+计数
            //2.dfs+计数
            //这里采用dfs，因为dfs本身即自带计数

            //先设立终止条件
            if (root == null) return 0;
            //往下层遍历同时计数+1
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
