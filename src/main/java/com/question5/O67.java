package com.question5;

/**
 * @author zyk
 * @version 1.0
 * @fileName O67
 * @description :TODO 把字符串转换成整数
 * @date 2022/2/4 11:36
 */
public class O67 {
    public int strToInt(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if (length == 0) return 0;
        while (str.charAt(i) == ' ') {
            if (++i == length) return 0;
        }
        if (str.charAt(i) == '-') sign = -1;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }
        for (int j = i; j < length; j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if (res > bndry || res == bndry && str.charAt(j) > '7') {

                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + str.charAt(j) - '0';
        }
        return sign * res;
    }
}
