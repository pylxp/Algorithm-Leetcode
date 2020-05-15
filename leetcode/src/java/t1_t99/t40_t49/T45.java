package java.t1_t99.t40_t49;

public class T45 {
    class Solution {
        public int jump(int[] nums) {
            //典型的贪心算法题目，要求最短的步数
            //换个角度看，可以理解为怎么使每步跳的最远
            //注意，这里是指，平均每步跳的最远
            //res记录结果，boundary记录每步能达到的边界，maxStep最大步长
            int res = 0, boundary = 0, maxStep = 0;
            //从头到尾按序遍历
            for (int i = 0; i < nums.length - 1; i++) {
                //找到能到达的格子里，能跳最远的格子
                //每个格子能达到的最远距离，等于自身数值加自身索引
                //例如示例1[2,3,1,1,4],nums[0]=2所能达到的格子只有两个
                //nums[1]=3+1=4,nums[2]=1+2=3;
                //那么无论再往后如何，第一步最优解一定是跳到nums[1]，因为平均起来步长最大
                maxStep = Math.max(maxStep, nums[i] + i);
                //如果达到边界，即当前格子所能达到的所有格子都遍历完了
                if (i == boundary) {
                    //更新边界
                    boundary = maxStep;
                    //步长+1
                    res++;
                }
            }
            //返回结果
            return res;
        }
    }
}
