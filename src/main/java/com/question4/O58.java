package com.question4;

/**
 * @author zyk
 * @version 1.0
 * @fileName O58
 * @description :TODO 左旋转字符串
 * @date 2022/2/3 11:42
 */
public class O58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length())+s.substring(0,n);
    }
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i <s.length() ; i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i <n ; i++) {
            res.append(s.charAt(i));
        }
       return res.toString();
    }
}
