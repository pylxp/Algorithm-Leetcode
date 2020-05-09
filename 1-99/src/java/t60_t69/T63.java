package src.java.t60_t69;

public class T63 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            //这题跟62相似，或者说是62的拓展，建议一起做
            //典型的动态规划路径问题
            //由题意不难理解，到达第[n][m]格的方法数
            //等同于第[n][m-1]+[n-1][m]相加
            //即dp[n][m]=dp[n][m-1]+dp[n-1][m]
            //经过简化，提即提前保存dp[n][m-1]，每次添加dp[n-1][m]即可
            //即dp[n]=dp[n]+dp[n-1]

            //先处理特殊情况
            if (obstacleGrid[0][0] == 1) return 0;
            //获取行列数
            int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
            //记录到达每一个格子的方法次数
            int[] dp = new int[cols];
            //初始化第一行
            dp[0] = 1;
            //先处理矩阵图第一行
            for (int i = 1; i < cols; i++) {
                //如果可以走通，即次数初始化为1
                if (obstacleGrid[0][i] == 0) dp[i] = 1;
                    //如果遇到0，则后续无需多余遍历
                else break;
            }
            //遍历每一行
            for (int i = 1; i < rows; i++) {
                //遍历每一列
                for (int j = 0; j < cols; j++) {
                    //如果遇到障碍物，次数重置
                    if (obstacleGrid[i][j] == 1) dp[j] = 0;
                        //第一行已经初始化，不做处理
                    else if (j == 0) continue;
                        //dp[n]=dp[n][m-1]+dp[n-1][m]
                        //等同于dp[n][m-1]提前保存，遍历添加dp[n-1][m]
                    else dp[j] += dp[j - 1];
                }
            }
            //返回结果
            return dp[cols - 1];
        }
    }
}
