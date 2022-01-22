/**
 * @author dingxudong
 * @create 2021-09-05 17:06
 * @Description
 *
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 *
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 */
public class NC17 {

    public class Solution {
        public int getLongestPalindrome(String A, int n) {
            // write code here
            int max = Integer.MIN_VALUE;
            int cur = 0;
            for(int i = 0; i < A.length(); i++){
                cur = getPalindrome(A,i,i+1) > getPalindrome(A, i, i) ? getPalindrome(A,i,i+1) : getPalindrome(A,i,i);
                max = Math.max(max, cur);
            }
            return max;
        }
        private int getPalindrome(String A, int i, int j){
            int left = i;
            int right = j;
            while(left >= 0 && right < A.length() && A.charAt(left) == A.charAt(right)){
                left--;
                right++;
            }
            return right - left + 1 - 2;
        }
    }
}
