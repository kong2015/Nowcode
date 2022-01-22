/**
 * @author dingxudong
 * @create 2021-09-30 12:33
 * @Description
 * 如果有一个自然数  能被自然数  整除，则称  为  的倍数，  为  的约数。
 * 几个自然数公有的约数，叫做这几个自然数的公约数。公约数中最大的一个公约数，称为这几个自然数的最大公约数。
 */
public class NC151 {
//    public int gcd (int a, int b) {
//        // write code here
//        if(b > a){
//            int tem = a;
//            a = b;
//            b = tem;
//        }
//        if(a % b == 0)
//            return b;
//        return gcd(b, a%b);
//    }
    public int gcd (int a, int b) {
        // write code here
        if(b > a){
            int tem = a;
            a = b;
            b = tem;
        }
        while (a % b != 0){
            int tem = a % b;
            a = b;
            b = tem;
        }
        return b;
    }
}
