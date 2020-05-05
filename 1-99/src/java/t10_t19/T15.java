package java.t11_t20;

public class T15 {
    class Solution {
        public static List<List<Integer>> threeSum(int[] nums) {
            //题目要求返回一个List<List<Integer>>，二话不说，先创建
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            //三元求和，明显排序有利于查找
            //这题不考察排序，直接调用现有方法即可
            Arrays.sort(nums);
            //既然已经排序完了，毫无疑问最大最小相加，然后遍历补差值即可
            //否则会出现最小（大）的三个数相加的不必要情况
            //len-2即为最后三个数相加了，而且可以过滤len<3的无效情况
            for (int i = 0; i < len-2; i++) {
                //因为nums[i]是三个数中最小的，如果nums[i]大于0，明显不成立
                if (nums[i] > 0) break;
                //题目要求不能重复，两数不变的情况下，第三个数重复，三元组必定重复
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                //left存放最小数索引，right存放最大数索引
                //因为不能重复使用同一个数，i从0开始遍历，所以left从i+1开始
                int left = i + 1, right = len - 1;
                //如果left==right，则同个数重复使用了，明显跳出循环
                while (left < right) {
                    //求和
                    int sum = nums[i] + nums[left] + nums[right];
                    //如果小于0，则表示结果偏小，left右移+1
                    if (sum < 0) left++;
                        //如果大于0，则表示结果偏大，right左移-1
                    else if (sum > 0) right--;
                        //符合三数相加为0的情况
                    else {
                        //加入结果列表
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //题目要求不能重复，那么两数不变的情况，第三个存在的相同数则要去掉
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        //上面已经去重，那么明显left和right都要移动
                        //如果不移动则死循环
                        //如果只移动一个，在两数不变的情况下，不可能和为0再成立
                        left++;
                        right--;
                    }
                }
            }
            return res;
        }
    }
}
