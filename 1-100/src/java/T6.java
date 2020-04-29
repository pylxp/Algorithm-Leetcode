package java;

public class T6 {
    class Solution {
        public String convert(String s, int numRows) {
            //如果只要求输出一行，或者字符串s的长度小于等于1，贼直接返回s即为结果
            if (numRows ==1 || s.length()<=1) return s;
            //由于需要改变字符串，所以不能使用String字符串，容易造成内存浪费
            //StringBuilder和StringBuffer都是可变长字符串，在不考虑安全的情况下，StringBuilder性能更高
            List<StringBuilder> rows = new ArrayList<>();
            //建立numRows个StringBuilder存储
            for (int i = 0; i < numRows; i++)
                rows.add(new StringBuilder());
            //indexRow表示当前所在行数索引
            //标志位，flag为1时，indexRow向下递增，为-1时，indexRpw向上递减
            int indexRow = 0,flag = -1;
            //遍历字符串
            for (char c : s.toCharArray()) {
                //在indexRow行插入字符
                rows.get(indexRow).append(c);
                //当indexRow在第一行时，或者indexRow在最后一行时，反转flag标志位
                if (indexRow == 0 || indexRow == numRows - 1) flag = -flag;
                //flag为true时，indexRow向下递增，flag为false时，indexRow向上递减
                indexRow += flag;
            }
            //创建res拼接最终结果
            StringBuilder res = new StringBuilder();
            //遍历拼接每一行
            for (StringBuilder row : rows) res.append(row);
            //以字符串的格式输出结果
            return res.toString();
        }
    }
}
