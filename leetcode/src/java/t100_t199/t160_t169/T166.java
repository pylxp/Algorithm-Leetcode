package java.t100_t199.t160_t169;

public class T166 {
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            //除法计算，循环小数部分放在括号内
            //那么本质上还是个除法问题，难点在于怎么判断哪一部分是循环小数

            //用于拼接结果
            StringBuilder res = new StringBuilder();
            //防止出现越界，转换为long类型
            long a = numerator;
            long b = denominator;
            //拼接正负号
            if (a * b < 0) res.append('-');
            //统一转换为正数处理
            if (a < 0) a = -a;
            if (b < 0) b = -b;
            //先拼接整数部分
            res.append(a / b);
            //每次乘以10，用于计算下一个小数位
            a = 10 * (a % b);
            //如果有小数，则拼接'.'
            if (a != 0) res.append('.');
            //记录小数的索引位
            int index = res.length();
            //用于存储已经出现过的小数，即记录循环
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            //遍历小数部分
            for (; a != 0; a = 10 * (a % b)) {
                //如果是循环的部分，则插入括号并退出遍历即可
                if (map.containsKey(a)) {
                    res.insert(map.get(a), "(");
                    res.append(')');
                    break;
                }
                //往后遍历
                res.append(a / b);
                //放入map记录
                map.put(a, index++);
            }
            //返回结果
            return res.toString();
        }
    }
}
