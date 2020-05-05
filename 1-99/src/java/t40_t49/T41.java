package java.t40_t49;

public class T41 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            //根据题目要求，算法的时间复杂度应为O(n),且只能使用常数级别的额外空间
            //那么这里不能先排序再遍历，否则不合题意
            //因为要找出第一个缺失的正数，那么可以换个思路
            //即1.负数无效，2.超出数组长度的正数也无效
            //首先遍历数组
            for (int i = 0; i < nums.length; i++) {
                //只有数字在1-nums.length才是有效值
                //如果如果该值没有放在正确的位置上，即3应该在nums[2]上
                //则将两个位置的数字进行交换
                while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
            //经过上面的遍历，有效数字已经存在原本该出现的位置上了
            for (int i = 0; i < nums.length; i++) {
                //如果位置上没有出现正确的数，则明显表示缺失
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            //如果一切数字都正确，则确实最大值
            return nums.length + 1;
        }
    }
}
