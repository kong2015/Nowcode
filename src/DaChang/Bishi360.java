package DaChang;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dxd
 * @create 2021-09-01 21:13
 */

public class Bishi360 {
    /**
     * 数组左右有几个比他小的
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num + 2];
        for (int i = 1; i < num + 1; i++) {
            arr[i] = sc.nextInt();
        }
        arr[0] = Integer.MAX_VALUE;
        arr[arr.length -1] = Integer.MAX_VALUE;
        int max = 0;
        int cur = 0;
        for (int i = 1; i < num + 1; i++) {
            int l = i,r = i;
            while (true){
                if (l > 1 && arr[l] > arr[l - 1]){
                    l--;
                }else {
                    break;
                }
            }
            while (true){
                if (r <= num && arr[r] > arr[r + 1]){
                    r++;
                }else {
                    break;
                }
            }
            max = Math.max(max, r - l + 1);
        }
        System.out.println(max);
    }

    /**
     *
     * yeah数列：除了第一个和最后一个数组外，其他元素至少比相邻的一个元素大。
     * 求一个数组经过几步能变成yeah
     * 5
     * 2 3 0 1 5
     * @param args
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] arr = new long[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextLong();
        }
        long result = 0L;
        long[] dp = new long[num];
        for (int i = num - 1; i >= 0; i--){
            if (i == num - 1){
                dp[i] = arr[i];
            }else{
                long temp1 = dp[i + 1] - 1;
                long temp2 = arr[i];
                if(temp2 <= temp1){
                    dp[i] = temp2;
                }else {
                    dp[i] = temp1;
                    result = result + temp2 - temp1;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            long cur = 0L;
            if (i == 0){
                cur = result - (arr[i] - dp[i]);
                dp[i] = arr[i];
            }else {
                if (arr[i] >= dp[i - 1] - 1){
                    cur = result + dp[i] - dp[i - 1] + 1;
                    dp[i] = dp[i - 1] -1;
                }else {
                    cur = result - arr[i] + dp[i];
                    dp[i] = arr[i];
                }
            }
            result = Math.min(result, cur);
        }
        System.out.println(result);
    }

    /**
     * 可以判断出来yeah数组一定是一段递减接一段递增的。
     * 考虑递增方向最右边的值因为a[i] > a[i-1] 因此必定满足a[i] < a[i+1]，所以此序列到数组末尾都将继续递增；
     * 同理考虑递减方向也会递减到数组首部，而递减序列和递增序列的交合处是满足条件的。
     * 想到这里代码就好写了，
     * 可以求出从i处开始构成递增序列所需要的步数和i之前构成递减序列的步数，
     * 加在一起就构成了可能的答案，遍历取最小值
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] arr1 = new long[num + 2];
        arr1[0] = Integer.MAX_VALUE;
        arr1[arr1.length -1] = Integer.MAX_VALUE;
        for (int i = 1; i <= num; i++) {
            arr1[i] = sc.nextLong();
        }
        long[] arr2 = Arrays.copyOf(arr1,arr1.length);
        long[] dp1 = new long[num + 1];
        long cost = 0;
        for (int i = 1; i <= num ; i++) {
            if (arr1[i] >= arr1[i - 1]){//要变成递减
                cost = cost + arr1[i] - arr1[i - 1] + 1;
                arr1[i] = arr1[i - 1] - 1;
            }
            dp1[i] = cost;
        }
        long[] dp2 = new long[num + 1];
        cost = 0;
        for (int i = num; i >= 1 ; i--) {
            if (arr2[i] >= arr2[i + 1]){//要变成递曾
                cost = cost + arr2[i] - arr2[i + 1] + 1;
                arr2[i] = arr2[i + 1] - 1;
            }
            dp2[i - 1] = cost;
        }
        dp2[num] = 0;
        long result = Long.MAX_VALUE;
        for (int i = 0; i <= num; i++) {
            result = Math.min(result, dp1[i] + dp2[i]);
        }
        System.out.println(result);
    }
}
