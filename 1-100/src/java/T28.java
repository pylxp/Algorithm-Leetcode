package java;

public class T28 {
    class Solution {
        public int strStr(String haystack, String needle) {
            //字符串匹配，目前算法很多，BM/KMP/Sunday等等
            //试了各种方法，最后这个反而性能更高，测试用例问题
            //故在这里不展开其他算法了
            //由于haystack要包含needler，所以短于needler的尾部不用遍历
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                //如果相等返回，不等则往后
                if (haystack.substring(i, i + needle.length()).equals(needle))
                    return i;
            }
            //到这里则表示不相等了，返回-1
            return -1;
        }
    }
}
