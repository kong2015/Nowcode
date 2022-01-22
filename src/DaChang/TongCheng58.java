package DaChang;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author dxd
 * @create 2021-09-23 22:06
 */
public class TongCheng58 {
    public int[] subArraySum(int[] Array, int arrayLen, int subArrayLen){

        // write code here
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < subArrayLen; i++) {
            sum += Array[i];
        }
        for (int i = subArrayLen; i < arrayLen; i++) {
            sum -= Array[i - subArrayLen];
            sum += Array[i];
            if (sum > max){
                max = sum;
                index = i - subArrayLen + 1;
            }
        }
        return new int[]{index,max};
    }
    public int[] find (int[] arg) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : arg) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int e : arg){
            if (map.get(e) == 1){
                list.add(e);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int getTeams (int[] heros) {
        // write code here
        if (heros == null || heros.length < 5){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int hero : heros) {
            map.put(hero, map.getOrDefault(hero, 0) + 1);
        }
        int res = 1;
        for (Integer value : map.values()) {
            res *= value;
        }
        return res;
    }
}
