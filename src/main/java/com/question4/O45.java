package com.question4;

import java.util.Arrays;

/**
 * @author zyk
 * @version 1.0
 * @fileName O45
 * @description :TODO
 * 把数组排成最小的数
 * @date 2022/2/3 9:25
 */
public class O45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //重写排序方法
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();

    }

    public void quickSort(String[] strs, int l, int r) {
        if (l>=r)return;
        int i=1,j=r;
        String tmp = strs[i];
        while(i<j){
            while((strs[j]+strs[l]).compareTo(strs[l]+strs[j])>=0&&i<j)j--;
            while((strs[i]+strs[l]).compareTo(strs[l]+strs[i])>=0&&i<j)i++;
            tmp=strs[i];
            strs[i]=strs[j];
            strs[j]=tmp;
        }
        strs[i]=strs[l];
        strs[l]=tmp;
        quickSort(strs,l,i-1);
        quickSort(strs, i+1, r);
    }
}
