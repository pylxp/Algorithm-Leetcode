package java.t1_t10;

public class T5 {
    class Solution {
        public String longestPalindrome(String s) {
            //字符串长度小于等于1，即自身为结果
            if (s.length() <= 1) {
                return s;
            }
            int left = 0;  //中心字符的左边索引
            int right = 0; //中心字符的右边索引
            int len = 1;   //回文串的长度
            int maxStart = 0; //最长回文串的起始索引
            int maxLen = 0; //最长回文串的长度
            //当剩余长度不足最长回文串长度一半，则不需要浪费时间再测了
            for (int mid = 0; mid < s.length()-(maxLen/2); mid++) {
                left = mid - 1; //中心字符的左边索引
                right = mid + 1;//中心字符的右边索引
                //中心扩散算法的三种可能结果，左边left=mid中心，右边right=mid中心，左边left=right右边
                //1.左边索引不越界，即left>=0,同时左边字符等于中心字符
                while (left >= 0 && s.charAt(left) == s.charAt(mid)) {
                    len++;
                    left--;
                }
                //2.右边索引不越界，即right<s.length(),同时右边字符等于中心字符
                while (right < s.length() && s.charAt(right) == s.charAt(mid)) {
                    len++;
                    right++;
                }
                //2.左右索引都不越界，即left>=0 && right<s.length(),同时左边字符等于右边字符
                while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
                    len = len + 2;
                    left--;
                    right++;
                }
                //比较返回最长回文字符串长度和起始索引
                if (len > maxLen) {
                    maxLen = len;
                    maxStart = left+1;
                }
                len = 1;  //重置长度
            }
            //返回结果
            return s.substring(maxStart, maxStart + maxLen);
        }
    }
}
