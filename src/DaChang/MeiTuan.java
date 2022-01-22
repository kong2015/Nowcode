package DaChang;

import java.util.*;

/**
 * @author dxd
 * @create 2021-10-09 20:12
 */
public class MeiTuan {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] friends = new int[n];
//        for (int i = 0; i < n; i++) {
//            friends[i] = sc.nextInt();
//        }
//        int[] gifts = new int[m];
//        for (int i = 0; i < m; i++) {
//            gifts[i] = sc.nextInt();
//        }
//        int[] mins = new int[n];
//        for (int i = 0; i < n; i++) {
//            mins[i] = sc.nextInt();
//        }
//        Arrays.sort(gifts);
//        for (int i = 0; i < n; i++) {
//            int num = friends[i];
//            int price = mins[i];
//            int prices = 0;
//            for (int j = 0; j < m; j++) {
//                if (gifts[j] >=price){
//                    int cishu = 0;
//                    while (j < m && cishu < num){
//                        prices+=gifts[j];
//                        j++;
//                        cishu++;
//                    }
//                    if (cishu == num){
//                        System.out.print(prices+" ");
//                    }else {
//                        System.out.print(-1 + " ");
//                    }
//                    break;
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int count = 0;
//        Arrays.sort(arr);
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (arr[i] + arr[j] <= m){
//                    count++;
//                }else {
//                    break;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] weights = new int[n];
//        for (int i = 0; i < n; i++) {
//            weights[i] = sc.nextInt();
//        }
//        int[] nums = new int[n];
//        HashSet<Integer>set = new HashSet<>();
//        for (int i = 0; i < n - 1; i++) {
//            nums[i] = sc.nextInt();
//            set.add(nums[i]);
//        }
//        for (int i = 0; i < n; i++) {
//            if (!set.contains(i + 1)){
//                nums[n - 1] = i + 1;
//            }
//        }
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            int max = 0;
//            int index = 0;
//            for (int j = i; j < n; j++) {
//                if (weights[nums[j] - 1] > max){
//                    max = weights[nums[j] - 1];
//                    index = nums[j] - 1;
//                    res[nums[j] - 1]++;
//                }else {
//                    res[index]++;
//                }
//            }
//        }
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + " ");
//        }
////    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int k = sc.nextInt();
//        int[] trueA1 = new int[n];
//        int[] trueA2 = new int[n];
//        int[] trueAct = new int[n];
//        for (int i = 0; i < n; i++) {
//            trueA1[i] = sc.nextInt();
//            trueA2[i] = sc.nextInt();
//            trueAct[i] = sc.nextInt();
//        }
//        int[] realA1 = new int[m];
//        int[] realA2 = new int[m];
//        int[] realAct = new int[m];
//        for (int i = 0; i < m; i++) {
//            realA1[i] = sc.nextInt();
//            realA2[i] = sc.nextInt();
//            realAct[i] = sc.nextInt();
//        }
//        for (int i = 0; i < n && i < m; i++) {
//            if (trueA1[i] <= realA1[i]){
//                if (trueA2[i] <= realA2[i]){
//
//                }else {
//
//                }
//            }else {
//                if (trueA2[i] <= realA2[i]){
//                    if (trueAct[i] == realAct[i]){
//
//                    }
//
//                }else {
//
//                }
//            }
//        }
//        System.out.println(1024);
//    }

    /**
     * @author dxd
     * @create 2021-10-11 16:58
     */
    public static class QuNaEr {
        public static void calculate(String[] args) {//计算器
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            s.trim();
            char[] chars = s.toCharArray();
            if (chars[0] == '(' && chars[chars.length - 1] != ')') {
                System.out.println("invalid expression");
            }
            if (chars[0] != '(' && (chars[0] > '9' || chars[0] < '0')) {
                System.out.println("invalid expression");
            }
            int i = 0;
            Stack<Integer> stack = new Stack<>();
            while (i < chars.length) {
                if (chars[i] == '(') {
                    char nextc = chars[++i];
                    if (nextc == '-') {
                        int a = chars[++i] - '0';
                        int b = chars[++i] - '0';
                        if (chars[++i] != ')') {
                            System.out.println("invalid expression");
                        }
                        stack.push(a - b);
                    }
                    if (nextc == '/') {
                        int a = chars[++i] - '0';
                        int b = chars[++i] - '0';
                        if (chars[++i] != ')') {
                            System.out.println("invalid expression");
                        } else if (b == 0) {
                            System.out.println("division by zero");
                        }
                        stack.push(a / b);
                    }
                }
                i++;
            }
        }

    //    aabAa
    //    aaaAb 100过了AC
        public static void PaiXuString(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            HashMap<Character, Integer> map1 = new HashMap<>();
            for(Character c: s.toCharArray()){
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }
            int[] values = new int[map1.size()];
            char[] keys = new char[map1.size()];
            int i = 0;
            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                values[i] = entry.getValue();
                keys[i] = entry.getKey();
                i++;
            }
            Arrays.sort(values);
            StringBuilder sb = new StringBuilder();
            for (int j = values.length - 1; j >= 0; j--) {
                int l = j;
                while (l > 0 && values[l] == values[l - 1]){
                    l--;
                }
                int cur = j - l + 1;
                j = l;//不能忘记
                int val = values[j];
                int[] tmp = new int[cur];
                int k = 0;
                for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                    if (k < cur){
                        if (entry.getValue() == val){
                            tmp[k++] = entry.getKey();
                        }
                    }else {
                        break;
                    }
                }
                Arrays.sort(tmp);
                for (int m = 0; m < cur; m++) {
                    for (int n = 0; n < val; n++) {
                        sb.append((char)tmp[m]);
                    }
                }
            }
            System.out.println(sb.toString());
        }
        //6,[1, 3, 5, 0, 0, 0], 3   和  3,[2, 4, 6],3
        //原地排序有序数组 过了80
        public static int[] mergeSortedArray(int[] a, int m, int[] b, int n) {
            if (m+n != a.length)
                return new int[0];
            for (int i = m; i < a.length; i++) {
                a[i] = a[i - m];
            }
            int i = m;
            int j = 0;
            int l = 0;
            while (i < a.length || j < n){
                if (i >= a.length){
                    a[l] = b[j];
                    j++;
                    l++;
                }else if (j >= n){
                    a[l] = a[i];
                    i++;
                    l++;
                }else if (a[i] <= b[j]){
                    a[l] = a[i];
                    i++;
                    l++;
                }else {
                    a[l] = b[j];
                    j++;
                    l++;
                }
            }
            return a;
        }

    }
}

