package DaChang;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dxd
 * @create 2021-09-19 20:27
 */
public class QiAnXin {
    /**
     * 数组排列
     */
    ArrayList<String> res = new ArrayList<>();
    public String[] Permutation (char[] seed, int size) {
        // write code here
        Arrays.sort(seed);
        boolean[] visited = new boolean[seed.length];
        StringBuilder sb = new StringBuilder();
        dfs(seed, sb, visited, size);
        System.out.println(res);
        String[] data = new String[res.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = res.get(i);
        }
        return data;
    }
    public void dfs(char[] seed, StringBuilder sb, boolean[] visited, int size){
        if(size == sb.length()){
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < seed.length; i++) {
            if (visited[i]){
                continue;
            }
            if(i > 0 && seed[i] == seed[i - 1] && !visited[i - 1])
                continue;
            visited[i] = true;
            sb.append(seed[i]);
            dfs(seed, sb,visited,size);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        QiAnXin test = new QiAnXin();
        char[] seed = {'1', '2', '3'};
        test.Permutation(seed, 2);
    }

    /**
     * 约瑟夫
     * @param M
     * @param N
     * @return
     */
    public int DoPermute (int M, int N) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        int id = 0;
        while(N > 1){
            id = (id + M - 1) % N;
            list.remove(id);
            N--;
            M++;//变化
        }
        return list.get(0);
    }
}
