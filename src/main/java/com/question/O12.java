package com.question;

/**
 * @author zyk
 * @version 1.0
 * @fileName O12
 * @description :TODO 矩阵中的路径
 * @date 2022/1/22 14:10
 */
public class O12 {
    //深度优先搜索+剪枝
    public boolean exist(char[][] board, String word) {
        char[]words = word.toCharArray();
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if (dfs(board,words,i,j,0))return true;
            }
        }
        return false;
    }

    /**
     * 递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
     *
     *  终止条件：
     * 返回 false ： (1) 行或列索引越界 或 (2) 当前矩阵元素与目标字符不同 或 (3) 当前矩阵元素已访问过 （ (3) 可合并至 (2) ） 。
     * 返回 true ： k = len(word) - 1 ，即字符串 word 已全部匹配。
     *
     * 递推工作：
     * 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问。
     * 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
     * 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
     *
     * 返回值： 返回布尔量 res ，代表是否搜索到目标字符串。
     * @param board
     * @param words
     * @param i
     * @param j
     * @param k
     * @return
     */
    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=words[k]){
            return false;
        }
        if (k == words.length-1){
            return true;
        }
        //标记当前元素已访问过
        board[i][j]='\0';
        boolean res = dfs(board, words, i+1, j, k+1)||dfs(board, words, i-1, j, k+1)
                ||dfs(board, words, i, j+1, k+1)||dfs(board, words, i, j-1, k+1);
        //还原矩阵
        board[i][j]=words[k];
        //返回值
        return res;

    }
}
