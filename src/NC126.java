import java.util.Arrays;

/**
 * @author dingxudong
 * @create 2021-09-27 11:56
 * @Description
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 */
public class NC126 {
    //二维动态规划
//    public static int minMoney (int[] arr, int aim) {
//        if (arr.length == 0)
//            return -1;
//        int len = arr.length;
//        //dp[i][j]的含义为:在可以任意使用arr[0...i]货币的情况下，组成j所需的最小张数。
//        int dp[][] = new int[len][aim + 1];
//
//        // 初始化
//        for(int i = 1; i < aim + 1;i++){
//            if(i % arr[0] == 0){
//                dp[0][i] = i / arr[0];
//            }else {
//                dp[0][i] = Integer.MAX_VALUE;// 无法凑出数值为j的钱
//            }
//        }
//
//        // 更新
//        for(int i = 1; i < len; i++){
//            for(int j = 1; j <= aim; j++){
//                if(j - arr[i] >= 0 && dp[i][j - arr[i]] != Integer.MAX_VALUE) {
//                    // 判断不使用当前种类的货币和仅使用一张当前种类的货币这两种情况下，哪一种方案使用的货币少
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - arr[i]] + 1);
//                }else{
//                    // 不使用当前种类的货币
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//
//        return dp[len - 1][aim] == Integer.MAX_VALUE ? -1 : dp[len - 1][aim];
//    }
    public static int minMoney (int[] arr, int aim) {
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j <= aim; j++){
                if (j >= arr[i]){
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        return dp[aim] == aim + 1 ? -1 : dp[aim];
    }
    public static int minMoney1 (int[] arr, int aim) {
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j <= aim; j++){
                if (j >= arr[i] && dp[j - arr[i]] != Integer.MAX_VALUE){//如果用Integer.MAX_VALUE，需要多加一个条件防止整形越界
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        return dp[aim] == Integer.MAX_VALUE ? -1 : dp[aim];
    }

    public static void main(String[] args) {
        int i = minMoney(new int[]{2887, 2355, 335, 4472, 4561, 1819, 3808}, 4953);
        System.out.println("i = " + i);
        System.out.println(Integer.MAX_VALUE);
    }
}


