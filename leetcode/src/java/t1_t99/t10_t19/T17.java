package java.t11_t20;

public class T17 {
    class Solution {
        //这里提取为全局变量，是为了方便递归调用
        //做题思路第一步，先把要返回的结果创建了。
        List<String> res = new ArrayList<>();
        //用于存放映射字符串
        String[] strings = null;
        public List<String> letterCombinations(String digits) {
            //解题思路第二步，返回无效情况，避免做多于操作
            if(digits.length()<1) return res;
            //先把映射表做好，加了0/1两个空格映射，是方便字符-‘0’取值
            //这里用hashmap也行，为了省略一个put操作而已
            String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            //用于存放映射字符串
            strings=new String[digits.length()];
            //遍历映射表取值
            for (int i = 0; i < digits.length(); i++) {
                //因为映射表添加了0/1两个空字符串占位，这里直接减‘0’即可
                strings[i]=map[digits.charAt(i)-'0'];
            }
            //由于要拼接字符串，这里优先选用StringBuilder
            //1.比String省内存 2.不考虑安全性问题，比StringBuffer性能更好
            StringBuilder sb = new StringBuilder();
            dfs(0,sb);
            return res;
        }
        public void dfs(int index,StringBuilder sb){
            //及表示遍历到底，加入res列表即可
            if (index==strings.length){
                res.add(sb.toString());
                return;
            }
            //strings[index].length()获取当前索引位字符对应的映射字母数量
            //7/9特殊，有4位，其余为3位
            for (int i = 0; i < strings[index].length(); i++) {
                //注意，是深度优先，再回溯strings[index].charAt(i))获取单个字母
                dfs(index+1,sb.append(strings[index].charAt(i)));
                //这是关键，回溯要事先清理每一个字符，重新拼接
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
