package java.t21_t30;

public class T27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            //这题跟26相似，建议放在一起做
            //题目要求不能使用额外的数组空间，所以这里不能通过排序偷懒了
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                //如果两数不等i
                if (nums[i] != val) {
                    //res+1表示无重复长度+1，同时在该位置原地替换掉值
                    //题目说了，超出新长度的不用处理
                    //要保证不等于val的数移动到最前面
                    nums[res++] = nums[i];
                }
            }
            //由于上面是替换完+1了，这里就直接返回即可
            return res;
        }
    }
}
