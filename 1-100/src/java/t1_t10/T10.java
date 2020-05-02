package java.t1_t10;

public class T10 {
    class Solution {
        public boolean isMatch(String s, String p) {
            //注意是判断p是否包含s，dp[i][j]表示s的前i个字符是否和p的前j的字符匹配
            boolean dp[][]=new boolean[s.length()+1][p.length()+1];
            //dp[0][0]即s,p都为空的情况
            dp[0][0]=true;
            //补充dp[0][j],即s为空，p不为空的情况
            for (int j = 2; j <= p.length(); j++) {
                //因为‘*’表示0-n个字符(注意，因为索引从0开始，所以dp[i][j],实际为s[i-1]p[j-1])
                //故如果p[j-1]为‘*’,则状态位dp[0][j]跟前两位dp[0][j-2]相同即可，即‘*’表示忽略前一位
                dp[0][j]=(p.charAt(j-1)=='*'&&dp[0][j-2]);
            }
            //匹配剩余情况，注意从p的角度去看匹配状况，更容易理解
            for (int i=0;i<s.length();i++) {
                for (int j = 0; j < p.length(); j++) {
                    //同样，判断是否有‘*’,如果有，则状态位同前两位
                    if (p.charAt(j)=='*') {
                        /*
                         * 如果dp[i+1][j+1]=='*',即p[j]==‘*’，那么有两种情况
                         * 1.dp[i+1][j-1],即‘*’表示忽略前一位，即dp[i+1][j+1]和dp[i+1][j-1]同状态
                         * 2.即‘*’的前一位能跟s[i]匹配(p[j-1]==s[i])，则‘*’表示1~n，
                         *   或者‘*’的前一位为‘.’（即p[j-1]=='.'）,因为‘.’可表示忽略
                         *   （如果前面已经不匹配了，这里匹配没有意义，故这里要&&dp[i][j+1]）
                         */
                        dp[i+1][j+1]=dp[i+1][j-1]
                                ||(dp[i][j+1]&&(p.charAt(j-1)==s.charAt(i)||p.charAt(j-1)=='.'));
                    }else{
                        /*
                         * 如果dp[i+1][j+1]！='*'，那只有1种情况
                         * 1.即p[j]能跟跟s[i]匹配(p[j]==s[i])
                         *   或者p[j]为‘.’（即p[j]=='.'）,因为‘.’可表示忽略
                         *   （同样如果前面已经不匹配了，这里匹配没有意义，故这里要&&dp[i][j]）
                         */
                        dp[i+1][j+1]=dp[i][j]&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.');
                    }
                }
            }
            //返回结果，因为dp[i][j],表示s的前i个字符能否跟p的前j个字符相匹配
            //故返回s.length()和p.length()，即为全匹配结果
            return dp[s.length()][p.length()];
        }
    }
}
