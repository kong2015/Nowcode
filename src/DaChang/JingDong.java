package DaChang;

import java.util.*;

/**
 * @author dingxudong
 * @create 2021-10-09 22:23
 * @Description
 */
public class JingDong {
    /**
     * 6
     * 3 2 1 2 2 3
     * 找到一个数字出现次数最多的虽短子序列。
     * 需要输出 2 1 2 2这个子序列的开头和结尾位置 2 和 5. 需要保证子序列中一个数（2）出现了3次，原始序列中2出现了3次。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] targetArray = new int[n];
        for (int i = 0; i < n; i++) {
            targetArray[i] = sc.nextInt();
        }
        System.out.println(getRes(targetArray));
    }

    private static String getRes(int[] targetArray) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int i : targetArray) {
            if (resMap.containsKey(i)) {
                resMap.put(i, resMap.get(i) + 1);
            } else {
                resMap.put(i, 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> iE : resMap.entrySet()) {
            Integer value = iE.getValue();
            if (value > max) {
                max = value;
            }
        }
        int bigTarget = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> iE : resMap.entrySet()) {
            Integer value = iE.getValue();
            Integer key = iE.getKey();
            if (value == max) {
                int l = 0;
                int r = targetArray.length - 1;
                for (int i = 0; i < targetArray.length; i++) {
                    if (key == targetArray[i]) {
                        l = i + 1;
                        break;
                    }
                }
                for (int i = targetArray.length - 1; i >= 0; i--) {
                    if (key == targetArray[i]) {
                        r = i + 1;
                        break;
                    }
                }
                if ((r - l) < bigTarget) {
                    bigTarget = r-l;
                    sb = new StringBuilder(l + " " + r);
                }
            }
        }
        return sb.toString();
    }
    /**
     * 8 2 3
     * 1 1 5 8 12 13 20 22
     * 堆积木，有n个积木，有k个填充积木，上面的积木减去下面的积木不能超过x，超过以后算第二堆。填充积木是万能的数字。
     * 问最少有几堆积木。
     * 积木排序以后 把积木的差值加入list中，排序，从list中最小的一次开始插入一个万能，插入两个万能，类推。
     * @param args
     */
    public static void Duijimu(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > x){
                list.add(arr[i] - arr[i - 1]);
            }
        }
        Collections.sort(list);
        if (list.size() == 0)
            System.out.println(1);
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i) / x;
            int b = list.get(i) % x;
            if (b == 0){
                k = k - a - 1;
            }else {
                k = k - a;
            }
            if (k <= 0){
                System.out.println(list.size() - i);
                return;
            }
        }
    }
}
