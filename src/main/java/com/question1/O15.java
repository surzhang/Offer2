package com.question1;

/**
 * @author zyk
 * @version 1.0
 * @fileName O15
 * @description :TODO 二级制中1的个数
 * @date 2022/1/23 12:21
 */
public class O15 {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    /**
     * n & (n−1)，其预算结果恰为把 nn 的二进制位中的最低位的 1 变为 0 之后的结果。
     * 这样我们可以利用这个位运算的性质加速我们的检查过程，在实际代码中，我们不断让当前的 nn 与 n - 1n−1 做与运算，直到 nn 变为 00 即可。因为每次运算会使得 nn 的最低位的 11 被翻转，因此运算次数就等于 nn 的二进制位中 11 的个数。
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }


}
