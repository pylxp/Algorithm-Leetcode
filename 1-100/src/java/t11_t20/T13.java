package java.t11_t20;

public class T13 {
    class Solution {
        //这题跟上一题相反，有点好玩，建议一起做
        public int romanToInt(String s) {
            //res用于拼接转换结果，temp用于存放临时值
            int res = 0, temp = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                //存放临时值，处理双字符情况
                temp = getValue(s.charAt(i));
                //如果前一位小于后一位，则减前加后，如IX,-10+100=90
                //这里不用考虑最后一位溢出的情况，因为上面循环条件已经设定 i<s.length()-1
                if (temp < getValue(s.charAt(i + 1))) {
                    res -= temp;
                } else {
                    res += temp;
                }
            }
            //补上最后一位的值
            res += getValue(s.charAt(s.length() - 1));
            return res;
        }

        private int getValue(char ch) {
            //这里之所以不用hashMap，是因为两种都试过了，这个更快
            //这里取个巧，为了便于取值计算，去掉双字符特殊情况，采用对比减法
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }
    }
}
