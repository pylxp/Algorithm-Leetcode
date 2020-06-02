package java.t100_t199.t180_t189;

public class T189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            //将数组向右移动k位
            //即等同于，将数组的最后k位移动到数组的最前面
            //那么实际上可以拆分成两部分
            //即1.0~nums.length-1-k 2.nums.length-1-k~nums.length-1
            //那么问题就变成了，怎么把数组2移动到数组1前面
            //但是由于题目要求使用空间复杂度为 O(1) 的 原地 算法
            //所以只能先将整个数组进行翻转
            //即0~nums.length - 1》》nums.length - 1~0
            //拆分两个数组1.0~k-1（原来的nums.length-1-k~nums.length-1）
            //2.k~nums.leng-1(原来的0~nums.length-1-k)
            //再翻转即为结果

            //求余计算，超过长度的部分无效
            k %= nums.length;
            //翻转整个数组
            reverse(nums, 0, nums.length - 1);
            //翻转0~k-1（原来的nums.length-1-k~nums.length-1）
            reverse(nums, 0, k - 1);
            //翻转k~nums.leng-1(原来的0~nums.length-1-k)
            reverse(nums, k, nums.length - 1);
        }

        //翻转数组的方法，传入数组，翻转的索引边界
        public void reverse(int[] nums, int start, int end) {
            //首尾对称翻转数组
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
