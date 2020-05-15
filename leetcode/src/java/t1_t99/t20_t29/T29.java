package java.t21_t30;

public class T29 {
    class Solution {
        //题目要求不使用乘法、除法和 mod 运算符。
        //且假设我们的环境只能存储 32 位有符号整数
        //个人认为位运算也是乘法，所以这里不使用
        //那么这里只能采用加减法来解决，
        public int divide(int dividend, int divisor) {
            //先处理几种特殊情况
            //1.dividend==0或者divisor==1，结果都为dividend本身
            if (dividend == 0 || divisor == 1) return dividend;
            //2.只有这一种情况可能溢出,即dividend==Integer.MIN_VALUE
            if (divisor == -1)
                return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
            //先判断结果为正负
            int flag = 1;
            //异或，两个条件只成立一个，则标志位为-1
            if (dividend > 0 ^ divisor > 0)
                flag = -1;
            //由于调用加减法，所以要先同化成负号，才能根据绝对值来加减
            //要同负，不能为正，因为Integer.MIN_VALUE转换为正会溢出
            dividend = dividend > 0 ? -dividend : dividend;
            divisor = divisor > 0 ? -divisor : divisor;
            //调用运算方法并根据正负号返回结果
            return flag > 0 ? div(dividend, divisor) : -div(dividend, divisor);
        }

        public int div(int dividend, int divisor) {
            //用于返回结果
            int res = 0;
            //上面已经处理过了正负问题
            while (divisor >= dividend) {
                //存放临时结果
                int tempRes = 1;
                //采用加减法，故这里要把divisor提取出来当作操作数
                int num = divisor;
                while ((num + num) >= dividend) {
                    //防止越界异常
                    if ((Integer.MIN_VALUE - num) > num) break;
                    //采用翻倍的方法，防止两数相差过大的情况
                    num += num;
                    //上面翻倍加，那么结果自然也是
                    tempRes += tempRes;
                }
                dividend -= num;
                res += tempRes;
            }
            return res;
        }
    }
}
