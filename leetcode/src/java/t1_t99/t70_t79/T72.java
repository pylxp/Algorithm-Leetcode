package java.t1_t99.t70_t79;

public class T72 {
    class Solution {
        public int minDistance(String word1, String word2) {
            //典型的动态规划问题，固定一个字符串
            //再根据另一个字符串的前一个状态来计算后一个状态即可
            //dp[i][j]表示wordl1前i个字符转换为word2前j个字符需要进行几次变换
            //这一次的状态分为三种情况
            //1.dp[i-1][j-1],则表示这次的ij直接变换即可
            //2.dp[i][j-1],表示删除j更快
            //2.dp[i-1][j],表示删除i更快
            //获取两个字符串的长度
            int len1 = word1.length();
            int len2 = word2.length();

            //防止出现空字符串的情况，默认dp[0][0]=0
            int[][] dp = new int[len1 + 1][len2 + 1];
            //处理第一行
            for (int i = 0; i <= len1; i++)
                dp[i][0] = i;
            //处理第一列
            for (int j = 0; j <= len2; j++)
                dp[0][j] = j;

            //固定字符串word1,遍历word2
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    //如果相等，则继承上一个状态即可(表示转换次数不增加)
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                        //不等则在上一次状态的基础上+1
                        //1.dp[i-1][j-1],表示直接变换更快
                        //2.dp[i][j-1]，表示删除j更快
                        //3.dp[i-1][j],表示删除i更快
                    else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
            //返回结果
            return dp[len1][len2];
        }
    }
}
