package java.t1_t99.t80_t89;

public class T88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //合并两个有序数组，且nums1有足够的空间存放元素num2
            //根据以上信息不难得出以下结论
            //1.题目希望我们利用nums1的充足空间，即不创建新的内存空间
            //2.两个数组都是有序，且nums1占据了nums1的前半段空间
            // 那么为了不产生多余的交换，应该从nums1的后半段空间插入
            // 即先比较最大值，从后往前插入即可

            //分别建立两个指向数组末尾的索引
            int index1 = m - 1;
            int index2 = n - 1;
            //指向num1有效长度的最后索引，即m+n-1
            int index = m + n - 1;
            //从后往前比较，直到其中一个为0，则表示其中一个数组遍历完了
            while ((index1 >= 0) && (index2 >= 0))
                nums1[index--] = (nums1[index1] > nums2[index2]) ? nums1[index1--] : nums2[index2--];

            //如果是num1有剩余，不用操作，因为本身就是在num1上操作的
            //如果num2有剩余，则将num2剩余数替换到num1前面一一对应
            //这句调用，是将num2从0~index替换到nums1的0~index
            System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
        }
    }
}
