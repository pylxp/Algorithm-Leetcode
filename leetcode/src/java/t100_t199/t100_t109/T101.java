package java.t100_t199.t100_t109;

public class T101 {
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
        public boolean isSymmetric(TreeNode root) {
            //判断是不是对称二叉树
            //其实本质就是对比两个节点是否相同
            //难点就在于怎么判断哪两个节点对比。实际上无非三种情况
            //1.根节点自身对比，2.左子树的左节点对右子树的右节点，3.同2相反
            //按照以上结论，不难发现，递归能很简单的满足要求
            //为了方便看参数的传递，这里建一个2参的方法递归
            return isMirror(root, root);
        }

        //镜像对比方法
        public boolean isMirror(TreeNode node1, TreeNode node2) {
            //递归第一步，先设立终止条件
            //相等返回true
            if (node1 == null&& node2 == null) return true;
            //不等返回false
            if (node1 == null || node2 == null) return false;
            //必须3种情况都满足
            return (node1.val == node2.val)
                    && isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left);
        }
    }
}
