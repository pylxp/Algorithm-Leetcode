package java.t100_t199.t130_t139;

public class T130 {
    class Solution {
        //提取为全局变量，方便调用
        //建立扫面路径，即上下左右
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //获取矩阵边界
        int rows, cols;
        //标志是否为边界O
        boolean[][] visited;

        public void solve(char[][] board) {
            //将被x围绕的o替换为x
            //不过比较好玩的事，实际上官方在解释里，竟然直接给了思路
            //即，换个角度看，除了连通外界的o除外，都是被围绕的
            //那么直接从边界开始扫描，排除连通边界的o即可

            //先处理特殊情况
            if (board.length == 0 || board[0].length == 0) return;
            //获取矩阵的边界范围
            rows = board.length;
            cols = board[0].length;
            //初始化标志矩阵
            visited = new boolean[rows][cols];
            //遍历左边界和右边界
            for (int i = 0; i < rows; i++) {
                //如果是左边界O,且还没被扫描过，则以该点开始扫描
                if (board[i][0] == 'O' && !visited[i][0]) scan(board, i, 0);
                //如果是右边界O,且还没被扫描过，则以该点开始扫描
                if (board[i][cols - 1] == 'O' && !visited[i][cols - 1]) scan(board, i, cols - 1);
            }
            //遍历上边界和下边界
            for(int i=0;i<cols;i++){
                //如果是上边界O,且还没被扫描过，则以该点开始扫描
                if (board[0][i] == 'O' && !visited[0][i]) scan(board, 0, i);
                //如果是下边界O,且还没被扫描过，则以该点开始扫描
                if (board[rows - 1][i] == 'O' && !visited[rows - 1][i]) scan(board, rows - 1, i);
            }
            //开始重构矩阵，即所有没被标志的都改为X
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    if (!visited[i][j]) board[i][j] = 'X';
        }

        //扫描矩阵
        public void scan(char[][] board, int x, int y) {
            //先将扫描的点标志
            visited[x][y] = true;
            //往四个方向扫描
            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                        && !visited[newX][newY] && board[newX][newY] == 'O')
                    scan(board, newX, newY);
            }
        }
    }
}
