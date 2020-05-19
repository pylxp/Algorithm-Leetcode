package java.t100_t199.t110_t119;

public class T113 {
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
        //存放单次结果
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            //这题跟112相似，建议放在一起做
            //无非就是在判断路径求和符合sum的基础上，将路径添加进结果集
            //那么在这里直接采用上一题的做法，外加路径添加即可

            //先处理特殊情况
            if (root == null) return res;
            //调用方法
            dfs(root, sum);
            //返回结果
            return res;
        }

        //遍历方法
        public void dfs(TreeNode root, int sum) {

            //先设立终止条件
            if (root == null) return;
            //左右节点都为空，同时sum==root.val,即加入结果集
            if (sum == root.val && root.left == null && root.right == null) {
                //拼接路径
                path.add(root.val);
                //添加进结果集
                res.add(new ArrayList<>(path));
                //删除最后一个节点，返回上一层遍历同层其他节点
                path.remove(path.size() - 1);
                //返回上一层
                return;
            }
            //即路径还未找到，往下遍历
            path.add(root.val);
            //遍历左子树
            dfs(root.left, sum - root.val);
            //遍历右子树
            dfs(root.right, sum - root.val);
            //返回即表示下一个节点不满足，删除最后一个节点，返回上一层
            path.remove(path.size() - 1);
        }
    }
}
