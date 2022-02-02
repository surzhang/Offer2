package com.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @version 1.0
 * @fileName O50
 * @description :TODO 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @date 2022/2/2 16:00
 */
public class O50 {
    //哈希表
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char c =s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i <s.length() ; i++) {
            if (map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public  char firstUniqChar2(String s) {
        int[] arr=new int[26];//arr[i]表示字符i的个数
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i <s.length(); i++) {
            if(arr[s.charAt(i)-'a']==1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

}
