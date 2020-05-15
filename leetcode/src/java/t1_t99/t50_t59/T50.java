package java.t1_t99.t50_t59;

public class T50 {
    class Solution {
        public double myPow(double x, int n) {
            //这道题本质就是个乘法运算，思路不难
            //要注意的是，先将n的几种特殊情况处理下
            //1.n==0或者x==1,任何数的0次方和1的任何次方都为1
            if (n == 0 || x == 1) return 1.0;
            //2.n<0,先x=>1/x,再把n=>-n,方便运算
            //注意用long型取反，否则可能溢出
            //Integer.MIN_VALUE绝对值比Integer.MAX_VALUE大1
            long N = n;
            if (n < 0) {
                N = -n;
                x = 1 / x;
            }
            //根据乘法的性质，a^b+a^c=a^(b+c)
            //所以这里可以采用快速幂的算法，也可以理解为分治
            return fastPow(x, N);
        }

        public double fastPow(double x, long n) {

            //先设置终止条件，即任何数的0次方都为1
            if (n == 0) return 1.0;
            //进行对半递归，可以理解为分治
            double halfValue = fastPow(x, n / 2);
            //实际运算部分
            //如果是偶数，则刚好对半，返回值的平方即为结果
            if (n % 2 == 0) return halfValue * halfValue;
                //如果是奇数，则要在平方的基础上多乘一次
            else return halfValue * halfValue * x;
        }
    }
}
