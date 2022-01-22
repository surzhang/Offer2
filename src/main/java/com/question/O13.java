package com.question;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyk
 * @version 1.0
 * @fileName O13
 * @description :TODO 机器人的运动范围
 * @date 2022/1/22 14:47
 */
public class O13 {
    /**
     * 深度优先遍历DFS
     * 深度优先搜索： 可以理解为暴力法模拟机器人在矩阵中的所有路径。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
     * 剪枝： 在搜索中，遇到数位和超出目标值、此元素已访问，则应立即返回，称之为 可行性剪枝 。
     * <p>
     * 递归参数： 当前元素在矩阵中的行列索引 i 和 j ，两者的数位和 si, sj 。
     * <p>
     * 终止条件： 当 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过 时，返回 00 ，代表不计入可达解。
     * <p>
     * 递推工作：
     * 标记当前单元格 ：将索引 (i, j) 存入 Set visited 中，代表此单元格已被访问过。
     * 搜索下一单元格： 计算当前元素的 下、右 两个方向元素的数位和，并开启下层递归 。
     * <p>
     * 回溯返回值： 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数。
     */
    int m, n, k;
    boolean[][] visited;

    public int movingCount2(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) +
                dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    /**
     * 方法1：广度优先搜索
     * 初始化： 将机器人初始点 (0,0) 加入队列 queue ；
     * <p>
     * 迭代终止条件： queue 为空。代表已遍历完所有可达解。
     * 迭代工作：
     * 单元格出队： 将队首单元格的 索引、数位和 弹出，作为当前搜索单元格。
     * 判断是否跳过： 若 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过 时，执行 continue 。
     * 标记当前单元格 ：将单元格索引 (i, j) 存入 Set visited 中，代表此单元格 已被访问过 。
     * 单元格入队： 将当前元素的 下方、右方 单元格的 索引、数位和 加入 queue 。
     * <p>
     * 返回值： Set visited 的长度 len(visited) ，即可达解的数量。
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        //可达解数量
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0) {
            //当前出队
            int[] x = queue.poll();
            //si，sj数位和
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i >= m || j >= n || k < si + sj || visited[i][j]) {
                continue;
            }
            //标记当前已经访问过
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j, (j + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }
}
