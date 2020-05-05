package java.t1_t10;

public class T9 {
    class Solution {
        //由于题目声明了不能使用字符串，这里不考虑转换字符串
        public boolean isPalindrome(int x) {
            //负数，末尾为0的负0整数都肯定不是回文串
            if(x<0||(x!=0&&x%10==0)) return false;
            //存放翻转后的数
            int res = 0;
            //由于是对比翻转，实际只需折中取半对比即可
            while(x > res) {
                res = res * 10 + x % 10;
                x /= 10;
            }
            // 偶数如123321，处理完即为123==123
            // 奇数如12321，处理完即为12==123/10
            return x == res || x == res/10;
        }
    }
}
