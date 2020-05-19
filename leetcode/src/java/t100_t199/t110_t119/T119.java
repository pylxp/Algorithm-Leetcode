package java.t100_t199.t110_t119;

public class T119 {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            //这题可以算是118的进阶，建议放在一起做
            //要求算法的时间复杂度为O(k)
            //参考上一题我们需要的是遍历前rowIndex层
            //而这题只需要返回第rowIndex层，所以每层都可以在前一层的基础上修改
            //即倒序遍历，则每次的结果都为上一层的当前格加上前一格的结果
            // 即nums[i]=nums[i]+nums[i-1]
            //这里有个坑，即第rowIndex层，实际上是第rowIndex+1层,从0开始计数


            int[] nums = new int[rowIndex + 1];
            List<Integer> res=new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++) {
                //首尾都为1
                nums[i] = 1;
                //倒序遍历，即每一层都为上一层的两位相加
                for (int j = i - 1; j > 0; j--) nums[j] += nums[j - 1];
            }
            //格式转换并返回
            for (int num : nums) res.add(num);
            return res;
        }
    }
}
