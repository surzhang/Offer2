package com.question5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zyk
 * @version 1.0
 * @fileName O61
 * @description :TODO 扑克牌中的顺子
 * @date 2022/2/4 14:55
 */
public class O61 {
    //set集合+遍历
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0,min=14;
        for (int num:nums) {
            if (num==0){
                continue;
            }
            max=Math.max(max,num);
            min=Math.min(min,num);
            if (repeat.contains(num))return false;
            repeat.add(num);
        }
        return max-min<5;
    }
    //排序+数组
    public boolean isStraight2(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }


}
