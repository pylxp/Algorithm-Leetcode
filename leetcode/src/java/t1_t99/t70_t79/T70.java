package src.java.t70_t79;

public class T70 {
    class Solution {
        public int climbStairs(int n) {
            //爬楼梯，采用递归很容易超时，这里采用动态规划更优
            //仔细观察不能得出以下结论
            //1.f(1)=1,f(2)=2
            //2.f(3)=f(1)+f(2)=3
            //3.f(4)=f(3)+f(2)=f(1)+f(2)+f(2)=5
            //即n>=3,f(n)=f(n-1)+f(n-2)
            //为了方便，将f(0)=0加入

            //先处理特殊情况
            if (n <= 2) return n;
            //建立动态规划数组，多了f(0),所以长度为n+1
            int[] dp = new int[n + 1];
            //初始化特殊值，dp[0]默认为0，不用设置
            dp[1] = 1;
            dp[2] = 2;
            //往后遍历
            for (int i = 3; i <= n; i++)
                dp[i] = dp[i - 1] + dp[i - 2];
            //返回结果
            return dp[n];
        }
    }
}
