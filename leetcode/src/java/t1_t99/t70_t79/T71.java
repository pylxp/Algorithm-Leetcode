package java.t1_t99.t70_t79;

public class T71 {
    class Solution {
        public String simplifyPath(String path) {
            //判断有效路径，这题和32相似，建议放在一起做
            //由题意根据Unix风格，我们可以得出以下结论
            //1.'.'表示当前目录，即无需处理
            //2.""表示空格无效路径，无需处理
            //3.‘..'表示上一级目录，那么就等于回退一次操作
            //综上可知，栈的先进后出(FILO)特性是一个比较好的选择
            //但是栈最后需要进行弹出拼接反转比较多余，所以这里直接用StringBuilder模拟即可

            //首先，根据路径标识‘/’进行切割分组
            String[] pathSplit = path.split("/");
            //由于最后要输出简化路径，所以创建StringBuilder进行拼接结果
            //1.比String更省内存 2.不考虑安全的情况下，比StringBuffer性能更好
            StringBuilder res = new StringBuilder();
            //压栈操作
            for (String str : pathSplit) {
                //1.'.'表示当前目录，即无需处理
                //2.""表示空格无效路径，无需处理
                //3.‘..'表示上一级目录，那么就等于回退一次操作
                if (str.equals(".") || str.equals("")) continue;
                else if (str.equals("..")) {
                    //无法回退则不处理
                    if (res.length() == 0) continue;
                        //回退一格
                    else res.delete(res.lastIndexOf("/"), res.length());
                } else res.append("/").append(str);
            }
            if (res.length() == 0) return "/";
            return res.toString();
        }
    }
}
