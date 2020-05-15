package java.t1_t99.t80_t89;

public class T81 {
    class Solution {
        public boolean search(int[] nums, int target) {
            //这题是33的拓展，建议放在一起做
            //有序数组中查找一个值，典型的二分查找算法
            //无论怎么旋转，改变的只是二分的判定，本质还是个有序数组
            //根据二分查找法，先建立三个索引
            int left = 0, right = nums.length - 1, mid = 0;
            //当left>right,则表明不存在该值
            while (left <= right) {
                //中间索引计算
                mid = (right + left) / 2;
                //找到了则直接返回
                if (nums[mid] == target) return true;
                //去掉左边的重复数,因为这步的存在，实际只能算是个伪二分查找法
                if (nums[left] == nums[mid]) {
                    left++;
                    continue;
                }
                //目标中值大于左值，则表明这一段连续，mid为前半段最大值
                if (nums[mid] > nums[left]) {
                    //如果目标值大于左值，小于中值，则表明在左半段大值区间
                    if (target >= nums[left] && target < nums[mid])
                        right = mid - 1;
                        //不在这个区间，则去后半段小值区间查找
                    else left = mid + 1;
                }
                //如果这一段并不连续,则表明已经发生了旋转
                else {
                    //如果大于中值，小于右值，则表明在右半段小值区
                    if (target > nums[mid] && target <= nums[right])
                        left = mid + 1;
                        //否则则表明在左半段大值区间
                    else right = mid - 1;
                }
            }
            //到这就表明找不到了，返回-1
            return false;
        }
    }
}
