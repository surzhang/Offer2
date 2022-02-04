package com.question5;

import java.util.Arrays;

/**
 * @author zyk
 * @version 1.0
 * @fileName O60
 * @description :TODO 骰子的点数和
 * @date 2022/2/4 11:24
 */
public class O60 {
    public double[] dicesProbability(int n) {
        double[]dp  = new double[6];
        Arrays.fill(dp,1.0/6.0);
        for (int i = 2; i <=n ; i++) {
            double[]tmp = new double[5*i+1];
            for (int j = 0; j <dp.length ; j++) {
                for (int k = 0; k <6 ; k++) {
                    tmp[j+k]+=dp[j]/6.0;
                }
            }
            dp =tmp;
        }
        return dp;
    }
}
