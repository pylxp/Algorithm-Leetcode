package java.t1_t99.t80_t89;

public class T80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            //根据题意不难看出，实际上难点就只有2个
            //1.怎么判断同个数字出现了几次，这里用count计数
            //2.怎么进行原地交换，这里采用后面覆盖前面的方法

            //记录有效长度和同一个数字出现的次数
            int len=1,count=1;
            //从第二位开始遍历
            for (int i=1;i<nums.length;i++){
                //如果出现重复，次数+1
                if (nums[i]==nums[i-1]) count++;
                    //否则重置次数
                else count=1;
                //如果次数小于等于2，则按照有效长度len覆盖
                if (count<=2) nums[len++]=nums[i];
            }
            return len;
        }
    }
}
