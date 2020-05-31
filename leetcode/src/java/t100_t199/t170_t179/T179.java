package java.t100_t199.t170_t179;

public class T179 {
    class Solution {
        public String largestNumber(int[] nums) {
            //排列非负数组，使其输出得到最大的拼接数
            //那么根据数字特性，数组拼接长度必然是固定的
            //想要得到最大的拼接数，即首位越大的数字，放在越后
            //到这里不难想到，实际上就是个字符排序问题

            //转换为字符串，便于排序
            String[] str = new String[nums.length];
            for (int i = 0; i < nums.length; i++) str[i] = String.valueOf(nums[i]);
            //排序
            Arrays.sort(str, (x, y) -> (y + x).compareTo(x + y));
            //如果最高位是0，返回0
            if (str[0].equals("0")) return "0";
            //用于拼接结果集
            StringBuilder res = new StringBuilder();
            //拼接
            for (String s : str) res.append(s);
            //转换为字符串输出
            return res.toString();
        }
    }
}
