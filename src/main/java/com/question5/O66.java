package com.question5;

/**
 * @author zyk
 * @version 1.0
 * @fileName O66
 * @description :TODO 构建乘积数组
 * @date 2022/2/4 10:58
 */
public class O66 {
    //暴力
    public int[] constructArr(int[] a) {
        int []ans = new int [a.length];
        for (int i = 0; i <a.length ; i++) {
            int k=1;
            for (int j = 0; j <a.length ; j++) {
                if (j==i){
                    continue;
                }
                k*=a[j];
            }
            ans[i]=k;
        }
        return ans;
    }
    //
    public int[] constructArr2(int[] a) {
        int len = a.length;
        if (len == 0){
            return new int [0];
        }
        int []b  =new int [len];
        b[0]=1;
        int tmp = 1;
        //计算下三角
        for (int i = 1; i <len ; i++) {
            b[i]=b[i-1]*a[i-1];
        }
        //计算上三角
        for (int i = len-2; i >=0 ; i--) {
            tmp*=a[i+1];
            b[i]*=tmp;
        }
        return b;
    }

}
