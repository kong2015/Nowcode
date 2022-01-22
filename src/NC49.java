import java.util.Stack;

/**
 * @author dingxudong
 * @create 2021-09-23 11:52
 * @Description
 *
 * 例1: 对于字符串 "(()" 来说，最长的格式正确的子串是 "()" ，长度为 2 .
 * 例2：对于字符串 ")()())" , 来说, 最长的格式正确的子串是 "()()" ，长度为 4 .
 */
public class NC49 {
//    public static int longestValidParentheses (String s) {
//        // write code here
//        if(s == null || s.length() == 0)
//            return 0;
//        char[] arr = s.toCharArray();
//        int left = 0;
//        int right = 0;
//        int max = 0;
//        for (char c : arr) {
//            if (c == '(')
//                left++;
//            else right++;
//            if (left == right)
//                max = Math.max(max, 2* left);
//            else if (right > left){
//                left = 0;
//                right = 0;
//            }
//        }
//        left = 0;
//        right = 0;
//        for (int i = arr.length - 1; i >= 0; i--){
//            if (arr[i] == '(')
//                left++;
//            else right++;
//            if (right == left)
//                max = Math.max(max, 2 * right);
//            else if (left > right){
//                right = 0;
//                left = 0;
//            }
//        }
//        return max;
//    }

//    public static int longestValidParentheses (String s) {
//        int max = 0;
//        char[] arr = s.toCharArray();
//        int[] dp = new int[arr.length];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] == ')'){
//                if (arr[i - 1] == '('){
//                    if (i >= 2){
//                        dp[i] = 2 + dp[i - 2];
//                    }else {
//                        dp[i] = 2;
//                    }
//                }else {
//                    if (i - dp[i - 1] - 1 >= 0 && arr[i - dp[i - 1] - 1] == '('){
//                        if (i - dp[i - 1] - 2 >= 0){
//                            dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
//                        }else {
//                            dp[i] = dp[i - 1] + 2;
//                        }
//                    }
//
//                }
//                max = Math.max(max, dp[i]);
//            }
//        }
//        return max;
//    }

    public static int longestValidParenthese(String s) {
        Stack<Integer>stack = new Stack<>();
        int max = 0;
        char[] arr = s.toCharArray();
        stack.push(-1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (!stack.isEmpty()){
                    max = Math.max(max, i - stack.peek());
                }else {
                    stack.push(i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = longestValidParenthese("())");
        System.out.println("i = " + i);
    }
}
