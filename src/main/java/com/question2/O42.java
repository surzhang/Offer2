package com.question2;

/**
 * @author zyk
 * @version 1.0
 * @fileName O41
 * @description :TODO 连续子数组的最大和
 * @date 2022/2/1 16:20
 */
public class O42 {

    public int maxSubArray1(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }



    //动态规划
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns  =nums[0];
        //用一个pre保存f(i)和f（i-1）
        for (int x:nums) {
            pre = Math.max(pre+x,x);
            maxAns=Math.max(maxAns,pre);
        }
        return maxAns;
    }
}
