package java.t1_t99.t70_t79;

public class T77 {
    class Solution {
        //提取为全局变量，方便调用
        //根据返回类型创建结果集
        List<List<Integer>> res;
        //用于存放单次结果
        List<Integer> oneRes;

        public List<List<Integer>> combine(int n, int k) {
            //这题跟39，40相似，同属于剪枝回溯算法，建议放在一起做
            //从1~n中任取k个数输出所有的可能结果，根据这句话不难得出以下结论
            //1.固定1一个数，任取k-1个数，那么每次遍历，只需要往后遍历即可
            //即1》2~n  2》3~n，不需要回头遍历，即通过剪枝，有效避免多余遍历造成重复
            //2.后面的（k-oneRes.size()）不用遍历，必定超出k的长度

            //创建结果集
            res = new ArrayList<>();
            //先处理特殊情况
            if (k < 1 || k > n) return res;
            //用于存放单次结果
            oneRes = new ArrayList<>();
            //调用遍历方法
            dfs(n, k, 1);
            //返回结果
            return res;
        }

        //每次遍历的范围都是Start~ n - (k - oneRes.size()) + 1
        //1.Start开始表示不回头，否则会导致结果重复
        //2.n - (k - oneRes.size()) + 1，即最后（k-oneRes.size（））不用遍历，必定超出k
        public void dfs(int n, int k, int start) {
            //先设立终止条件，即已遍历数等于长度则返回
            if (oneRes.size() == k) {
                res.add(new ArrayList<>(oneRes));
                return;
            }
            //剪枝操作，每次遍历不得小于上次遍历的值
            //这里的终止条件是个重点，最后oneRes.size是不需要遍历的，因为必定超出长度
            for (int i = start; i <=  n - (k - oneRes.size()) + 1; i++) {
                //添加
                oneRes.add(i);
                //往下层继续遍历
                dfs(n, k, i + 1);
                //重点，返回必须删除上一次添加的数
                oneRes.remove(oneRes.size() - 1);
            }
        }
    }
}
