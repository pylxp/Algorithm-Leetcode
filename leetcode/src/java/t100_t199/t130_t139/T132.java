package java.t100_t199.t130_t139;

public class T132 {
    class Solution {
        public int minCut(String s) {
            //这题跟131相似，建议放在一起做
            //这题跟131的区别在于，只需要求最短的分割次数即可
            //那么延续上一题的思想即可，即通过dp[i][j]来标志i-j是否为回文串
            //然后通过计算拼接次数即可

            //获取字符串长度
            int len = s.length();
            //res[i],记录到第i+1个字符的最小分割术
            int[] res = new int[len];
            //创建dp矩阵
            boolean[][] dp = new boolean[len][len];
            //固定末尾字符
            //从第2位开始即可，因为一个字符不需要分割，即res[0]=0;
            for (int i = 1; i < len; i++) {
                //默认新的字符独立，则次数加1
                res[i] = res[i - 1] + 1;
                //往前遍历更新分割次数
                for (int j = 0; j <= i; j++) {
                    //同上题，首尾相等，同时中间不足2个字符，或者中间已经是回文串，则必然为新的回文串
                    if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                        //标志i-j为回文串
                        dp[j][i] = true;
                        //更新到第i位为止的最小分割次数
                        //如果是0-i，则为0,否则就等于0-j-1/j-i,即计数在分割段上加一
                        res[i] = j == 0 ? 0 : Math.min(res[i], res[j - 1] + 1);
                    }
                }
            }
            //返回结果
            return res[len - 1];
        }
    }
}
