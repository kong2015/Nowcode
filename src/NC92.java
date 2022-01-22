/**
 * @author dingxudong
 * @create 2021-09-10 20:33
 * @Description
 * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。目前给出的数据，仅仅会存在一个最长的公共子序列
 */

public class NC92 {
    public static String LCS (String s1, String s2) {
        // write code here
        if(s1.equals("") || s2.equals(""))
            return "-1";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 1 && j >= 1){
            if(dp[i][j] != dp[i][j - 1] && dp[i][j] != dp[i - 1][j]){
                res.append(s1.charAt(i - 1));
                i--;
                j--;
            }else if(dp[i][j] == dp[i][j - 1]){
                j--;
            }else if(dp[i][j] == dp[i - 1][j]){
                i--;
            }
        }
        return dp[s1.length() - 1][s2.length() - 1] == 0? "-1":res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = LCS("1A2C3D4B56","B1D23A456A");
        System.out.println(s);
    }
}
