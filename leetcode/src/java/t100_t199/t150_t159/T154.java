package java.t100_t199.t150_t159;

public class T154 {
    class Solution {
        public int findMin(int[] nums) {
            //这题是153的扩展，建议放在一起做
            //找到旋转排序数组中的最小值
            //那么实际上还是等同于在数组中查找一个数
            //那么这里采用二分查找的方法即可，重点在于重复值的解决

            //分别指向数组的左右中索引
            int left = 0, right = nums.length - 1, mid = 0;
            //遍历数组
            while (left < right) {
                //计算中值
                mid = (left + right) / 2;
                //如果中值大于右边值，则表示已经旋转，往右遍历
                if (nums[mid] > nums[right]) left = mid + 1;
                    //如果中值小于右边值，则表示未旋转，往左遍历
                else if (nums[mid] < nums[right]) right = mid;
                    //如果重复，则去除重复值
                else right--;
            }
            //返回结果
            return nums[left];
        }
    }
}
