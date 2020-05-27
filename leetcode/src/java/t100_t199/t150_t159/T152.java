package java.t100_t199.t150_t159;

public class T152 {
    class Solution {
        public int maxProduct(int[] nums) {
            //找出数组中乘积最大的连续子数组
            //即根据乘法的特性，要是结果越来越大，只有三种可能
            //1.正数乘以正数 2.负数乘以负数 3.自身
            //且求连续子数组的最大乘积，即每个数的最大乘积都受前边乘积的影响
            //那么这里可以采用动态规划的思想，同时维持前i个数的最大值和最小值
            //为了节省内存，这里直接将nums作为动态数组使用即可

            //先处理特殊情况
            if (nums == null || nums.length == 0) return 0;
            //初始化结果和最大最小值
            int res = nums[0];
            int max = nums[0];
            int min = nums[0];
            //遍历数组
            for (int i = 1; i < nums.length; i++) {
                //计算最大值和最小值
                //计算三种情况中的最大值，1.当前数乘以最大值/2.当前数乘以最小值/3.自身
                int tempMax = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
                int tempMin = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
                //更新最大值结果和前i个数的最大值最小值
                res = Math.max(res, tempMax);
                max = tempMax;
                min = tempMin;
            }
            //返回结果
            return res;
        }
    }
}
