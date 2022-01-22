import java.util.ArrayList;

/**
 * @author dingxudong
 * @create 2021-09-14 23:09
 * @Description
 * 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
 * 例如：
 * 给出的字符串为"25525522135",
 * 返回["255.255.22.135", "255.255.221.35"]. (顺序没有关系)
 */
public class NC20 {
    ArrayList<String> res = new ArrayList<>();
    int[] segment = new int[4];
    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        dfs(s, 0, 0);
        return res;
    }
    private void dfs(String s, int id, int start){
        if(id == 4 && start == s.length()){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++){
                sb.append(segment[i]);
                if(i != 3){
                    sb.append(".");
                }
            }
            res.add(sb.toString());
            return;
        }
        if(id == 4 || start == s.length()){
            return;
        }
        if(s.charAt(start) == '0'){
            segment[id] = 0;
            dfs(s, id + 1, start + 1);
        }
        int num = 0;
        for(int i = start; i < s.length(); i++){
            num = num * 10 + s.charAt(i) - '0';
            if(num > 0 && num <= 0xFF){
                segment[id] = num;
                dfs(s, id + 1, i + 1);
            }else{//break非常重要
                break;
            }
        }
    }

    public static void main(String[] args) {
        NC20 nc20 = new NC20();
        ArrayList<String> strings = nc20.restoreIpAddresses("010010");
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }
}