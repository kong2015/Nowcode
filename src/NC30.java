/**
 * @author dingxudong
 * @create 2021-09-15 17:40
 * @Description
 * 给定一个无序数组arr，找到数组中未出现的最小正整数
 * 例如arr = [-1, 2, 3, 4]。返回1
 * arr = [1, 2, 3, 4]。返回5
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */
public class NC30 {
//    public int minNumberdisappered (int[] arr) {
//        // write code here
//        int min = 1;
//        HashSet<Integer> set = new HashSet<>();
//        for(int i = 0; i < arr.length; i++){
//            set.add(arr[i]);
//            while(set.contains(min)){
//                min++;
//            }
//        }
//        return min;
//    }

    public static int minNumberdisappered (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] >= 1 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]){
                int tem = arr[i];//这里不能用arr[i] = arr[arr[i] - 1];所以最好使用下面的swap函数
                arr[i] = arr[tem - 1];
                arr[tem - 1] = tem;
            }
        }
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != i + 1){
                return i + 1;
            }
        }
        return arr.length + 1;
    }
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}