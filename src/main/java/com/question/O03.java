package com.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zyk
 * @version 1.0
 * @fileName O03
 * @description :TODO 数组中重复的数字
 * @date 2022/1/22 12:02
 */
public class O03 {
    //此解法不好
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                return key;
            }
        }
        return 0;
    }

    //比较好的
    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 3};
        O03.findRepeatNumber2(nums);
    }
}
