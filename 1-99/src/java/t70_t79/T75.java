package java.t70_t79;

public class T75 {
    class Solution {
        public void sortColors(int[] nums) {
            //对红白蓝三色进行排序
            //讲的花里胡哨的，实际上就是个排序算法
            //不过题目要求在原地进行排序，那么就不能使用额外的空间
            //综上不能得出以下结论
            //
            //分别建立前后索引
            int left = 0, right = nums.length - 1;
            //临时值，用于交换数值
            int index = 0, temp;
            //遍历两个索引进行对比交换
            while (index <= right) {
                //如果遇到0，从left开始交换
                if (nums[index] < 1) {
                    temp = nums[left];
                    nums[left++] = nums[index];
                    nums[index++] = temp;
                }
                //如果遇到2，从right开始交换
                else if (nums[index] > 1) {
                    temp = nums[right];
                    nums[right--] = nums[index];
                    nums[index] = temp;
                } else index++;
            }
        }
    }
}
