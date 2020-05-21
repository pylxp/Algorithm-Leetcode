package java.t100_t199.t120_t129;

public class T129 {
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
        public int sumNumbers(TreeNode root) {
            //计算根节点到所有子节点的路径总和
            //那么根据示例，实际上不难发现
            //没往下遍历一层，上面的路径数值就*10
            //根据这个特点，进行dfs遍历即可

            //调用dfs方法并返回结果
            return dfs(root, 0);
        }

        public int dfs(TreeNode root, int res) {
            //先设立终止条件
            if (root == null) return 0;
            //更新结果
            res = res * 10 + root.val;
            //遍历到底则返回该路径的结果
            if (root.left == null && root.right == null) return res;
            //往下一层
            return dfs(root.left, res) + dfs(root.right, res);
        }
    }
}
