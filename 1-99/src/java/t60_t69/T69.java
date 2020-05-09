package src.java.t60_t69;

public class T69 {
    class Solution {
        public int mySqrt(int x) {
            //求平方根，那么实际上就等同于a^2=x,求a
            //1.实际上最快的方法肯定是取巧 a^2^0.5,即通过指数运算开方
            //2.牛顿迭代法，涉及数值分析和高数内容，考虑受众水准不一，这里不做展开
            //3.实际面试中，一般面试官也不会为了考察以上两种，更多考察下面这种，即二分法
            //计算返回x的平方根
            //换个角度看，就等于在0~x中查找到最大的i值(i*i<=x)
            //所以同样可以采用二分法，将题目理解为数组0~x中查找i

            //先处理特殊情况
            if (x <= 1) return x;
            //分别指向左右中索引，以及结果
            int left = 0, right = x, mid = 0, res = 1;
            //遍历
            while (left <= right) {
                //计算中值索引
                mid = left + (right - left) / 2;
                //防止溢出，采用除法
                if (mid == x / mid) return mid;
                //还未找到最大值，则更新结果并且往右遍历
                if (mid < x / mid) {
                    res = mid;
                    left = mid + 1;
                }
                //超出不更新结果，往左遍历
                else right = mid - 1;
            }
            //返回结果
            return res;
        }
    }
}
