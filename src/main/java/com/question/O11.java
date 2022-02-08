package com.question;

/**
 * @author zyk
 * @version 1.0
 * @fileName O11
 * @description :TODO 旋转数组的最小值
 * @date 2022/1/22 13:59
 */
public class O11 {
    //二分查找O(n)O(1)
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            //中间坐标
            int mid = low + (high - low) / 2;
            //中间值小于右边的，最大的坐标移到mid
            if (numbers[mid] < numbers[high]) {
                high = mid;
                //中间值大于右边的，最小的坐标右移到mid+1
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
                //中间值等于右边的，坐标--
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
    public int minArray2(int[] numbers) {
        int n = numbers.length;
        int low=0,high=n-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if (numbers[mid]<numbers[high]){
                high=mid;
            }else if (numbers[mid]>numbers[high]){
                low=mid+1;
            }else{
                high-=1;
            }
        }
        return numbers[low];
    }
}
