package java.t11_t20;

public class T20 {
    class Solution {
        public boolean isValid(String s) {
            //单数个肯定为false
            if (s.length() % 2 != 0) return false;
            //空字符串判断为true
            if (s.isEmpty()) return true;
            //这里涉及多种括号，传统的计数配对不适用
            //因为括号必须由内往外消，所以及FILO，故采用栈的数据结构
            Stack<Character> stack = new Stack<>();
            //这里试过用map存储取值，性能几乎没差别，二选一即可
            for (char c : s.toCharArray()) {
                if (c == '(')
                    stack.push(')');
                else if (c == '[')
                    stack.push(']');
                else if (c == '{')
                    stack.push('}');
                else{
                    //这里比较难理解，详细解释下
                    //1.如果遇到右括号，里面为空，肯定false
                    //2.如果遇到右括号，弹出的符号不相同，则代表最近压入栈的左括号不适配，返回false
                    if (stack.empty()||c!=stack.pop())
                        return false;
                }
            }
            //如果为空代表全部配对返回true，否则代表有剩余，返回false
            return stack.empty();
        }
    }
}
