package java.t100_t199.t100_t109;

public class T105 {
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
        Map<Integer, Integer> map = new HashMap<>();
        //用于遍历前序遍历的索引
        int index = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //根据前中序遍历推出树的结构，考察树理解基础题
            //前序遍历 中左右  中序遍历 左中右
            //那么不难看出，前序遍历的头就是树的根
            //即通过前序的头得到根，通过根在中序的位置即可区分左右子树
            //然后前序节点的下一个节点，又会是左子树的根，以此递推
            //所以要知道每个数在中序遍历中的索引，才能准备区分左右子树
            //很明显，map能比较容易的完成这个任务

            //获取每个数在中序遍历中的索引位置
            for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
            //调用递归方法
            return recursion(preorder, inorder, 0, inorder.length);
        }

        /**
         * @Author: Lxp
         * @Description:递归方法
         * @Date: 2020/5/16
         * @Param preorder: 前序遍历数组
         * @Param inorder: 中序遍历数组
         * @Param inLeft: 左子树边界
         * @Param inRight: 右子树边界
         **/
        public TreeNode recursion(int[] preorder, int[] inorder, int inLeft, int inRight) {
            //先设立终止条件
            if (inLeft == inRight) return null;
            //获取根节点
            TreeNode root = new TreeNode(preorder[index]);
            //获取根节点在中序遍历的索引，区分左右子树，同时索引往后遍历
            int rootIndex = map.get(preorder[index++]);
            //递归遍历左子树
            root.left = recursion(preorder, inorder, inLeft, rootIndex);
            //递归遍历右子树
            root.right = recursion(preorder, inorder, rootIndex + 1, inRight);
            //返回根节点
            return root;
        }
    }
}
