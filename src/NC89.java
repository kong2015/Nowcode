/**
 * @author dingxudong
 * @create 2021-09-22 18:01
 * @Description
 * NC89 字符串变形
 */
public class NC89 {
    public String trans(String s, int n) {
        // write code here
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = s.length() - 1;
        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            res.append(s.substring(i + 1, j + 1));
            j = i;
            char tem;
            while(i >= 0 && s.charAt(i) != ' '){
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    tem = (char) (s.charAt(i) - 32);
                    sb.append(tem);
                }else{
                    tem = (char) (s.charAt(i) + 32);
                    sb.append(tem);
                }
                i--;
            }
            res.append(sb.reverse());
            sb = new StringBuilder();
            j = i;
        }
        return res.toString();
    }

    public static void main(String[] args) {
    }
}
