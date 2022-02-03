package com.question4;

/**
 * @author zyk
 * @version 1.0
 * @fileName O46
 * @description :TODO 把数字翻译成字符串
 * @date 2022/2/3 9:54
 */
public class O46 {
    public int translateNum0(int num) {
        String s = String.valueOf(num);
        //a=dp[1],b=dp[0]
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            //f(i)
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }


    /**
     * TODO 动态规划+滚动数组
     */
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }
}
