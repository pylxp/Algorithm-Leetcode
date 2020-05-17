package java.t100_t199.t100_t109;

public class T107 {
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

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            //这题跟102类似，建议放在一起做
            //层序遍历，每层组成一个list返回
            //这题跟102的区别只在于，要自底向上遍历
            //那么这题不难想到两种解法
            //1.bfs+queue按层次遍
            //2.dfs外加一个层号index标记遍历
            //这里采用bfs

            //为空直接返回
            if (root == null) return res;
            //调用bfs方法
            bfs(root);
            //返回结果
            return res;
        }

        //bfs方法
        public void bfs(TreeNode root) {
            //创建队列用于存放每一层的节点
            Queue<TreeNode> queue = new LinkedList<>();
            //第一层只有root
            queue.add(root);
            //队列不为空则表示还没遍历完
            while (!queue.isEmpty()) {
                //存放每层的遍历结果
                List<Integer> list = new ArrayList<>();
                //记录每一层的节点数
                int count = queue.size();
                //遍历每一层
                for (int i = 0; i < count; i++) {
                    //将每一层的节点的值放入列表
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    //把下一层的节点放入队列
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                //添加每一层的结果在最前面
                res.add(0, list);
            }
        }
    }
}
