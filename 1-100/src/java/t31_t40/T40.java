package java.t31_t40;

public class T40 {
    class Solution {
        //提取为全局变量，方便调用
        //先根据返回类型创建结果集
        List<List<Integer>> res = new ArrayList<>();
        //用于存放单次结果
        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            //本题跟39题类似，建议放在一起做
            //首先参考39题，两题一样是回溯算法和剪枝算法的结合
            //空集不处理
            if (candidates == null) return res;
            //先对数组进行排序，方便进行剪枝操作
            Arrays.sort(candidates);
            //调用递归遍历方法
            dfs(candidates.length, candidates, target);
            //返回结果集
            return res;
        }

        //默认每次添加的值，不能超过上一次添加的值，即往小于等于加，防止重复
        //即通过剪枝有效防止重复结果
        //由于题目规定了每个数字只能使用一次
        //那么这题跟39的区别就在于，不能包含传递过来的最后索引
        //同时为了防止数组结果的重复，遇到相同的字符则跳过，即同个值，每层遍历只能取一次
        //即如 [1,1,1][2],这个情况，,只会出现一次结果
        public void dfs(int lastIndex, int[] candidates, int target) {
            //表明符合结果，加入结果集
            if (target == 0) {
                res.add(new ArrayList<Integer>(list));
                return;
            }
            //遍历数集，计算所有可能成立的结果
            for (int i = 0; i < lastIndex; i++) {
                //关键，遇到同值跳过，保证每层遍历只会取到同值一次
                //如[1,1,1][2]，保证只会出现一次[1,1],因为该条件会把最大索引一直压缩
                //防止出现多次重复遍历
                //这里建议自己debug跑一边，比较抽象
                if (i < lastIndex - 1 && candidates[i] == candidates[i + 1])
                    continue;
                //满足添加空间。则继续添加
                if (candidates[i] <= target) {

                    //加入临时列表
                    list.add(candidates[i]);
                    //继续递归添加
                    dfs(i, candidates, target - candidates[i]);
                    //不满足结果，则要删除当前添加的值,即最后一个值
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
