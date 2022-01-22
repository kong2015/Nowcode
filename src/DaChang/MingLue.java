package DaChang;

import java.util.Scanner;

/**
 * @author dxd
 * @create 2021-09-27 18:04
 */
public class MingLue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            System.out.println(getDump(sc.nextInt()));
        }
    }
    public int maxProfit (int[] prices) {//全部通过
        // write code here
        if (prices == null || prices.length < 2)
            return 0;
        int profit1 = 0;
        int profit2 = 0;
        int cost1 = - prices[0];
        int cost2 = - prices[0];
        for (int price : prices) {
            cost1 = Math.max(cost1, (-1) * price);
            profit1 = Math.max(profit1, price + cost1);
            cost2 = Math.max(cost2, profit1 - price);
            profit2 = Math.max(profit2, price + cost2);
        }
        return profit2;
    }

    public static int getDump(int num){
        if (num == 1)
            return 1;
        int a = 1;
        int b = 1;
        int sum = 2;
        int i = 1;
        while (i < num){
            sum = a + b;
            a = b;
            b = sum;
            i++;
        }
        return sum;
    }
}
