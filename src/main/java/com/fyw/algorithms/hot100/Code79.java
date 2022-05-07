package com.fyw.algorithms.hot100;

/**
 * @Title Code79
 * @Author fyw
 * @Date 2022/5/4 10:52
 * @Description:
 */
public class Code79 {
    char[][] g;
    int m;
    int n;
    boolean[][] visited;
    String word;
    int[] dx=new int[]{-1,0,1,0};
    int[] dy=new int[]{0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        if (board==null||board.length==0||board[0].length==0)
            return false;
        g=board;
        m=board.length;
        n=board[0].length;
        this.word=word;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0)==board[i][j]){
                    visited=new boolean[m][n];
                    if (dfs(i,j,new StringBuilder())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean dfs(int x,int y,StringBuilder sb){
        if (sb.length()==word.length()){
            return false;
        }
        sb.append(g[x][y]);
        visited[x][y]=true;
        if (sb.toString().equals(word))
            return true;
        for (int i = 0; i < 4; i++) {
            int a=x+dx[i];
            int b=y+dy[i];
            if (a<0||a>=m||b<0||b>=n||visited[a][b])
                continue;
            if (dfs(a,b,sb))
                return true;
        }

        visited[x][y]=false;
        sb.deleteCharAt(sb.length()-1);
        return false;
    }
}
