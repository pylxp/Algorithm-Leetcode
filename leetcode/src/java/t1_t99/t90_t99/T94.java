package java.t1_t99.t90_t99;

public class T94 {
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
        //提取为全局变量，方便调用
        //创建结果集
        List<Integer> res;

        public List<Integer> inorderTraversal(TreeNode root) {
            //给定一个二叉树，返回它的中序遍历
            //根据中序遍历的性质，返回顺序为左中右
            //即每遍历一个节点，先返回其左节点，再然后其自身，然后返回右节点
            //由此不难想到，递归遍历是最为容易想到且实用的方法

            //初始化res
            res = new ArrayList<>();
            //调用递归方法
            ldr(root);
            //返回结果
            return res;
        }

        public void ldr(TreeNode root) {
            //不为空则往下继续递归
            if (root != null) {
                //先遍历左节点
                if (root.left != null) ldr(root.left);
                //再遍历自身
                res.add(root.val);
                //最后遍历右节点
                if (root.right != null) ldr(root.right);
            }
        }
    }
}
