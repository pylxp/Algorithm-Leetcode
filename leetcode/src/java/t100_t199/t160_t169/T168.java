package java.t100_t199.t160_t169;

public class T168 {
    class Solution {
        public String convertToTitle(int n) {
            //Excel表格名称，实际上从示例不难看出，就是个26进制转换字母
            //即1~26分别对应A~Z
            //这里有个坑要注意，由于1是A，即正确的计算是（1-1）%26+‘A'=A,即要先减一
            //用于拼接结果
            StringBuilder res = new StringBuilder();
            //26进制转换
            while (n != 0) {
                res.append((char) (--n % 26 + 'A'));
                n /= 26;
            }
            //这里注意翻转才为结果
            return res.reverse().toString();
        }
    }
}
