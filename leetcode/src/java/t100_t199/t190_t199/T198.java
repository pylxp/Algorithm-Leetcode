package java.t100_t199.t190_t199;

public class T198 {
    class Solution {
        public int rob(int[] nums) {
            //相邻两间房不能同时盗窃，求最大值
            //那么实际就是，计算数组的和的最大值（相邻两个数不能同时求和）
            //那么不能得出结论
            //到第n间房的总和无非两种情况
            //1. dp[n]=dp[n-1],即第n-1间房偷了,第n间房不能偷
            //2. dp[n]=dp[n-2]+nums[n],即第n-1间房没偷
            //那么dp[n]=Math.max(dp[n-1],dp[n-2]+nums[n])
            //由于nums[n]直接从数组取值即可
            //即只需要知道两个值dp[n-1],dp[n-2]，即可求得dp[n]
            //也就是说，只需要维持两个变量即可

            //存放结果,即dp[n]
            int res = 0;
            //存放dp[n-2],dp[n-1]
            int last2 = 0, last1 = 0;
            //遍历房间
            for (int num : nums) {
                //保留到前一间房的最大结果
                last1 = res;
                //计算Math.max(dp[n-1],dp[n-2]+nums[n])
                res = Math.max(res, last2 + num);
                //保留到前两间房的最大结果
                last2 = last1;
            }
            //返回结果
            return res;
        }
    }
}
