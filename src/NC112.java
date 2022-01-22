/**
 * @author dingxudong
 * @create 2021-09-06 12:19
 * @Description
 *
 * 给定一个十进制数 M ，以及需要转换的进制数 N 。将十进制数 M 转化为 N 进制数。
 *
 * 当 N 大于 10 以后， 应在结果中使用大写字母表示大于 10 的一位，如 'A' 表示此位为 10 ， 'B' 表示此位为 11 。
 *
 * 若 M 为负数，应在结果中保留负号。
 */
public class NC112 {
//    public String solve (int M, int N) {
//        // write code here
//        Integer ans=M;
//        return ans.toString(M,N).toUpperCase();
//    }

    public static String solve (int M, int N) {
        // write code here
        if (M == 0) {
            return null;
        }
        String s = "0123456789ABCDEF";
        StringBuilder res = new StringBuilder();
        int flag = 1;
        if (M < 0){
            flag = -1;
            M = -M;
        }
        int num;
        while(M != 0){
            num = M % N;
            res.append(s.charAt(num));
            M /= N;
        }
        return flag == 1? res.reverse().toString():"-"+res.reverse().toString();
    }

}
