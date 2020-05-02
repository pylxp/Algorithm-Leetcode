package java.t1_t10;

public class T7 {
    class Solution {
        public int reverse(int x) {
            //存放结果
            int res = 0;
            //循环遍历反转 x 每一位
            while (x != 0) {
                //求余取模，即高低位反转
                int mod = x % 10;
                //当x大于最大值 2147483647溢出，或者小于最小值 -2147483648溢出时，返回0
                //因为res到后面还要乘以10，所以当res在这已经大于（Integer.MAX_VALUE / 10）
                //或者等于（Integer.MAX_VALUE / 10）同时余数超出7，则表示反转后溢出，负数同理
                if ((res > Integer.MAX_VALUE / 10)
                        || (res == Integer.MAX_VALUE / 10 && mod > 7)
                        || (res < Integer.MIN_VALUE / 10)
                        || (res == Integer.MIN_VALUE / 10 && mod < -8))
                    return 0;
                //拼接结果
                res = res * 10 + mod;
                x /= 10;
            }
            //返回结果
            return res;
        }
    }
}
