package com.question5;

/**
 * @author zyk
 * @version 1.0
 * @fileName O65
 * @description :TODO 不用加减乘除做加法
 * @date 2022/2/4 9:08
 */
public class O65 {
    //位运算
    public int add(int a, int b) {
        //当进位为0时跳出
        while(b!=0){
           //c==进位
            int c = (a & b)<<1;
            //a=非进位和
            a^=b;
            //b=进位
            b=c;
        }
        return a;
    }
}
