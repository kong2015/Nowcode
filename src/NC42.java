import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dingxudong
 * @create 2021-09-21 18:06
 * @Description
 * 给出一组可能包含重复项的数字，返回该组数字的所有排列。
 */
public class NC42 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(num, list, visited);
        return res;
    }
    private void dfs(int[] num, ArrayList<Integer> list, boolean[] visited){
        if(num.length == list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(visited[i])
                continue;
            if(i > 0 && num[i] == num[i - 1] && !visited[i - 1])//注意这里的!visited[i - 1]  使得1 1 2必须执行，所以第二个1不能进入循环体
                continue;//visited[i - 1]==true表示这不是第一层递归了，不是重复的排列。反之visited[i - 1]==false表示这是重新开始的第一层递归，是不允许的
            visited[i] = true;
            list.add(num[i]);
            dfs(num, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        NC42 nc42 = new NC42();
        int[] ints = {1, 1, 2};
        System.out.println(nc42.permuteUnique(ints));
    }
}
