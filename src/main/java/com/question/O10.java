package com.question;

/**
 * @author zyk
 * @version 1.0
 * @fileName O10
 * @description :TODO 斐波那契数列
 * @date 2022/1/22 11:53
 */
public class O10 {
    public int fib(int n) {
        final int mod = 1000000007;
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1, sum;
        for (int i = 2; i < n; i++) {
            sum = (a + b) % mod;
            a = b;
            b = sum;
        }
        return a;
    }
}
