import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dingxudong
 * @create 2021-09-05 17:08
 * @Description
 *
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 */
public class NC41 {
    public class Solution {
        public int maxLength (int[] arr) {
            int max = Integer.MIN_VALUE;
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 0; i < arr.length; i++){
                while(deque.contains(arr[i])){
                    deque.pollFirst();
                }
                deque.offerLast(arr[i]);
                max = Math.max(max, deque.size());
            }
            return max;
            // write code here
        }
    }
}
