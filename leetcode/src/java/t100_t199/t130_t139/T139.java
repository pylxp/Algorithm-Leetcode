package java.t100_t199.t130_t139;

public class T139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            //判断字符串s能否拆分为wordDict中出现的单词
            //根据题目要求，拆分时可以重复使用字典中的单词
            //同时字典中没有重复的单词
            //即aba可以拆分为a、b、a 匹配a、b
            //那么根据单词拆分的性质不难发现，拆分只能从前往后
            //那么可以通过假设拆分s，来检查前面的字符能否被匹配完
            //即如果0~i可以被匹配，i~s.length也可以被匹配，则表示拆分成立
            //那么可以使用动态规划的方法来完成


            //建立动态规划矩阵，dp[i],表示前i个字符能否被拆分匹配完全
            boolean[] dp = new boolean[s.length() + 1];
            //初始化dp矩阵
            dp[0] = true;
            //遍历字符串s
            for (int end = 1; end <= s.length(); end++) {
                //遍历单词表
                for (String word : wordDict) {
                    //如果有一个单词匹配，即更新dp矩阵同时退出即可
                    int len = word.length();
                    if (end >= len && dp[end - len]
                            && s.substring(end - len, end).equals(word)) {
                        dp[end] = true;
                        break;
                    }
                }
            }
            //返回结果
            return dp[s.length()];
        }
    }
}
