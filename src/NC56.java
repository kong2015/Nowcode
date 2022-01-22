/**
 * @author dingxudong
 * @create 2021-09-20 10:36
 * @Description
 * 在不使用额外的内存空间的条件下判断一个整数是否是回文。
 * 回文指逆序和正序完全相同。
 */
public class NC56 {
    public static boolean isPalindrome (int x) {
        // write code here
//        if(x < 0){//-1是错的
//            return false;
//        }
//        int tem = x;
//        long y = 0;
//        while(x != 0){
//            y = y * 10 + x % 10;
//            x /= 10;
//        }
//        return (int) y == tem;



        StringBuffer sb = new StringBuffer();
        sb.append(x);
        return sb.toString().equals(sb.reverse().toString());

    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(1112);
        System.out.println(palindrome);
    }
}
