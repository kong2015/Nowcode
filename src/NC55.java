import java.util.Arrays;

/**
 * @author dingxudong
 * @create 2021-09-23 11:37
 * @Description
 * 给你一个长度为 nn 的字符串数组 strsstrs , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
 */
public class NC55 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
//        Arrays.sort(strs, (x,y)-> x.length() - y.length());//错误
        Arrays.sort(strs);
        int len = strs.length;
        int l = Math.min(strs[0].length(), strs[len - 1].length());
        int i = 0;
        for(i = 0; i < l; i++){
            if(strs[0].charAt(i) != strs[len - 1].charAt(i))
                break;
        }
        return strs[0].substring(0,i);
    }

    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"abca", "abca", "abc", "abcc", "c"});
        for (char c : s.toCharArray()) {
            System.out.println("c = " + c);
        }
    }
}
