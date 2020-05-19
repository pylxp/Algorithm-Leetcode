package java.t100_t199.t110_t119;

public class T114 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        //提取为全局变量，方便调用
        //保存下一个节点
        TreeNode postNode = null;

        public void flatten(TreeNode root) {
            //给定一个二叉树，原地展开为一个单链表
            //根据示例不难发现，是一个前序遍历的展开方式
            //那么实际上这题就是在前序遍历的基础上，将节点按序连接在右节点上
            //那么反过来，就等于后序遍历，每个节点连接下一个节点

            //调用方法,默认前一个节点为null
            postorder(root);
        }

        public void postorder(TreeNode root) {
            //先设立终止条件
            if (root == null) return;
            //往右递归找到最后一个右节点
            postorder(root.right);
            //往左递归找到最后一个左节点
            postorder(root.left);
            //左节点都置为空，右节点连接下一个节点
            root.left = null;
            root.right = postNode;
            //更新下一个节点
            postNode = root;
        }
    }
}
