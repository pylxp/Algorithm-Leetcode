package java.t31_t40;

public class T38 {
    class Solution {
        public String countAndSay(int n) {
            //由于需要拼接结果字符串,所以选用StringBuilder
            //1.比使用String不可变字符串更省内存
            //2.不考虑安全性的前提下，比StringBuffer性能更高
            StringBuilder res = new StringBuilder();
            //pre指向字符串前位，post指向后位
            int pre = 0, post = 1;
            //如果n==1,即表示递归到底了,直接返回即可
            if (n == 1) {
                return "1";
            }
            //根据题目性质，递归到底，即n=1,才能得到后面的结果
            String tempRes = countAndSay(n - 1);
            //只需要动后面的索引开始遍历返回的字符串即可
            for (post = 1; post < tempRes.length(); post++) {
                //前后位不同，则开始拼接
                if (tempRes.charAt(pre) != tempRes.charAt(post)) {
                    //拼接重复个数，再拼接对应的字符
                    res.append(post - pre).append(tempRes.charAt(pre));
                    //更新前后索引
                    pre = post;
                }
            }
            //如果pre!=post,则存在最后的字符相等，添加到末尾
            if (pre != post) {
                //拼接重复个数，再拼接对应的字符
                res.append(post - pre).append(tempRes.charAt(pre));
            }
            //返回结果
            return res.toString();
        }
    }
}
