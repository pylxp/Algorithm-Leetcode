package java.t1_t99.t80_t89;

public class T84 {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            //这题跟11，42相似，建议放在一起做
            //由于矩阵的面积可以最小由单个版(即自身)构成，所以不难得出
            //矩阵面积=(right-left+1)*min(left~right)
            //即板子数*最短板的高度
            //即假设以自身为最短板，那么矩阵面积就等于
            //自身高度*(右边第一个小于自己的板子-左边第一个小于自己的数)
            //根据栈的先进后出特性，能完美的完成以上要求，即按序压入栈，直到遇到比自己小的数，则弹出计算面积
            //存放结果
            int res = 0;
            //创建栈
            Stack<Integer> stack = new Stack<>();
            //复制原数组，在其左右各添加一个0作为边界
            int[] newHeights = new int[heights.length + 2];
            for (int i = 1; i < heights.length + 1; i++) newHeights[i] = heights[i - 1];

            //遍历数组
            for (int i = 0; i < newHeights.length; i++) {
                //遇到比自己小的数，则弹出计算面积
                while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i])
                    res = Math.max(res, newHeights[stack.pop()] * (i - stack.peek() - 1));

                //压入栈
                stack.push(i);
            }
            return res;
        }
    }
}
