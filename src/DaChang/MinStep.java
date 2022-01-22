package DaChang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dingxudong
 * @create 2021-09-09 10:57
 * @Description
 */
public class MinStep {
    public static int bfs(int[][] grid , int i , int j,boolean[][] visited){
        int num = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i , j});
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int[] node = queue.poll();
                if(node[0] < 0 || node[0] >grid.length-1 || node[1] < 0 || node[1] > grid[0].length -1 ||
                        grid[node[0]][node[1]] == 0|| visited[node[0]][node[1]]){
                    continue;
                }
                visited[node[0]][node[1]] = true;

                if (node[0] == grid.length-1 && node[1] == grid[0].length-1){
                    return num;
                }
                for (int k = 1; k <= grid[node[0]][node[1]]; k++) {
                    int x = node[0];
                    int y = node[1] + k;
                    queue.offer(new int[]{x , y});
                }
                for (int k = 1; k <= grid[node[0]][node[1]]; k++) {
                    int x = node[0] + k;
                    int y = node[1];
                    queue.offer(new int[]{x , y});
                }
            }
            num++;
        }
        return num;
    }
    public static int dp(int[][] step){
        int M = step.length;
        int N = step[0].length;
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE/2;
            }
        }
        dp[1][1] = 0;
        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (step[i - 1][j - 1] == 0)
                    continue;
                else {
                    for (int k = 1; k <= step[i - 1][j - 1]; k++) {
                        if (j + k <= N && step[i - 1][j + k - 1] != 0) {
                            dp[i][j + k] = Math.min(dp[i][j + k], dp[i][j] + 1);
                        }
                        if (i + k <= M && step[i + k - 1][j - 1] != 0) {
                            dp[i + k][j] = Math.min(dp[i + k][j], dp[i][j] + 1);
                        }
                    }
                }
            }
        }
        return dp[M][N] == Integer.MAX_VALUE/2 ? -1 : dp[M][N];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3,2,1},{0,1,1},{1,1,1}
        };
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        System.out.println(bfs(matrix , 0 , 0, visited));
        System.out.println(getDP(matrix));
    }
    public static int getDP(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp= new int[row][col];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        if (arr[0][0] == 0)
            return -1;
        dp[0][0] = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(arr[i][j] == 0)
                    continue;
                for (int k = 1; k <= arr[i][j]; k++){
                    if (j+k<col && arr[i][j+k] != 0){
                        dp[i][j+k] = Math.min(dp[i][j] + 1, dp[i][j+k]);
                    }
                    if (i+k<row && arr[i+k][j] != 0){
                        dp[i+k][j] = Math.min(dp[i][j] + 1, dp[i+k][j]);
                    }
                }
            }
        }
        return dp[row - 1][col - 1] == Integer.MAX_VALUE? -1:dp[row-1][col-1];
    }
}