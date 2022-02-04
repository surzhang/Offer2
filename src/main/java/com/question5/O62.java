package com.question5;

/**
 * @author zyk
 * @version 1.0
 * @fileName O62
 * @description :TODO 圆圈中最后剩下的数字
 * @date 2022/2/4 15:42
 */
public class O62 {
    public int lastRemaining(int n, int m) {
        return f(n,m);
    }

    private int f(int n, int m) {
        if (n==1){
            return 0;
        }
        int x = f(n-1,m);
        return (m+x)%n;
    }
}
