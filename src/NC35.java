/**
 * @author dingxudong
 * @create 2021-09-07 17:39
 * @Description
 * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。
 */
public class NC35 {
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int row = str1.length();
        int col = str2.length();
        int[][] dp = new int[row + 1][col + 1];
        for(int i = 0; i <= row; i++){
            dp[i][0] = i * dc;//这里需要乘以dc
        }
        for(int j = 1; j <= col; j++){
            dp[0][j] = j * ic;//这里需要乘以ic
        }
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j -1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + rc, Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
                }
            }
        }
        return dp[row][col];
    }
}
