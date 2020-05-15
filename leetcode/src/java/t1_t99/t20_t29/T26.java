package java.t21_t30;

public class T26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            //由于是有序数组，所以直接相邻位比较即可
            int res = 0;
            for (int right = 1; right < nums.length; right++) {
                //如果两数不等
                if (nums[res] != nums[right]) {
                    //res+1表示无重复长度+1，同时在该位置原地替换掉值
                    //题目说了，超出新长度的不用处理
                    //要保证无重复的数移动到最前面
                    nums[++res] = nums[right];
                }
            }
            //由于是返回长度，所以是索引+1
            return res + 1;
        }
    }
}
