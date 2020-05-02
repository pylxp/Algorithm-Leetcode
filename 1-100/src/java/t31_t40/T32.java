package java.t31_t40;

public class T32 {
    class Solution {
        public int longestValidParentheses(String s) {
            //动态规划，根据括号的性质，括号是否有效，却决于右括号能否适配
            //最大的有效括号长度
            int res = 0;
            //dp[i]，表示到第i-1个位为止，最大的有效括号长度
            int[] dp = new int[s.length()];
            //无论第一个字符是啥都没意义，从第二个开始遍历即可
            for (int i = 1; i < s.length(); i++) {
                //遇到右括号处理，如果是逆序遍历，则主要处理左括号
                if (s.charAt(i) == ')') {
                    //根据括号的性质，右括号的左边一位(排除成对的括号外的第一位)必须是左括号才有效
                    //左边即为左括号的情况
                    if (s.charAt(i - 1) == '(') {
                        //当前位记录的有效长度，应该为前边有效长度的基础上+2
                        dp[i] = (i >= 2) ? dp[i - 2] + 2 : 2;
                    }
                    //左边有成对括号的情况
                    //i-dp[i-1]>0,即索引长度减掉前一位记录的有效长度大于0，表明排除成对的括号后，还有剩余字符
                    //i - dp[i - 1] - 1，即成对括号的前一位，必须为左括号才能继续配对
                    else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        //(i - dp[i - 1]) >= 2 即要算上前边可能还有有效的小括号对
                        int count = ((i - dp[i - 1]) >= 2) ? dp[i - dp[i - 1] - 2] : 0;
                        //当前位记录的有效长度，应该为前边有效长度的基础上+2,再加上前边的括号对
                        dp[i] = dp[i - 1] + 2 + count;
                    }
                    //获取到目前为止，最大的有效长度
                    res = Math.max(res, dp[i]);
                }
            }
            return res;
        }
    }
}
