import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dingxudong
 * @create 2021-09-22 16:54
 * @Description
 * 输入：
 * [100,10,20,70,60,10,50],80
 * 返回值：
 * [[10,10,60],[10,20,50],[10,70],[20,60]]
 * 说明：
 * 给定的候选数集是[100,10,20,70,60,10,50]，目标数是80
 */
public class NC46 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if(num == null || num.length == 0){
            return null;
        }
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<>();
        dfs(num, list, target,0);//此处有start的主要原因是[a ,b]  [b,a]是一样的，所以第二种不再考虑.
        return res;
    }
    private void dfs(int[] num, ArrayList<Integer>list, int target, int start){
        if (target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(target < 0)
            return;
        if(start >= num.length){
            return;
        }
        for(int i = start; i < num.length; i++){
            if(i >= 1 && num[i] == num[i - 1] && i > start){
               continue;//这里用return是错误的;
            }
            if(target >= num[i]){
                list.add(num[i]);
                dfs(num, list, target - num[i], i + 1);
                list.remove(list.size() - 1);
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        NC46 nc46 = new NC46();
        int[] num = new int[]{100,10,20,70,60,10,50};
        ArrayList<ArrayList<Integer>> arrayLists = nc46.combinationSum2(num, 80);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList);
        }
    }

}
