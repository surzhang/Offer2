package com.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyk
 * @version 1.0
 * @fileName O57_2
 * @description :TODO 和为s的连续正数序列
 * @date 2022/2/3 9:38
 */
public class O57_2 {
    //一元二次不等式
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int x = 1; x <= limit; ++x) {
            long delta = 1 - 4 * (x - (long) x * x - 2 * target);
            if (delta < 0) {
                continue;
            }
            int delta_sqrt = (int) Math.sqrt(delta + 0.5);
            if ((long) delta_sqrt * delta_sqrt == delta && (delta_sqrt - 1) % 2 == 0) {
                int y = (-1 + delta_sqrt) / 2; // 另一个解(-1-delta_sqrt)/2必然小于0，不用考虑
                if (x < y) {
                    int[] res = new int[y - x + 1];
                    for (int i = x; i <= y; ++i) {
                        res[i - x] = i;
                    }
                    vec.add(res);
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    //双指针（滑动窗口）1
    public int[][] findContinuousSequence2(int target) {
        List<int []>vec = new ArrayList<>();
        for (int l = 1,r=2; l <r ;) {
            int sum = (l+r)*(r-l+1)/2;
            if (sum==target){
                int []res = new int [r-l+1];
                for (int i = l; i <=r ; i++) {
                    res[i-l]=i;
                }
                vec.add(res);
                l++;
            }else if (sum<target){
                r++;
            }else{
                l++;
            }
        }
        return vec.toArray(new int [vec.size()][]);
    }

    //滑动窗口2
    public int[][] findContinuousSequence3(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    /**
     * 滑动窗口3
     * @param target
     * @return
     */
    public int[][] findContinuousSequence4(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(s == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if(s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }

}
