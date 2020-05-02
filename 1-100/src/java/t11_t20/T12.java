package java.t11_t20;

public class T12 {
    class Solution {
        public String intToRoman(int num) {
            // 数字转换问题，毫无意问，第一步列出转换表
            // 按照从大到小的顺序，方便/10遍历
            // 按照题意4，9，40，90，400，900为特殊情况，一并列入
            int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            //因为要拼接结果，所以在不考虑安全问题的情况下采用StringBuilder
            //比StringBuffer效率更高
            //比String节省内存空间
            StringBuilder res = new StringBuilder();
            //索引下标
            int index=0;
            //num==0代表转换结束
            while (num>0){
                //如果nums大于等于当前索引位对应数值
                //则res拼接，num减去对应值
                if(num>=ints[index]){
                    res.append(strings[index]);
                    num-=ints[index];
                }else {
                    //进入这里表示num小于当前索引位对应数值
                    //则索引加1，向后遍历
                    index++;
                }
            }
            //转换为string输出
            return String.valueOf(res);
        }
    }
}
