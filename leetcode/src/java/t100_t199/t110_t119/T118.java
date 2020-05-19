package java.t100_t199.t110_t119;

public class T118 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            //输出杨辉三角形的前numRows行
            //这题实际上只要了解杨辉三角形，那么并不难
            //杨辉三角形
            //1.每一层的头尾都是1
            //2.除了头尾，每一个数都等于上一层的左右的和

            //先处理特殊情况
            if (numRows < 1) return new ArrayList<>();
            //创建结果集
            List<List<Integer>> res = new ArrayList<>();
            //用于存放每一层的结果,同时初始化第一层
            List<Integer> list = new ArrayList<>();
            list.add(1);
            res.add(new ArrayList<>(list));
            //用于存放上一层
            List<Integer> preList;
            //从第二行开始遍历杨辉三角形
            for (int row = 2; row <= numRows; row++) {
                //重置当前层
                list = new ArrayList<>();
                //获取上一层
                preList = res.get(row - 2);
                //每一层的头都是1
                list.add(1);
                //根据上一层遍历当前层的结果
                for (int col = 1; col < row - 1; col++)
                    list.add(preList.get(col) + preList.get(col - 1));
                //每一层的尾都是1
                list.add(1);
                //添加进结果集
                res.add(list);
            }
            //返回结果
            return res;
        }
    }
}
