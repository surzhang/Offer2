package com.question4;

/**
 * @author zyk
 * @version 1.0
 * @fileName O53_1
 * @description :TODO 在排序数组中查找数字i
 * 统计一个数字在排序数组中出现的次数。
 * @date 2022/2/3 10:42
 */
public class O53_1 {
    public int search(int[] nums, int target) {
        int count=0;
        for (int num:nums) {
            if (num==target){
                count++;
            }
        }
        return count;
    }

    //二分查找
    public int search2(int []nums,int target){
        int leftIdx = binarySearch(nums,target,true);
        int rightIdx = binarySearch(nums,target,false);
        if (leftIdx<=rightIdx&&rightIdx<nums.length&& nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx-leftIdx+1;
        }
        return 0;
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0,right=nums.length-1,ans=nums.length;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]>target||(lower&&nums[mid]>=target)){
                right = mid-1;
                ans = mid;
            }else{
                left  =mid+1;
            }
        }
        return ans;
    }
}
