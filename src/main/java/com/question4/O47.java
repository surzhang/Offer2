package com.question4;

/**
 * @author zyk
 * @version 1.0
 * @fileName O47
 * @description :TODO 礼物的最大价值
 * @date 2022/2/3 10:20
 */
public class O47 {
    //动态规划
    public int maxValue(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (j==0&&i==0){
                    continue;
                }
                if (i==0){
                    grid[i][j]+=grid[i][j-1];
                }else if (j==0){
                    grid[i][j]+=grid[i-1][j];
                }else{
                    grid[i][j]+=Math.max(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }
    //再次优化
    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }


}
