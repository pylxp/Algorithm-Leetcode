package java.t1_t10;

public class T4 {
    class Solution {
        private int[] nums1;
        private int[] nums2;

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //提取为全局变量
            this.nums1 = nums1;
            this.nums2 = nums2;
            //求两个有序数组的中位数，实则可以转换为求第 target（中位数）小的数
            //如果总长度是奇数，则left=right=中位数索引，如果是偶数，则left=中位数的左索引，right=中位数的右索引
            int left = (nums1.length + nums2.length + 1) / 2;
            int right = (nums1.length + nums2.length + 2) / 2;
            return ((getRes(0, nums1.length - 1, 0, nums2.length - 1, left)
                    + getRes(0, nums1.length - 1, 0, nums2.length - 1, right)) * 0.5);

        }

        //提取方法，求第 target大的数，即分别取target/2个数，比较去除小的那部分，同时更新 target=target/2
        //start,end分别表示两个数组的起始和末尾索引
        private int getRes(int start1, int end1, int start2, int end2, int target) {
            //获取两个数组的剩余长度
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            //如果其中一个数组为空，则可直接从另一个非空数组获取值
            if (len1 == 0) return nums2[start2 + target - 1];
            if (len2 == 0) return nums1[start1 + target - 1];
            //当 target 变为 1时，则两个数组中的最小值即为结果
            if (target == 1) return Math.min(nums1[start1], nums2[start2]);
            //获取下次遍历的起始位置
            int update1 = start1 + Math.min(len1, target / 2) - 1;
            int update2 = start2 + Math.min(len2, target / 2) - 1;
            //去除小的那部分数组
            if (nums1[update1] > nums2[update2]) {
                return getRes(start1, end1, update2 + 1, end2, target - (update2 - start2 + 1));
            } else {
                return getRes(update1 + 1, end1, start2, end2, target - (update1 - start1 + 1));
            }
        }
    }
}
