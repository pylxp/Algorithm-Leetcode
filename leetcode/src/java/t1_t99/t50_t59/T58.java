package src.java.t50_t59;

public class T58 {
    class Solution {
        public int lengthOfLastWord(String s) {
            //分别指向最后一个单词的头和尾
            int head = 0, tail = s.length() - 1;
            //去除可能存在的空格
            while (tail >= 0 && s.charAt(tail) == ' ') tail--;
            //如果已经到头了，则结果为0
            if (tail < head) return 0;
            //开始遍历最后一个单词
            head = tail;
            //计算有效长度
            while (head >= 0 && s.charAt(head) != ' ') head--;
            //返回结果
            return tail - head;
        }
    }
}
