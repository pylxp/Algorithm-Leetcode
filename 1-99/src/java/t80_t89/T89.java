package java.t80_t89;

public class T89 {
    class Solution {
        public List<Integer> grayCode(int n) {
            //根据格雷码的性质，有三种常用的解题方式
            //1.公式法，G(n)=B(n+1)XOR B(n);
            //2.镜像法
            // n的排列=(n-1)的排列和镜像排列，在前面全部+0和全部+1
            // 即 n=1（0，1）（镜像为1，0 /即 0，1，1，0） n=2(00,01,11,10)
            // n=3(000,001,011,010,110,111,101,100)
            //3.全排列
            //这里采用方法二解答

            //根据返回类型创建结果集
            List<Integer> res = new ArrayList<>();
            //添加初始值0
            res.add(0);
            //遍历n遍，即算出n-1的结果，通过镜像法得到n的结果
            for (int i = 0; i < n; i++)
                //取出每个值，往最前方添加1，不用添加0，因为转换为10进制不影响结果
                //必须逆序才是镜像。才能保证每次只改变一个值
                for (int j = res.size() - 1; j >= 0; j--)
                    res.add(res.get(j) ^ (1 << i));
            //返回结果
            return res;
        }
    }
}
