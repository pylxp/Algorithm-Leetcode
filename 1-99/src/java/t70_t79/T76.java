package java.t70_t79;

public class T76 {
    class Solution {
        public String minWindow(String s, String t) {
            //寻找最小覆盖子串
            // 本质上可以理解为寻找子串，外加了几个特殊情况
            // 1.可以包含多余字符
            // 2.尽量包含的多余字符最少
            //因此这里同样适用于滑动窗口的算法，只需要保证左右指针内一直包含t即可

            //先处理特殊情况
            if (s == null || t == null || s.length() < t.length()) return "";

            //统计t中需要的每个字符出现次数
            int[] tNeeds = new int[128];
            for (int i = 0; i < t.length(); i++)
                tNeeds[t.charAt(i)]++;

            //统计滑动窗口中每个字符出现次数
            int[] window = new int[128];

            //用于遍历字符串的左右索引
            int left = 0, right = 0;
            //用于记录最小长度的左右索引
            int resLeft = 0, resRight = 0;

            //记录已匹配的字符数
            int count = 0;
            //记录最短的匹配长度
            int minLength = s.length() + 1;
            //遍历模式串s
            while (right < s.length()) {
                //记录滑动窗口window内已包含字符数
                char ch = s.charAt(right);
                window[ch]++;
                if (tNeeds[ch] > 0 && tNeeds[ch] >= window[ch]) count++;

                //已包含字符数等于长度，则表明所有的字符都已扫描到
                while (count == t.length()) {
                    //从左往右逐步缩短长度，直到不满足题意
                    ch = s.charAt(left);
                    //如果删除的字符是需要的，则匹配数剪1
                    if (tNeeds[ch] > 0 && tNeeds[ch] >= window[ch]) count--;
                    //更新最短长度的索引
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        resLeft = left;
                        resRight = right + 1;
                    }
                    window[ch]--;
                    left++;
                }
                right++;
            }
            //返回结果
            return s.substring(resLeft, resRight);
        }
    }
}
