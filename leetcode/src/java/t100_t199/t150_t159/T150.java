package java.t100_t199.t150_t159;

public class T150 {
    class Solution {
        public int evalRPN(String[] tokens) {
            //逆波兰表达式计算
            //根据实例不难发现，即每次遍历到符号，则将前两个数取出运算
            //那么可以通过栈的特性，遇到符号弹出两个数计算即可，这里采用数组进行模拟
            //由于没遇到一个符号，弹出两个数计算，那么储蓄空间只需要一半即可

            //创建数组模拟栈
            int[] stack = new int[tokens.length / 2 + 1];
            //遍历索引
            int index = 0;
            //遍历tokens，遇到符号则取最后两个数计算
            for (String s : tokens) {
                switch (s) {
                    //后两位相加
                    case "+":
                        stack[index - 2] += stack[--index];
                        break;
                    //后两位相减
                    case "-":
                        stack[index - 2] -= stack[--index];
                        break;
                    //后两位相乘
                    case "*":
                        stack[index - 2] *= stack[--index];
                        break;
                    //后两位除
                    case "/":
                        stack[index - 2] /= stack[--index];
                        break;
                    //往最后面添加
                    default:
                        stack[index++] = Integer.parseInt(s);
                        break;
                }
            }
            //返回计算结果
            return stack[0];
        }
    }
}
