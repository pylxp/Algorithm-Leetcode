package java.t100_t199.t120_t129;

public class T120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            //这题跟118、119杨辉三角形类型，建议放在一起做
            //求最上层到最下层的最短路径
            //同时由于每一层的结果都受下一层影响，所以这里可以采用动态规划的方法
            //另外题目要求只使用O(n)的额外空间
            //那么这里可以采用自底向上的方法，即从最后一行遍历到头，
            //每次遍历只需要在下一层的基础上添加自身即可，不需要超出O(n)的额外空间

            //获取层数(从0计数)
            int rows = triangle.size();
            //建立动态矩阵
            int[] dp = new int[rows];
            //遍历最后一层，初始化dp矩阵
            for (int col = 0; col < rows; col++)
                dp[col] = triangle.get(rows - 1).get(col);
            //自底向上遍历每一层（最后一层已经遍历初始化，不用再）
            for (int row = rows - 2; row >= 0; row--)
                //遍历每一列
                for (int col = 0; col <= row; col++)
                    //获取下一层的相邻节点最小值+自身
                    dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            //返回结果
            return dp[0];
        }
    }
}
