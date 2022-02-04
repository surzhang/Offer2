package com.question5;

/**
 * @author zyk
 * @version 1.0
 * @fileName O63
 * @description :TODO 股票的最大利润
 * 暴力：双循环
 * 一次遍历
 * @date 2022/2/4 16:55
 */
public class O63 {
    public int maxProfit(int[] prices) {
        int minprice  =Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i <prices.length ; i++) {
            if (prices[i]<minprice){
                minprice=prices[i];
            }else if (prices[i]-minprice>maxprofit){
                maxprofit=prices[i]-minprice;
            }
        }
        return maxprofit;
    }
}
