package java.t100_t199.t170_t179;

public class T171 {
    class Solution {
        public int titleToNumber(String s) {
            //这题跟168相似，建议放在一起做
            //将字母A~Z转换为1~26
            //这里注意，A=A-A+1=1,即将字母-A后要记得加一
            //存放结果
            int res = 0;
            //遍历字符串
            for (int i = 0; i < s.length(); i++)
                //26进制，记得加一
                res = res * 26 + (s.charAt(i) - 'A' + 1);
            //返回结果
            return res;
        }
    }
}
