import java.util.HashSet;

/**
 * @author dingxudong
 * @create 2021-09-23 11:27
 * @Description
 * 给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数）
 */
public class NC95 {
    public int MLS (int[] arr) {
        // write code here
        if(arr.length <= 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int cur = 1;
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i] - 1)){
                while (set.contains(++arr[i])){
                    cur++;
                }
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        return max;
    }
//    public int MLS (int[] arr) {
//        // write code here
//        if(arr.length <= 0){
//            return 0;
//        }
//        Arrays.sort(arr);
//        int max = 0;
//        int i = 1;
//        int cur = 1;
//        while(i < arr.length){
//            if(arr[i] == arr[i - 1]){
//                i++;
//                continue;
//            }
//            if(arr[i] == arr[i - 1] + 1){
//                cur++;
//            }else{
//                cur = 1;
//            }
//            max = Math.max(cur, max);
//            i++;
//        }
//        return max;
//    }
}
