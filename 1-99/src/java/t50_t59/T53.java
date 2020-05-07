package src.java.t50_t59;

public class T53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            //初始化结果
            int res = nums[0];
            //记录最大值
            int sum = 0;
            //遍历每一个数
            for (int num : nums) {
                //如果前边的和大于0，则往后加
                if (sum > 0) sum += num;
                    //如果前边的和小于等于0，则重新开始计算
                else  sum = num;
                //记录最大值
                res = Math.max(res, sum);
            }
            //返回结果
            return res;
        }
    }
}
