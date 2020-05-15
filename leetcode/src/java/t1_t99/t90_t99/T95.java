package java.t1_t99.t90_t99;

public class T95 {
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
        public List<TreeNode> generateTrees(int n) {
            //给定一个整数，生成由1~n为节点所组成的二叉搜索树
            //由以上题意不难得出以下结论
            //1.根据二叉搜索树的性质
            // 即节点的左子树都小于自身，右子树都大于自身
            //2.任何一个数1~n都可以作为根节点，只要满足结论1
            //根据以上结论不难想到，固定根节点，递归左右子树即可实现遍历

            //先处理特殊情况
            if (n == 0) return new ArrayList<>();
            //调用递归方法
            return dfs(1, n);
        }

        //left/right左边用于作为左右边界
        public List<TreeNode> dfs(int left, int right) {
            List<TreeNode> res = new ArrayList<>();
            //先设立终止条件，为空时要添加null
            if (left > right) {
                res.add(null);
                return res;
            }
            //遍历从left~right分别作为根节点的情况
            for (int i = left; i <= right; i++) {
                //获取左子树的所有排列
                List<TreeNode> leftTree = dfs(left, i - 1);
                //获取右子树的所有排列
                List<TreeNode> rightTree = dfs(i + 1, right);
                //遍历左子树的所有排列
                for (TreeNode leftNode : leftTree) {
                    //遍历右子树的所有排列
                    for (TreeNode rightNode : rightTree) {
                        //以i为根节点
                        TreeNode root = new TreeNode(i);
                        //拼接左子树
                        root.left = leftNode;
                        //拼接右子树
                        root.right = rightNode;
                        //添加入结果集
                        res.add(root);
                    }
                }
            }
            //返回结果
            return res;
        }
    }
}
