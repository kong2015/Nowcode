/**
 * @author dingxudong
 * @create 2021-09-05 17:09
 * @Description
 * 给定两个字符串str1和str2, 输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 */
public class NC127 {
    public class Solution {
        public String LCS (String str1, String str2) {
            // write code here
            int[][] res = new int[str1.length()][str2.length()];
            int max = 0;
            int index = 0;
            for(int i = 0; i < str1.length(); i++){
                for(int j = 0; j < str2.length(); j++){
                    if(str1.charAt(i) == str2.charAt(j)){
                        if(i == 0 || j == 0){
                            res[i][j] = 1;
                        }else{
                            res[i][j] = res[i - 1][j - 1] + 1;
                            if(res[i][j] > max){
                                max = res[i][j];
                                index = i;
                            }
                        }
                    }
                }
            }
            return str1.substring(index - max + 1, index + 1);
        }
    }
}
