package src.java.t60_t69;

public class T67 {
    class Solution {
        public String addBinary(String a, String b) {
            //字符串二进制求和，这题和66相似，建议放在一起做

            //创建res用于拼接计算结果
            //用StringBuilder存储优势
            //1.比String不可变字符串更省内存
            //2.不考虑安全的情况，比StringBuffer性能更高
            StringBuilder res = new StringBuilder();
            //分别用于指向两个字符串的末尾索引
            int aIndex = a.length() - 1, bIndex = b.length() - 1;
            //分别表示进位标志，a的值，b的值
            int carry = 0, aValue = 0, bValue = 0;
            //逆序遍历两个字符串
            while (aIndex >= 0 || bIndex >= 0) {
                //分别获取a、b的值
                aValue = aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;
                bValue = bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;
                //求和，记得加上进位
                int sum = aValue + bValue + carry;
                //2进制，所以对2取模，拼接结果，这里可以把2设置成一个常量，用于不同进制
                res.append(sum % 2);
                //计算进位
                carry = sum / 2;
                //索引前移
                aIndex--;
                bIndex--;
            }
            //如果有进位则添加
            res.append(carry == 1 ? carry : "");
            //由于是从低位开始拼接的，所以不能忘了翻转
            return res.reverse().toString();
        }
    }
}
