import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dingxudong
 * @create 2021-09-27 12:23
 * @Description
 * [1,2,3]
 * [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
 */
public class NC27 {
//    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
//        ArrayList<Integer> list = new ArrayList<>();
//        Arrays.sort(S);
//        dfs(list, S, 0);
//        return res;
//    }
//    public void dfs(ArrayList<Integer> list, int[] num, int start){
//        res.add(new ArrayList<>(list));//没遇到一种可能的晴空都记录下来
//        for (int i = start; i < num.length; i++){
//            list.add(num[i]);
//            dfs(list, num, i + 1);
//            list.remove(list.size() - 1);
//        }
//    }


    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= S.length; i++){//i用来保存需要的长度
            backtrace(i,  0, list, S);
        }
        return res;
    }
    public void backtrace(int length, int start, ArrayList<Integer>list, int[] S){
        if (length == list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < S.length; i++) {
            list.add(S[i]);
            backtrace(length, i + 1, list, S);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        NC27 nc27 = new NC27();
        ArrayList<ArrayList<Integer>> subsets = nc27.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
