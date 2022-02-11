package com.question4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @version 1.0
 * @fileName O53_2
 * @description :TODO 0~n-1中缺失的数字
 * @date 2022/2/3 11:47
 */
public class O53_2 {
    //二分法
    public int missingNumber(int[] nums) {
      int i =0,j = nums.length-1;
      while(i<=j){
          int mid = (i+j)/2;
          if (nums[mid]==mid)i=mid+1;
          else j=mid - 1;
      }
      return i;
    }
}
