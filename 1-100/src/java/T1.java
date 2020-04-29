package java;

public class T1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            //采用HashMap是为了提高数值的读取效率
            // 数值作为key，索引作为value
            Map<Integer, Integer> map = new HashMap<>();
            //要求两数相加等于目标数，那么必然需要通过遍历得知拥有的数字
            for (int i = 0; i < nums.length; i++) {
                //简化题目，由A+B=C => B=C-A
                int temp = target - nums[i];
                //这里是重点，先确认是否已经满足题意，包含B=C-A
                if (map.containsKey(temp)) {
                    //如果满足题目，则直接返回结果，不用put进入，可以避免同值覆盖
                    return new int[]{map.get(temp), i};
                }
                //如果不满足题目，再将值PUT进去，这样可以避免同值覆盖
                map.put(nums[i], i);
            }
            //不满足则返回null
            return null;
        }
    }
}
