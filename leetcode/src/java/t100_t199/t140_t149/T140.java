package java.t100_t199.t140_t149;

public class T140 {
    class Solution {
        //提取为全局变量，方便调用
        //存放结果列表
        List<String>[] res;
        //复制单词表，便于contains查找
        HashSet<String> wordSet;

        public List<String> wordBreak(String s, List<String> wordDict) {
            //这题跟139相似，建议放在一起做
            //区别只在于要返回拼接的结果列表
            //判断字符串s能否拆分为wordDict中出现的单词
            //根据题目要求，拆分时可以重复使用字典中的单词
            //同时字典中没有重复的单词
            //即aba可以拆分为a、b、a 匹配a、b
            //那么根据单词拆分的性质不难发现，拆分只能从前往后
            //那么可以通过假设拆分s，来检查前面的字符能否被匹配完
            //即如果0~i可以被匹配，i~s.length也可以被匹配，则表示拆分成立
            //同时，如果0~i可以被匹配，那么乘上i~s.length的匹配情况即为总的匹配结果

            //初始化结果列表
            res = new ArrayList[s.length() + 1];
            //复制单词表
            wordSet = new HashSet<>(wordDict);
            //调用递归方法
            return recursive(0, s);
        }

        //遍历方法
        public List<String> recursive(int start, String s) {
            //先设立终止条件，即创新新列表
            if (res[start] == null) res[start] = new ArrayList<>();
            //遍历字符串，拼接链表
            for (int i = start; i < s.length(); i++) {
                //如果后面的字符已经遍历拼接了，则跳过
                if (res[i + 1] != null && res[i + 1].isEmpty()) continue;
                //截取分割串
                String word = s.substring(start, i + 1);
                //如果单词表包含，即匹配的情况
                if (wordSet.contains(word)) {
                    //同时如果还没遍历完
                    if (i + 1 != s.length()) {
                        //那么截取判断后面剩余的字符有多少种拼接情况
                        if (res[i + 1] == null) res[i + 1] = recursive(i + 1, s);
                        //拼接后面的各种情况
                        for (String temp : res[i + 1]) res[start].add(word + " " + temp);
                    }
                    //如果遍历完了，直接添加进列表即可
                    else res[start].add(word);
                }
            }
            //返回结果
            return res[start];
        }
    }
}
