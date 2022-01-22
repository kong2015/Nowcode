package DaChang;

import java.util.*;

/**
 * @author dingxudong
 * @create 2021-10-28 21:13
 * @Description
 */
public class mapPaiXu {
    public static String[] get1(String[] strs){
        HashMap<String, Double>map = new HashMap<>();
        for (String str : strs) {
            double zi = 0;
            double shu = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c <= '9' && c >= '0'){
                    shu++;
                }else if (c >= 'a' && c <= 'z'){
                    zi++;
                }
            }
            map.put(str, zi/shu);
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                if (o1.getValue().compareTo(o2.getValue()) < 0){
                    return -1;
                }else if (o1.getValue().compareTo(o2.getValue()) > 0){
                    return 1;
                }else {
                    return o1.getKey().length() - o2.getKey().length();
                }
            }
        });
        String[] res = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"abc123","abc+1234","ababab-1","ad12"};
        String[] res = get(arr);
        for (String re : res) {
            System.out.println(re);
        }
    }
    public static String[] get(String[] strs){
        HashMap<String, Double>map = new LinkedHashMap<>();
        Double[] values = new Double[strs.length];
        int p = 0;
        int q = 0;
        for (String str : strs) {
            double zimu = 0;
            double shuzi = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c <= '9' && c >= '0'){
                    shuzi++;
                }else if (c >= 'a' && c <= 'z'){
                    zimu++;
                }else {
                    continue;
                }
            }
            map.put(str, zimu/shuzi);
            values[p++] = zimu/shuzi;
        }
//        Arrays.sort(values, Collections.reverseOrder());//必须使用包装类
        Arrays.sort(values,(x,y) -> (int) (y - x));//必须使用包装类
//        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
        String[]res = new String[strs.length];
        for(int j = values.length - 1; j >= 0; j--){
            int l = j;
            while (l > 0 && values[l] == values[l - 1]){
                l--;
            }
            int cur = j - l + 1;
            j = l;
            double val = values[j];
            String[] tem = new String[cur];
            int k = 0;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (k < cur){
                    if (entry.getValue() == val){
                        tem[k++] = entry.getKey();
                    }
                }else {break;}
            }
            Arrays.sort(tem, (x, y) -> y.length() - x.length());
            for (int m = 0; m < cur; m++) {
                res[q++] = tem[m];
            }
        }
        return res;
    }
}
