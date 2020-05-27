package java.t100_t199.t150_t159;

public class T153 {
    class Solution {
        public int findMin(int[] nums) {
            //找到旋转排序数组中的最小值
            //那么实际上还是等同于在数组中查找一个数
            //那么这里采用二分查找的方法即可

            //分别指向数组的左右中索引
            int left = 0, right = nums.length - 1, mid = 0;
            //遍历数组
            while (left < right) {
                //计算中值索引
                mid = (left + right) / 2;
                //如果中值大于右边值，则表示已经旋转，往右遍历
                if (nums[mid] > nums[right]) left = mid + 1;
                    //否则往左遍历
                else right = mid;
            }
            //返回结果
            return nums[left];
        }
    }
}
