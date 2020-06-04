package java.t100_t199.t190_t199;

public class T199 {
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
        //存放结果集
        List<Integer> res = new ArrayList();

        public List<Integer> rightSideView(TreeNode root) {
            //返回二叉树的右视图，那么无非就是返回每一层的最右节点
            //因此这题可以采用bfs，遍历每一层的最后一个节点
            //也可以采用dfs，每一层优先取右节点
            //这里采用dfs的方法

            //调用dfs方法
            dfs(root, 1);
            //返回结果
            return res;
        }

        /**
         * @Author: Lxp
         * @Description:dfs方法
         * @Date: 2020/6/3
         * @Param root:当前节点
         * @Param level:层数
         * @return: void
         **/
        public void dfs(TreeNode root, int level) {
            //先设立终止条件
            if (root == null) return;
            //层数level刚好应该等于结果集面积，即表示该层已经找到最右节点
            if (res.size() < level) res.add(root.val);
            //优先遍历右节点
            dfs(root.right, level + 1);
            //没有右节点的情况，左节点才可能是最右节点
            dfs(root.left, level + 1);
        }
    }
}
