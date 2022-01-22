import java.math.BigInteger;

/**
 * @author dingxudong
 * @create 2021-09-27 11:10
 * @Description
 *
 * 以字符串的形式读入两个数字，编写一个函数计算它们的乘积，以字符串形式返回。
 * （字符串长度不大于10000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class NC10 {
    public static String solve (String s, String t) {
        // write code here
        BigInteger ss = new BigInteger(s);
        BigInteger tt = new BigInteger(t);
        System.out.println(ss.gcd(tt).toString());
        return ss.multiply(tt).toString();
    }

    public static void main(String[] args) {
        String solve = solve("1000", "100");
        System.out.println("solve = " + solve);
    }
}
