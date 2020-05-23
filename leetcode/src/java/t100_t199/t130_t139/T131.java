package java.t100_t199.t130_t139;

public class T131 {
    class Solution {
        //提取为全局变量，方便调用
        //创建结果集
        List<List<String>> res = new ArrayList<>();
        //创建dp矩阵
        boolean[][] dp;

        public List<List<String>> partition(String s) {
            //这里跟5类似，建议放在一起做
            //分割回文串，那么实际上难点还是在于判断回文
            //题目要求所有的可能组合
            //那么回文串的长度既是不固定的，即没遍历到一个字符，都可能产生新的回文串
            //那么可以使用动态规划，即dp[i][j]来标志从第i-j个字符能否组成回文串
            //然后再遍历dp矩阵得出所有的可能结果

            //获取字符串长度
            int len = s.length();
            //初始化dp矩阵
            dp = new boolean[len][len];
            //固定末尾字符
            for (int i = 0; i < len; i++)
                //往前遍历判断是否会产生新的回文串
                for (int j = 0; j <= i; j++)
                    //首尾相等，同时中间不足2个字符，或者中间已经是回文串，则必然为新的回文串
                    if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) dp[j][i] = true;
            //调用方法拼接结果集
            dfs(0, len, s, new ArrayList<String>());
            //返回结果
            return res;

        }

        /*
         * i 遍历到第i个字符
         * n 字符串总长度
         * s 待遍历的字符串
         *
         */
        public void dfs(int i, int len, String s, ArrayList<String> temp) {
            //先设立终止条件
            if (i == len) res.add(new ArrayList<>(temp));
            //从第i个字符往后继续遍历
            for (int j = i; j < len; j++) {
                //如果是回文串，则添加
                if (dp[i][j]) {
                    temp.add(s.substring(i, j + 1));
                    //往后继续遍历拼接
                    dfs(j + 1, len, s, temp);
                    //回溯是要删除上一次添加的结果
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
