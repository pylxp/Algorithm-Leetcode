package java.t1_t99.t80_t89;

public class T87 {
    class Solution {
        public boolean isScramble(String s1, String s2) {
            //给定一个字符串s1,递归地分割成两个非空子串，可以交换左右子树
            //最后查看s2是否为其中地一种结果
            //其实题目就已经给出了解题算法了
            //1.递归拆分上一级的字符串，左右可以交换
            //2.判断s2是否属于s1的其中一种情况，即s2和s1包含的元素顺序可以不同
            // 但是元素值相同，元素个数相同

            //判断元素值是否相同且个数是否相同，不同则返回false
            if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
            //完全相同直接返回true即可
            if (s1.equals(s2)) return true;
            //由于一共有26个字母，所以可以直接计算包含的元素
            //s1/s2公用一个数组即可，一增一减，保证为0即表示两个字符串的元素组成相同
            int[] list = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                list[s1.charAt(i) - 'a']++;
                list[s2.charAt(i) - 'a']--;
            }
            //如果存在非0，即表示两个字符串元素组成不同，直接返回false
            for (int i = 0; i < 26; i++)
                if (list[i] != 0) return false;
            //递归拆分字符串，每次拆分的同时，左右交换的情况也递归进去，任一情况符合即返回true
            for (int i = 1; i < s1.length(); i++) {
                //正序拆分
                if (isScramble(s1.substring(0, i), s2.substring(0, i))
                        && isScramble(s1.substring(i), s2.substring(i)))
                    return true;
                //左右交换
                if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                        && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                    return true;
            }
            //都不符合则返回false
            return false;
        }
    }
}
