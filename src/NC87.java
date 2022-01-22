
/**
 * @author dingxudong
 * @create 2021-09-16 10:26
 * @Description
 * 一座大楼有层，地面算作第0层，最高的一层为第 层。已知棋子从第0层掉落肯定不会摔碎，从第层掉落可能会摔碎，也可能不会摔碎。
 *
 * 给定整数作为楼层数，再给定整数作为棋子数，返回如果想找到棋子不会摔碎的最高层数，即使在最差的情况下扔的最小次数。一次只能扔一个棋子。
 *
 * 输入数据: 1 \le N, K \le 10^61≤N,K≤10
 * 6
 */
public class NC87 {

    //暴力法(N!)
//    public int solve(int N, int K){
//        if ( N<1 || K<1 )
//            return 0;
//        return helper1(N, K);
//    }
//    private int helper1(int N, int K){
//        if ( N==0 ) return 0;
//        if ( K==1 ) return N;
//
//        int min = Integer.MAX_VALUE;
//        for(int i=1; i<=N; ++i){
//            min = Math.min(min, Math.max( helper1(i-1, K-1), helper1(N-i, K)));
//        }
//        return min+1;
//    }

//    public static int solve(int N, int K){
//        if(K == 1)
//            return N;
//        if(N < 1 || N < 1)
//            return 0;
//        int[][] dp = new int[N + 1][ K + 1];
//        for(int i = 1; i < N + 1; i++){
//            dp[i][1] = i;
//        }
//        for(int i = 1; i < N + 1; i++){
//            for(int j = 2; j < K + 1; j++){
//                int min = Integer.MAX_VALUE;
//                for(int l = 1; l <= i; l++){
//                    min = Math.min(min, Math.max(dp[i - l][j], dp[l - 1][j - 1]));
//                }
//                dp[i][j] = min + 1;
//            }
//        }
//        return dp[N][K];
//    }

    public static int solve (int n, int k) {//k个棋子一直丢，得到解决的楼层 直到大于n
        // write code here
        if (n < 1 || k < 1)
            return 0;
        int count = (int) (Math.log(n) / Math.log(2) + 1);
        if (count <= k)
            return count;
        int[] dp = new int[k];//这里定义一个数组，循环使用，因为不知道这k个棋子需要丢多少次，所以不能定义二维数组。
        int res = 1;
        while (true){
            int pre = 0;
            for(int i = 0; i < k; i++){
                int tem = dp[i];//每次保存下来当前的值，不然dp[i]就已经变了
                dp[i] = dp[i] + pre + 1;
                pre = tem;//将保存下来的值作为新的pre，计算下一个值。
                if(dp[i] >= n )
                    return res;
            }
            res++;
        }
    }

    public static void main(String[] args) {
        int solve = solve(12, 2);
        System.out.println(solve);
    }
}
