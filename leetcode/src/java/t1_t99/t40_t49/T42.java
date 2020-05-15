package java.t1_t99.t40_t49;

public class T42 {
    class Solution {
        public int trap(int[] height) {
            //类似11题，建议一起做
            //经过测试，这种解法远快于单调栈，这里就不做过多展开了
            //接水问题，这题的难点就在于，接水在于三个板决定，而不是两个板
            //那么我们可以先遍历，从而得到，每个节点的左右最大值分别为多少
            //再由两个最长板中的短板减去自身则为容量
            //如3，1，4，容易为min（3，4）-1=2;
            //存放每个节点的最边最大值
            int[] left = new int[height.length];
            //存放每个节点的右边最大值
            int[] right = new int[height.length];
            //遍历记录每个节点的左边做大值
            for (int i = 1; i < height.length; i++) {
                left[i] = Math.max(left[i - 1], height[i - 1]);
            }
            //遍历记录每个节点的右边做大值
            for (int i = height.length - 2; i >= 0; i--) {
                right[i] = Math.max(right[i + 1], height[i + 1]);
            }
            //最大水量
            int res = 0;
            //遍历每个节点的水量
            for (int i = 0; i < height.length - 1; i++) {
                //却决于左右最大值中的小值
                int min = Math.min(left[i], right[i]);
                //减掉自身的值，这个是重点容易忽略
                //之所以要与0取最大值，是因为可能该节点超过min，导致的负数结果
                res += Math.max(0, min - height[i]);
            }
            return res;
        }
    }
}
