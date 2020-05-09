package src.java.t60_t69;

public class T65 {
    class Solution {
        public boolean isNumber(String s) {
            //跟第10题类似，建议放在一起做
            //有效数字问题，实际可以理解为正则匹配问题

            //第一步，先排除有效空格，即首尾空格
            //同时为了方便遍历，转换为字符数组
            char[] ch = s.trim().toCharArray();
            //即表示字符串为空或者全是空格,直接返回false
            if (ch.length == 0) return false;
            //分析可知，合法符号大概分四种
            //1.数字'0~9' 2.正负号'+-' 3.小数点'.' 4.指数'e'
            //建立对应的标志位,默认都为-2，即未出现过
            //这里是个坑(.1和1.都为true,所以标志为-1还得处理特殊情况)
            int num = -2, flag = -2, dot = -2, e = -2;
            //遍历字符数组
            for (int i = 0; i < ch.length; i++) {
                //由于合法情况比较多，所以判断不合法情况即可

                //数字，则标记最后一个数字的索引
                if (ch[i] >= '0' && ch[i] <= '9') num = i;
                    //正负号
                else if (ch[i] == '+' || ch[i] == '-') {
                    //不合法情况分析
                    //1.不是位于开头且不是e的前一位
                    //2.位于最后一位
                    if ((i != 0 && e != i - 1) || i == ch.length - 1) return false;
                    //记录正负号的索引
                    flag = i;
                }
                //小数点
                else if (ch[i] == '.') {
                    //这里是个坑(.1和1.都为true)
                    //不合法情况分析
                    //1.不在数字后同时后面没有数
                    //2.出现第二次
                    //2.位于指数符号e后
                    if ((num != i - 1 && i == ch.length - 1) || e != -2 || dot != -2) return false;
                    //记录小数点索引
                    dot = i;
                }
                //指数符号e
                else if (ch[i] == 'e') {
                    //不合法情况分析
                    //1.指数符号出现第二次
                    //2.前面没有数字
                    //3.位于最后一位
                    if (e != -2 || num == -2 || i == ch.length - 1) return false;
                    //记录指数符号e索引
                    e = i;
                }
                //其他非法符号，一律返回false
                else return false;
            }
            //到这里则表示通过非法检测，返回true
            return true;
        }
    }
}
