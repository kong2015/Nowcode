/**
 * @author dingxudong
 * @create 2021-09-11 10:32
 * @Description
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，则其数值范围为[−2^{31}, 2^{31} − 1][−2
 * 31
 *  ,2
 * 31
 *  −1]。翻转可能会导致溢出，如果反转后的结果会溢出就返回 0
 */
public class NC57 {
//    public static int reverse (int x) {
//        // write code here
//        long a = 0L;
//        while(x != 0){
//            a = 10 *a + x % 10;
//            x /= 10;
//        }
//        return a == (int) a ?(int) a :0;//123456789 反转后不可存
//    }

    public static int reverse (int x) {
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();
        int flag = 1;
        if (arr[0] == '-'){
            flag = -1;
            arr = s.substring(1).toCharArray();
        }
        int i = 0;
        int j = arr.length - 1;
        while (i < j){
            char tem = arr[i];
            arr[i] = arr[j];
            arr[j] = tem;
            i++;
            j--;
        }
        long res = flag * Long.parseLong(new String(arr));
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0: (int)res;
    }
}