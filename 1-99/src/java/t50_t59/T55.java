package src.java.t50_t59;

public class T55 {
    class Solution {
        public boolean canJump(int[] nums) {
            //这题跟45相似，建议放在一起做
            //处理特殊情况
            //如果只有一个数，或者第一个数就超过最大索引，返回true
            if (nums[0] >= nums.length - 1) return true;
            //倒推，有效减少遍历次数
            //记录最后的索引位置
            int end = nums.length - 1;
            //倒着遍历
            for (int i = end - 1; i >= 0; i--) {
                //如果能到达最后的位置，则更新最后位置，减少遍历次数
                if (nums[i] >= end - i) end = i;
            }
            //根据最后第一位能否达到最后索引来判断
            return nums[0] >= end;
        }
    }
}
