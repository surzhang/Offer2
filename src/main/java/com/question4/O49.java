package com.question4;

import jdk.nashorn.internal.objects.annotations.Property;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zyk
 * @version 1.0
 * @fileName O49
 * @description :TODO 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * @date 2022/2/3 16:42
 */
public class O49 {
    //最小堆
    public int nthUglyNumber(int n) {
        int[]factors = {2,3,5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i <n ; i++) {
            long curr = heap.poll();
            ugly=(int)curr;
            for (int factor:factors) {
                long next = curr*factor;
                //如果seen中有会跳出循环
                if (seen.add(next)){
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public int nthUglyNumber2(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }


}
