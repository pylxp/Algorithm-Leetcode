package java.t11_t20;

public class T18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            //这题和15/16差不多，建议一起做
            //第一步，创建需要返回的结果
            List<List<Integer>> res = new ArrayList<>();
            //为了求四元组，解题思路参考15题三元组，先排序便与求和
            Arrays.sort(nums);
            //提取数组长度，便于后续遍历
            int len = nums.length;
            //不同于三元组的定1(i)，动2(left=i+1)，3(right=nums.length-1)
            //那么换个思路，定1(i)，联动2(j=i+1)，动3(left=j+1)，4(right=nums.length-1)
            //当i=nums.length-4时，即为最后四个数相加了，不用再往后,同时过滤了nums.length<4的情况
            for (int i = 0; i < len - 3; i++) {

                //当前最小和大于target,则无需继续遍历
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                    break;
                //同理，当前最大和小于target,则无需继续遍历
                //这里是continue，因为最大值随着i变大而变大
                if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
                    continue;
                //同值无需重复遍历
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;

                for (int j = i + 1; j < len - 2; j++) {

                    //当前最小和大于target,则无需继续遍历
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                        break;
                    //同理，当前最大和小于target,则无需继续遍历
                    //这里是continue，因为最大值随着j变大而变大
                    if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target)
                        continue;
                    //同值无需重复遍历
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;

                    //分别指向剩余未遍历数的最小(左)和最大(右)值
                    int left = j + 1, right = nums.length - 1;

                    while (left < right) {
                        //求和
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        //判断target,则增加值，及left右移+1，同时去重
                        if (sum < target)
                            while (left < right && nums[left] == nums[++left]) ;
                            //判断target,则减少值，及right左移-1，同时去重
                        else if (sum > target)
                            while (left < right && nums[right] == nums[--right]) ;
                            //那就只剩下符合sum==target的情况了
                        else {
                            //加入结果列表
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            //去重，同时分别移动一格
                            //因为到了这，i/j都是不变的
                            //那么left/right两个数不一起变，不可能出现新的四元组
                            while (left < right && nums[left] == nums[++left]) ;
                            while (left < right && nums[right] == nums[--right]) ;
                        }
                    }
                }
            }
            return res;
        }
    }
}
