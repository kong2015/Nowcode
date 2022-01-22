/**
 * @author dingxudong
 * @create 2021-09-14 23:06
 * @Description
 * 实现函数 atoi 。函数的功能为将字符串转化为整数
 * 提示：仔细思考所有可能的输入情况。这个问题没有给出输入的限制，你需要自己考虑所有可能的情况。
 */
public class NC100 {
    public int atoi (String str) {
        if(str == null || str.length() == 0)
            return 0;
        int i = 0;
        int len = str.length();
        while(i < len && str.charAt(i) == ' '){
            i++;
        }
        int flag = 1;
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            if(str.charAt(i) == '-'){
                flag = -1;
            }
            i++;
        }
        int bound = Integer.MAX_VALUE / 10;
        int res = 0;
        while(i < len && Character.isDigit(str.charAt(i))){
            if(res > bound || (res == bound && str.charAt(i) <= '9' && str.charAt(i) >= '7')){
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + str.charAt(i) - '0';
            i++;
        }
        return flag * res;
    }
}
