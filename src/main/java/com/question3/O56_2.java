package com.question3;

/**
 * @author zyk
 * @version 1.0
 * @fileName O56_2
 * @description :TODO
 * @date 2022/2/2 17:06
 */
public class O56_2 {
    //方法1：有限自动机
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
    //方法2：遍历统计
    public int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }


}
