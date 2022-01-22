import java.util.ArrayList;

/**
 * @author dingxudong
 * @create 2021-09-14 22:52
 * @Description
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())",
 */
public class NC26 {
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        StringBuilder sb = new StringBuilder();
        recur(sb, 0, 0, n);
        return res;
    }
    private void recur(StringBuilder sb, int left, int right, int n){
        if(sb.length() == 2 * n){
            res.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append('(');
            recur(sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(')');
            recur(sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
