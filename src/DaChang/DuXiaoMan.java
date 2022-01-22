package DaChang;

import java.util.Scanner;

/**
 * @author dxd
 * @create 2021-10-23 15:34
 */
public class DuXiaoMan {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String name = sc.next();
//        String stones = sc.next();
//        char[] arr = stones.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (char c : arr) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        char[] names = name.toCharArray();
//        int min = Integer.MAX_VALUE;
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        for (char c : names) {
//            map1.put(c, map1.getOrDefault(c, 0) + 1);
//        }
//        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
//            Integer value = entry.getValue();
//            Character key = entry.getKey();
//            if (map.containsKey(key)){
//                if (map.get(key) < value){
//                    break;
//                }else {
//                    if (min > map.get(key) / value){
//                       min = map.get(key) / value;
//                    }
//                }
//            }else {
//                break;
//            }
//        }
//        int res = map.size();
//        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
//            Character key = entry.getKey();
//            Integer value = entry.getValue();
//            if (map.containsKey(key)){
//                if (min * value >= map.get(key)){
//                    map.remove(key);
//                }
//            }
//        }
//        System.out.print(min + " ");
//        System.out.print(map.size());
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr1 = new int[2 * a];
        int[] arr2 = new int[2 * b];
        for (int i = 0; i < a; i++) {
            String next = sc.next();
            String[] split = next.split("-");
            String[] split1 = split[0].split(":");
            String s = split1[0];
            char[] arr = s.toCharArray();
            if (arr[0] == '0'){
                arr1[i] = Integer.parseInt(String.valueOf(arr[1])) * 60;
            }else {
                arr1[i] = Integer.parseInt(s) * 60;
            }
            String s1 = split1[1];
            arr1[i] += Integer.parseInt(s1);

            String[] split2 = split[1].split(":");
            String s3 = split2[0];
            char[] arr3 = s3.toCharArray();
            if (arr3[0] == '0'){
                arr1[i + 1] = Integer.parseInt(String.valueOf(arr3[1])) * 60;
            }else {
                arr1[i + 1] = Integer.parseInt(s) * 60;
            }
            String s4 = split1[1];
            arr1[i + 1] += Integer.parseInt(s4);
        }

        for (int i = 0; i < b; i++) {
            String next = sc.next();
            String[] split = next.split("-");
            String[] split1 = split[0].split(":");
            String s = split1[0];
            char[] arr = s.toCharArray();
            if (arr[0] == '0'){
                arr2[i] = Integer.parseInt(String.valueOf(arr[1])) * 60;
            }else {
                arr2[i] = Integer.parseInt(s) * 60;
            }
            String s1 = split1[1];
            arr2[i] += Integer.parseInt(s1);

            String[] split2 = split[1].split(":");
            String s3 = split2[0];
            char[] arr3 = s3.toCharArray();
            if (arr3[0] == '0'){
                arr2[i + 1] = Integer.parseInt(String.valueOf(arr3[1])) * 60;
            }else {
                arr2[i + 1] = Integer.parseInt(s) * 60;
            }
            String s4 = split1[1];
            arr2[i + 1] += Integer.parseInt(s4);
        }
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < 2 * a || j < 2 * b){
            if (i >= 2 * a){
                res += (2 * b - j - 1) / 2;
                break;
            }else if (j >= 2 * b){
                res += (2 * a - i - 1) / 2;
                break;
            }else if (arr1[i] <= arr2[j]){
                i+=2;
                res++;
            }else {
                j+=2;
                res++;
            }
        }
        System.out.println(res);
    }
}
/**
 * 3 4
 * 08:00-09:00
 * 09:30-11:00
 * 13:00-15:00
 * 07:00-08:00
 * 08:00-11:00
 * 12:00-13:30
 * 14:00-17:00
 */