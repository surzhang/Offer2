package com.question3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @version 1.0
 * @fileName O39
 * @description :TODO 数组中出现次数超过一半的数字
 * @date 2022/2/2 15:36
 */
public class O39 {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    //方法2：排序之后中间的一定是众数
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //方法3：摩尔投票法
    public int majorityElement3(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
