package com.question1;

/**
 * @author zyk
 * @version 1.0
 * @fileName O21
 * @description :TODO 调整数组顺序使奇数位于偶数前面
 * @date 2022/1/23 12:13
 */
public class O21 {
    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1,tmp;
        while(i<j){
            //判断是奇数
            while(i<j&&(nums[i]&1)==1)i++;
            //判断是偶数
            while(i<j&&(nums[j]&1)==0)j--;
            tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        return nums;
    }
}
