package com.question1;

/**
 * @author zyk
 * @version 1.0
 * @fileName O17
 * @description :TODO 打印从1到最大的n位数
 * @date 2022/1/23 12:47
 */
public class O17 {
    public static int[] printNumbers(int n) {
        int sum= (int) (Math.pow(10,n)-1);
        int []res = new int [sum];
        for (int i = 0; i <sum ; i++) {
            res[i]=i+1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = O17.printNumbers(2);
        for (int i = 0; i <ints.length ; i++) {
            System.out.print(" "+ints[i]);
        }
    }
}
