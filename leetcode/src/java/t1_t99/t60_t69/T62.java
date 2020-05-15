package src.java.t60_t69;

public class T62 {
    class Solution {
        public int uniquePaths(int m, int n) {
            //经典的动态规划问题
            //这里要注意坑，m是列，n是行
            //由题意不难理解，到达第[n][m]格的次数
            //等同于第[n][m-1]+[n-1][m]相加
            //即dp[n][m]=dp[n][m-1]+dp[n-1][m]
            //经过简化，提即提前保存dp[n][m-1]，每次添加dp[n-1][m]即可
            //即dp[n]=dp[n]+dp[n-1]
            int[] dp = new int[n];
            //初始化第一行即
            dp[0] = 1;
            //遍历每一列
            for (int col = 0; col < m; col++) {
                //遍历每一行
                for (int row = 0; row < n; row++) {
                    //第一行已经初始化，不做处理
                    //dp[n]=dp[n][m-1]+dp[n-1][m]
                    //等同于dp[n][m-1]提前保存，遍历添加dp[n-1][m]
                    if (row > 0) dp[row] += dp[row - 1];
                }
            }
            //返回结果
            return dp[n-1];
        }
    }
}
