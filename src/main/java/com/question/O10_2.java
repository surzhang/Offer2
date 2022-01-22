package com.question;

/**
 * @author zyk
 * @version 1.0
 * @fileName O10_2
 * @description :TODO
 * @date 2022/1/22 13:40
 */
public class O10_2 {
    public int numWays(int n) {
        if (n <= 1) return 1;
        int a = 1, b = 1, c = 0;
        for (int i = 2; i <= n; i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c % 1000000007;
    }
}
