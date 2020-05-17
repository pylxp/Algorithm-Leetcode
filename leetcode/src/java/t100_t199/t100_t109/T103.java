package java.t100_t199.t100_t109;

public class T103 {
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
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            //这题跟102相似，建议放在一起做
            //锯齿层序遍历，每层组成一个list返回
            //不难发现，本质上还是个层序遍历，同102
            //区别在于偶数层从右往左遍历，那么加个标记即可
            //那么这题不难想到两种解法
            //1.bfs+queue按层次遍 + 奇数层标记
            //2.dfs外加一个层号index标记遍历 + 奇数层标记
            //这里采用dfs，因为原先dfs的层号index就可以作为奇数层标记

            //如果为空直接返回
            if (root == null) return res;
            //调用dfs方法
            dfs(root, 0);
            return res;
        }

        //dfs方法
        public void dfs(TreeNode root, int level) {
            //层数等于结果集数，表示进入了下一层
            //创建新一层的结果列表并加入结果集
            if (level == res.size()) res.add(new ArrayList<>());
            //偶数层从左往右
            if (level % 2 == 0) res.get(level).add(root.val);
                //奇数层，每次都添加在头部
            else res.get(level).add(0, root.val);
            //往下层继续遍历
            if (root.left != null) dfs(root.left, level + 1);
            if (root.right != null) dfs(root.right, level + 1);
        }
    }
}
