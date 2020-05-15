package java.t1_t99.t40_t49;

public class T43 {
    class Solution {
        public String multiply(String num1, String num2) {
            //根据题目要求不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
            //那么只能通过-'0'来将每一位字符转换为数字
            //首先根据乘法的性质，判断特殊情况
            if (num1.equals("0") || num2.equals("0")) return "0";
            //由于可能乘积结果超出越界，所以创建一个数组存放结果
            //假设两个值都为极端情况“999..."，那么最大结果则为num1.length+num2.lenght
            int[] tempRes = new int[num1.length() + num2.length()];
            //number1，number2，分别存放转换的数字，sum存放乘积
            int number1, number2, sum;
            //从最低位开始运算，所以从后往前遍历
            for (int i = num1.length() - 1; i >= 0; i--) {
                //先转换为数字
                number1 = num1.charAt(i) - '0';
                //同上，从最低位开始运算，从后往前遍历
                for (int j = num2.length() - 1; j >= 0; j--) {
                    //同上，先转换为数字
                    number2 = num2.charAt(j) - '0';
                    //重点！退后一位存值，防止i=0,j=0时无法进位
                    tempRes[i + j + 1] += number1 * number2;
                }
            }
            //处理数组
            for (int i = tempRes.length - 1; i >= 0; i--) {
                //处理进位
                if (tempRes[i] > 9) {
                    //往前一位进位
                    tempRes[i - 1] += tempRes[i] / 10;
                    //更新值
                    tempRes[i] = tempRes[i] % 10;
                }
            }
            //开始拼接结果
            //由于要拼接字符串，所以选择StringBuilder
            //1.比String更省内存，2.不考虑安全的情况下比StringBuffer性能更好
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < tempRes.length; i++) {
                //如果第一位进位为0，则忽略跳过
                if (i == 0 && tempRes[i] == 0) continue;
                //按序遍历添加
                res.append(tempRes[i]);
            }
            //转换为String类型返回结果
            return res.toString();
        }
    }
}
