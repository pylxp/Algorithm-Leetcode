package java.t31_t40;

public class T31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            //获取下一个更大的序列
            //实际上就等同于获取最后面的顺序序列，进行一次交换
            //交换完即为最小逆序序列，再将后面调整为顺序序列，即为题目要求的下一个更大的序列
            //所以这里要逆序遍历,从倒数第二位开始遍历
            for (int i = nums.length - 2; i >= 0; i--) {
                //如果获取到了顺序序列，即前小后大
                if (nums[i] < nums[i + 1]) {
                    //index指向队列尾，开始遍历找到第一个出现的逆序数
                    //从最后开始遍历，找到第一个比逆序数进行交换
                    //得到的即为变化最小的更大序列
                    int index = nums.length - 1;
                    for (; index > i && nums[index] <= nums[i]; index--) ;
                    //交换从后往前的第一个逆序数
                    //调用两两交换方法
                    swap(nums, i, index);
                    //同时要把后面调整为顺序序列，保证最小
                    reverse(nums, i + 1);
                    return;
                }
            }
            //如果走到这里，则表示不存在顺序序列，即原数组为最大值
            //那么返回最小值，题目要求不能额外空间，所以要一一交换
            //调用整个数组翻转的方法
            reverse(nums, 0);
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        public void reverse(int[] nums, int left) {
            int right = nums.length - 1;
            //头尾两两交换
            while (left < right)
                swap(nums, left++, right--);
        }
    }
}
