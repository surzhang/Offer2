package com.question5;

/**
 * @author zyk
 * @version 1.0
 * @fileName O64
 * @description :TODO 求1+2+3+...+n的和
 * @date 2022/2/4 11:29
 */
public class O64 {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        O64 o64=new O64();
        o64.sumNums(3);

    }
}
