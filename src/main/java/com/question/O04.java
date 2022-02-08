package com.question;

/**
 * @author zyk
 * @version 1.0
 * @fileName O04
 * @description :TODO 二维数组中查找
 * @date 2022/1/22 12:36
 */
public class O04 {
    //1.暴力法
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //行列
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //方法2.线性查找
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //行列
        int rows = matrix.length, columns = matrix[0].length;
        //第一行最后一个数
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            //每一行最后一个数
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
    //O(m+n)O(1)

}
