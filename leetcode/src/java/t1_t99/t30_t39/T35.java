package java.t31_t40;

public class T35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            //这题跟33，34相似，建议放在一起做
            //有序数组中查找一个值，典型的二分查找算法
            //只要根据二分查找法找到目标值，该索引及为值所在索引或者该插入的索引
            int left = 0, right = nums.length - 1, mid = 0;
            while (left <= right) {
                //计算中值
                mid = left + (right - left) / 2;
                //如果找到了目标值,直接返回即可
                if (nums[mid] == target) {
                    return mid;
                }
                //目标值偏大,往右查找
                if (nums[mid] < target) left = mid + 1;
                    //目标值偏小,往左查找
                else right = mid - 1;
            }
            //到这表明没找到目标值，但是也找到了最接近的值
            //如果该值大于目标值，则该位置即为插入位置
            //如果该值小于目标值，后一位即为插入位置
            return (nums[mid] > target) ? mid : mid + 1;
        }
    }
}
