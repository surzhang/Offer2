package com.question3;

/**
 * @author zyk
 * @version 1.0
 * @fileName O51
 * @description :TODO 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * @date 2022/2/2 17:05
 */
public class O51 {
    //归并排序
/**    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] tmp = new int[len];
        return reversePairs(copy, 0, len - 1, tmp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, tmp);
        int rightParis = reversePairs(nums, mid + 1, right, tmp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightParis;
        }
        int crossPairs = mergeAndCount(nums,left,mid,right,tmp);
        return leftPairs+rightParis+crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <=right ; i++) {
            tmp[i]=nums[i];
        }
        int i=left;
        int j = mid+1;
        int count = 0;
        for (int k = left; k <=right ; k++) {
            if (i==mid+1){
                nums[k]=tmp[j];
                j++;
            }else if (j==right+1){
                nums[k]=tmp[i];
                i++;
            }else if (tmp[i]<=tmp[j]){
                nums[k]=tmp[i];
                i++;
            }else{
                nums[k]=tmp[j];
                j++;
                count+=(mid-i+1);
            }
        }
        return count;
    }*/

    int[] nums, tmp;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }
    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }


}
