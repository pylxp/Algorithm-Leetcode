package java.t21_t30;

public class T22 {
    class Solution {
        //提升为全局变量，方便dfs调用
        //老规矩，没啥好说的，先把返回类型结果创建了
        List<String> res = new ArrayList<>();
        //用于拼接字符串，这里选择StringBuilder
        //1.比String不可变要节省内存
        //2.不考虑安全的情况下，性能比StringBuffer更好
        StringBuilder sb = new StringBuilder();

        public List<String> generateParenthesis(int n) {
            //这题可以和17题放在一起做，这里同样采用深度遍历
            dfs(n, n);
            return res;
        }

        //深度遍历方法
        //left表示剩余左括号数量，right表示剩余右括号数量
        private void dfs(int left, int right) {
            //递归的要点，先设立终止条件
            //left/right都为空，则表示拼接结束
            if (left == 0 && right == 0) {
                res.add(sb.toString());
                return;
            }
            //左括号有剩余，可以继续拼接
            if (left != 0) {
                //拼接'('
                sb.append('(');
                //剩余左括号数量-1,拼接'('
                dfs(left - 1, right);
                //这是关键，回溯要事先清理每一个字符，重新拼接
                sb.deleteCharAt(sb.length() - 1);
            }
            //右括号必须保证比左括号剩余更多，即有左括号才能拼接右括号
            if (right > left) {
                //拼接')'
                sb.append(')');
                //剩余右括号数量-1
                dfs(left, right - 1);
                //这是关键，回溯要事先清理每一个字符，重新拼接
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
