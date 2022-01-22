package com.question;

/**
 * @author zyk
 * @version 1.0
 * @fileName O14
 * @description :TODO 剪绳子
 * @date 2022/1/22 16:28
 */
public class O14 {
    //动态规划
    public int cuttingRope(int n) {
        int []dp = new int [n+1];
        dp[2]=1;
        //dp[2]已知，从dp[3]开始求，直到求出dp[n]
        for (int i = 3; i <=n ; i++) {
            //首先对绳子剪长度为j的一段,其中取值范围为 2 <= j < i
            for (int j = 2; j <i ; j++) {
                dp[i]=Math.max(dp[i],Math.max(dp[j]*dp[i-j],j*dp[i-j]));
                //Math.max(j*(i-j),j*dp[i-j]是由于减去第一段长度为j的绳子后，可以继续剪也可以不剪
                //Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]))是当j不同时，求出最大的dp[i]
            }
        }
        return dp[n];
    }
    //数学推论
    public int cuttingRope2(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}
