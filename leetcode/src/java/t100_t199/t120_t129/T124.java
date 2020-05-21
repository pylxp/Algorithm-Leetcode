package java.t100_t199.t120_t129;

public class T124 {
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
        //提升为全局变量，方便调用
        //这里要初始化为极小值，因为节点可以为负
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            //这题类似120，建议放在一起做
            //求最大的路径和，不一定要求经过根节点
            //即求树的任意两个节点的最大路径
            //那么实际上不难发现，假设一个节点是必经节点
            //那么求通过该节点的路径最大值，就等于左右子树的最大路径加自身
            //即分为左右子树，分别计算最有子树的最大路径再加上自身即可
            //如果从上往下遍历，会导致重复计算，因此采用后序遍历，从下往上计算即可

            //调用后序遍历方法
            postOrder(root);
            //返回结果
            return max;
        }

        private int postOrder(TreeNode root) {
            //先设立终止条件
            if (null == root) return 0;
            //求左子树的最大路径
            int leftMax = Math.max(postOrder(root.left), 0);
            //求右子树的最大路径
            int rightMax = Math.max(postOrder(root.right), 0);
            //更新最大路径
            max = Math.max(max, leftMax + rightMax + root.val);
            //往上一层遍历，必须经过当前节点，所以经过该树的最大路径和
            //等于自身加上左右子树的最大路径
            return root.val + Math.max(leftMax, rightMax);
        }
    }
}
