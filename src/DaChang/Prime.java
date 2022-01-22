package DaChang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dingxudong
 * @create 2021-09-01 22:51
 * @Description
 */
public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        StringBuilder bf = new StringBuilder();
        int i=2;
        bf.append(num).append("=");
        while (i<=num ) {
            if (i==num) {
                bf.append(i);
                break;
            }else if (num%i==0){
                bf.append(i).append("*");
                num/=i;
            }else {
                i++;
            }
        }
        System.out.println(bf.toString());

//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        StringBuilder cache = new StringBuilder();
//        cache.append(num).append("=");
//        if (num < 4) {
//            cache.append(num);
//        } else {
//            List<Integer> primeList = getPrime(num);
//            int i = 0;
//            while (num % primeList.get(i) != 0) {
//                ++i;
//            }
//            cache.append(primeList.get(i));
//            num = num / primeList.get(i);
//            while(num != 1) {
//                while (num % primeList.get(i) != 0) {
//                    ++i;
//                }
//                cache.append("*").append(primeList.get(i));
//                num /= primeList.get(i);
//            }
//        }
//        System.out.println(cache);
    }
    static List<Integer> getPrime(int num) {
        int m = (int)Math.sqrt(num + 0.5);
        boolean[] vis = new boolean[num + 1];
        for (int i = 2; i <= m; ++i) {
            if (!vis[i]) {
                for (int j = i * i; j <= num; j += i) {
                    vis[j] = true;
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 2; i <= num; ++i) {
            if (!vis[i]) {
                ret.add(i);
            }
        }
        return ret;
    }
}
