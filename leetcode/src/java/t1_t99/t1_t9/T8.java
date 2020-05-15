package java.t1_t10;

public class T8 {
    class Solution {
        public static int myAtoi(String str) {
            //遍历字符串的索引位
            int index = 0;
            //去除前置无效空格,后面再出现的空格都无效
            while (index < str.length()&&str.charAt(index) == ' ') {
                index++;
            }
            //如果已经为空了，返回0即可
            if (index == str.length()) {
                return 0;
            }
            //设立正负号标志位,为了方便理解，默认为 1表示正，-1表示负
            int flag = 1;
            if (str.charAt(index) == '+') {
                flag = 1;
                index++;
            } else if (str.charAt(index) == '-') {
                flag = -1;
                index++;
            }
            //不是+/-/0-9的，都视为不合理，返回0即可
            else if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                return 0;
            }
            //拼接返回结果
            int res = 0;
            //接下来除了出现数字，其他字符都是不合理的，停止拼接
            while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                //读取每一位的值
                int mod = str.charAt(index) - '0';
                //判断有无越界溢出,正2147483647,负-2147483648
                if (res > (Integer.MAX_VALUE - mod) / 10) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + mod;
                index++;
            }
            //若无溢出，直接返回结果
            return flag * res;
        }
    }
}
