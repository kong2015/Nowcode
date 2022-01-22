/**
 * @author dingxudong
 * @create 2021-09-05 23:04
 * @Description
 *
 * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class NC128 {
    public long maxWater (int[] arr) {
        // write code here
        int left = 0;
        int right = arr.length - 1;
        long res = 0;
        while(left <= right){
            int small = arr[left] < arr[right] ? arr[left] : arr[right];
            while(left <= right && arr[left] <= small){
                res += small - arr[left];
                left++;
            }
            while(left <= right && arr[right] <= small){
                res += small - arr[right];
                right--;
            }
        }
        return res;
    }
}