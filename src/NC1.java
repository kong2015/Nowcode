/**
 * @author dingxudong
 * @create 2021-09-05 17:10
 * @Description
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class NC1 {
    public String solve (String a, String b) {
        // write code here
        int aindex = a.length() - 1;
        int bindex = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(aindex >= 0 && bindex >= 0){
            int anum = a.charAt(aindex--) - '0';
            int bnum = b.charAt(bindex--) - '0';
            int sum = anum + bnum + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        while(aindex >= 0){
            int anum = a.charAt(aindex--) - '0';
            int sum = anum + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        while(bindex >= 0){
            int bnum = b.charAt(bindex--) - '0';
            int sum = bnum + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}