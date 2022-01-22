/**
 * @author dingxudong
 * @create 2021-09-05 16:57
 * @Description
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 */

import java.util.ArrayList;
import java.util.Arrays;

public class NC54 {
    public class Solution {
        public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            Arrays.sort(num);
            for(int i = 0; i < num.length; i++){
                if(num[i] > 0){
                    break;
                }
                if(i > 0 && num[i] == num[i - 1]){
                    continue;
                }
                int left = i + 1;
                int right = num.length - 1;
                while(left < right){
                    int sum = num[i] + num[left] + num[right];
                    if(sum < 0){
                        left++;
                    }else if(sum > 0){
                        right--;
                    }else{
                        ArrayList<Integer>list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[left]);
                        list.add(num[right]);
                        res.add(list);
                        left++;
                        right--;
                        while(left < right && num[left] == num[left - 1] && num[right] == num[right + 1]){
                            left++;
                            right--;
                        }
                    }
                }
            }
            return res;
        }
    }
}