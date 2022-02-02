package com.question3;

/**
 * @author zyk
 * @version 1.0
 * @fileName O57
 * @description :TODO 和为s的两个数字
 * @date 2022/2/2 17:58
 */
public class O57 {
    //对撞指针
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while (i<j){
            int s = nums[i]+nums[j];
            if (s<target)i++;
            else if (s>target)j--;
            else return new int []{nums[i],nums[j]};
        }
        return new int [0];
    }
}
