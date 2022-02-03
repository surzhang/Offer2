package com.question4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @version 1.0
 * @fileName O48
 * @description :TODO 最长不含重复字符的子字符串
 * @date 2022/2/3 11:55
 */
public class O48 {
    //动态规划+哈希表
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            //获取索引i
            int i = dic.getOrDefault(s.charAt(j), -1);
            //更新hash表
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }

    //动态规划+线性遍历
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while (i >= 0 && s.charAt(i) != s.charAt(j)) i--; // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    //双指针+hash表
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }


}
