package java.t100_t199.t100_t109;

public class T106 {
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
        //用于遍历后序遍历的索引
        int index;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            //这题跟105类似，建议放在一起做
            //根据中后序遍历推出树的结构，考察树理解基础题
            //中序遍历 左中右  后序遍历 左右中
            //那么不难看出，后序遍历的尾就是树的根
            //即通过后序的尾得到根，通过根在中序的位置即可区分左右子树
            //然后后序节点的前一个节点，又会是右子树的根，以此递推
            //所以要知道每个数在中序遍历中的索引，才能准备区分左右子树
            //很明显，map能比较容易的完成这个任务

            //获取每个数在中序遍历中的索引位置
            for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
            //指向后序遍历末尾的索引
            index = postorder.length - 1;
            //调用递归方法
            return recursion(inorder, postorder, 0, inorder.length);
        }

        /**
         * @Author: Lxp
         * @Description:递归方法
         * @Date: 2020/5/16
         * @Param inorder: 中序遍历数组
         * @Param postorder: 后序遍历数组
         * @Param inLeft: 左子树边界
         * @Param inRight: 右子树边界
         **/
        public TreeNode recursion(int[] inorder, int[] postorder, int inLeft, int inRight) {
            //先设立终止条件
            if (inLeft == inRight) return null;
            //获取根节点
            TreeNode root = new TreeNode(postorder[index]);
            //获取根节点在中序遍历的索引，区分左右子树，同时索引往后遍历
            int rootIndex = map.get(postorder[index--]);
            //递归遍历右子树
            root.right = recursion(inorder, postorder, rootIndex + 1, inRight);
            //递归遍历左子树
            root.left = recursion(inorder, postorder, inLeft, rootIndex);
            //返回根节点
            return root;
        }
    }
}
