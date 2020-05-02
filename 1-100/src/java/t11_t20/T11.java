package java.t11_t20;

public class T11 {
    class Solution {
        public int maxArea(int[] height) {
            //left，right分别表示左右隔板索引,res表示水量
            int left = 0, right = height.length - 1, res = 0;
            //循环遍历，直到left>=right则表示遍历完成
            while (left < right) {
                //用于水量取决于短的那块板，所以每次遍历，去除短板，能使结果尽可能更大
                //如果left隔板小于right隔板，则水量等于隔板数量（right-left）*（heifht[left]）短板长度
                //right隔板小的情况也一样，最后返回原水量res和新水量的（right-left）*（heifht[left]）最大值
                res = height[left] < height[right]
                        ? Math.max(res, (right - left) * height[left++])
                        : Math.max(res, (right - left) * height[right--]);
            }
            //返回结果
            return res;
        }
    }
}
