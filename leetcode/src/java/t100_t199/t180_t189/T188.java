package java.t100_t199.t180_t189;

public class T188 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            //这题跟121~123相似，建议放在一起做
            //区别只在于买卖次数变成了随机数k
            //那么其实不难理解，如果k等于1，等同于121题
            //k>prices.length/2,则等同于122题
            //k=2则等同于123题
            //即本质上题目没差别，这里同样采用123题的做法即可
            //由于不确定k的具体数值，所以可以采用动态规划算法
            //即dp[k][n]记录买卖次数为k时的最大收益

            //计算数组长度
            int n = prices.length;
            //直接采用122题的做法，即不限制买卖次数，低买高卖
            if (k >= n / 2){
                //存放结果
                int res = 0;
                //直接遍历低买高卖即可
                for (int i = 1; i < n; i ++)
                    res += Math.max(0, prices[i] - prices[i - 1]);
                //返回结果
                return res;
            }
            //创建dp矩阵
            //dp[k][n]表示k次买卖的最高利润
            int[][] dp = new int[k + 1][n];
            //预假设买卖次数为1~k
            for (int i = 1; i < dp.length; i ++){
                //初始化收益
                int maxProfit = -prices[0];
                //遍历价格表
                for (int j = 1; j < dp[0].length; j ++){
                    //计算当前最大收益
                    maxProfit = Math.max(maxProfit, dp[i - 1][j - 1] - prices[j]);
                    //更新当前最大收益
                    dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxProfit);
                }
            }
            //返回结果
            return dp[k][n - 1];
        }
    }
}
