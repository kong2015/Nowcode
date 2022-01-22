import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author dingxudong
 * @create 2021-09-07 16:20
 * @Description
 * 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * 1. set(key, value)：将记录(key, value)插入该结构
 * 2. get(key)：返回key对应的value值
 */
public class NC93 {
    public static int[] LRU (int[][] operators, int k) {
        // write code here
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            int[] operator = operators[i];
            int flag = operator[0];
            int key = operator[1];
            switch (flag){
                case 1:
                    int val = operator[2];
                    if (map.size() >= k){
                        Iterator<Integer> iterator = map.keySet().iterator();
                        map.remove(iterator.next());
                    }
                    map.put(key, val);
                    break;
                case 2:
                    if (map.containsKey(key)){
                        int value = map.get(key);
                        list.add(value);
                        map.remove(key);
                        map.put(key,value);
                    }else {
                        list.add(-1);
                    }
                    break;
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int val : list) {
            res[i++] = val;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,1},{1,1,2},{2,1}
        };
        int[] lru = LRU(matrix, 3);
        for (int i : lru) {
            System.out.println(i);
        }
    }
}
