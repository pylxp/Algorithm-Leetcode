package java;

public class T16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            //这题其实换个思维，就跟上题一样了，建议一起做
            //上一题求三元组为0，实际上这题近似于把0换为了target
            //题目要求返回一个int，那就先二话不说创建，顺便可以直接默认为头三个数
            int res=nums[0]+nums[1]+nums[2];
            //同上题，排序便于遍历
            Arrays.sort(nums);
            int len = nums.length;
            //len-2即为最后三个数相加了，没必要再往后
            for (int i=0;i<len-2;i++){
                int left=i+1,right=len-1;
                while (left<right){
                    int sum=nums[i]+nums[left]+nums[right];
                    //如果sum的值就等同于target，那么直接返回sum或target即可了
                    if (sum==target) return sum;
                        //如果结果偏小，则left右移
                    else if(sum<target) left++;
                        //如果结果偏大，则right左移
                    else right--;
                    //只是为了判断那个三元组更接近，所以正负等价
                    if (Math.abs(sum-target)<Math.abs(res-target)) res=sum;
                }
            }
            //返回结果
            return res;
        }
    }
}
