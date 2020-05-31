package java.t100_t199.t170_t179;

public class T172 {
    class Solution {
        public int trailingZeroes(int n) {
            //返回阶乘后尾数0的个数
            //那么要先明白，阶乘产生0的情况
            //只有一种，即每乘以一个10，尾数0加一
            //而10的由来只有一种情况2*5
            //那么等同于说，每出现一个5，尾数0加一

            //存放结果
            int res = 0;
            //计算5的个数
            while (n > 0) {
                res += n / 5;
                n /= 5;
            }
            //返回结果
            return res;
        }
    }
}
