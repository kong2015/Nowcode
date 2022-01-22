package DaChang;

import java.util.Scanner;

/**
 * @author dxd
 * @create 2021-09-24 22:31
 */
public class ALI {
    /**
     * 两种颜色 上色 相邻颜色涂一次就够，两种图法
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String color = sc.next();
        char[] arr = color.toCharArray();
        if (num == 1)
            System.out.println(1);
        int i = 0;
        int rnum = 0;
        int bnum = 0;
        while (i < arr.length){
            if (arr[i] == 'R'){
                while (i < arr.length && arr[i] == 'R'){
                    i++;
                }
                rnum++;
            }else {
                while (i < arr.length && arr[i] == 'B'){
                    i++;
                }
                bnum++;
            }
        }
        System.out.println(Math.min(bnum, rnum) + 1);
    }
}
