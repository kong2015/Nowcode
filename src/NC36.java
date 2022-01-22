/**
 * @author dingxudong
 * @create 2021-09-12 19:40
 * @Description
 *
 * 给定两个有序数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
 * 上中位数：假设递增序列长度为n，若n为奇数，则上中位数为第n/2+1个数；否则为第n/2个数
 * [要求]
 * 时间复杂度为O(logN)O(logN)，额外空间复杂度为O(1)O(1)
 */
public class NC36 {
    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        // write code here
        int i = 0;
        int j = 0;
        int n = arr2.length;
        while(i + j < n - 1){
            if(arr1[i] > arr2[j]){
                j++;
            }else{
                i++;
            }
        }
        return Math.min(arr1[i], arr2[j]);
    }
}