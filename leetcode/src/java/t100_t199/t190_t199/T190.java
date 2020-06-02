package java.t100_t199.t190_t199;

public class T190 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            //要求颠倒给定的32位无符号整数的二进制位
            //即对原二进制数进行翻转后的结果
            //那么不难想到，只需要遍历原32位无符号整数n的末位
            //然后将其不断地添加到新建数的末位即可实现翻转

            //由于是无符号数，初始为0即可
            int res = 0;
            //遍历32次
            for (int i = 0; i < 32; i++) {
                //新建数左移，末尾添加原数n的末位
                res = (res << 1) + (n & 1);
                //原数n右移一位，保证下一次要遍历的数也在末尾
                n >>= 1;
            }
            //返回结果
            return res;
        }
    }
}
