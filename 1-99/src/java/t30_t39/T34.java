package java.t31_t40;

public class T34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            //有序数组中查找一个值，典型的二分查找算法
            //虽然这题要查找的是一组同值，本质也没啥差别
            //只要根据二分查找法找到目标值，以目标值为中心扩散左右索引即可
            int left = 0, right = nums.length - 1, mid = 0;
            while (left <= right) {
                //计算中值
                mid = left + (right - left) / 2;
                //如果找到了目标值
                if (nums[mid] == target) {
                    int midSub = mid, midAdd = mid;
                    //往左扩散
                    while (midSub > left && nums[midSub - 1] == target) midSub--;
                    //往右扩散
                    while (midAdd < right && nums[midAdd + 1] == target) midAdd++;
                    //返回结果
                    return new int[]{midSub, midAdd};
                }
                //目标值偏大,往右查找
                if (nums[mid] < target) left = mid + 1;
                    //目标值偏小,往左查找
                else right = mid - 1;
            }
            return new int[]{-1, -1};
        }
    }
}
