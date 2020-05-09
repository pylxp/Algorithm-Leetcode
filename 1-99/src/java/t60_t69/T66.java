package src.java.t60_t69;

public class T66 {
    class Solution {
        public int[] plusOne(int[] digits) {
            //按照题意，数组按序顺访高位到低位
            //那么加1，实际上就是从最低位开始加，即倒序遍历
            for (int i = digits.length - 1; i >= 0; i--) {
                //最低位加一
                digits[i]++;
                //对10取模，留下余数
                digits[i] %= 10;
                //如果余数不为0，则证明没有进位，则遍历结束
                if (digits[i] != 0) return digits;
            }
            //走到这里则表明，上面的遍历都有进位，即为（9，99，999...）等数组
            //那么就要创建一个长度+1的数组，第一位设为1即可，因为数组值默认为0，后面不用设值
            digits = new int[digits.length + 1];
            //第一位设为1，即最高位
            digits[0] = 1;
            //返回结果
            return digits;
        }
    }
}
