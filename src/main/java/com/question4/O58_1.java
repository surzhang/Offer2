package com.question4;

/**
 * @author zyk
 * @version 1.0
 * @fileName O58_1
 * @description :TODO 翻转单词顺序
 * @date 2022/2/3 10:28
 */
public class O58_1 {
    //双指针
    public String reverseWords(String s) {
        s=s.trim();//删除首尾空格
        int j = s.length()-1,i=j;
        StringBuilder res = new StringBuilder();
        while(i>=0){
            //i从右到左搜索首个空格
            while(i>=0&&s.charAt(i)!=' ')i--;
            res.append(s.substring(i+1,j+1)+" ");//添加单词
            while(i>=0&&s.charAt(i)==' ')i--;//跳过单词的空格
            j=i;
        }
        return res.toString().trim();
    }

    public String reverseWords2(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

}
