package com.question3;

/**
 * @author zyk
 * @version 1.0
 * @fileName O44
 * @description :TODO 数字序列中某一位的数字
 * @date 2022/2/2 16:00
 */
public class O44 {
    /**
     *
     将 101112 ⋯ 中的每一位称为 数位 ，记为 n ；
     将 10, 11, 12, ⋯ 称为 数字 ，记为 num ；
     数字 10 是一个两位数，称此数字的 位数 为 22 ，记为 digit ；
     每 digit位数的起始数字（即：1, 10, 100,⋯），记为 start 。
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start =1;
        long count =9;
        while (n>count){
            n-=count;
            digit+=1;
            start*=10;
            count=digit*start*9;
        }
        long num=start+(n-1)/digit;
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }
}
