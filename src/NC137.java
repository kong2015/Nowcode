import java.util.Stack;

/**
 * @author dingxudong
 * @create 2021-09-07 11:06
 * @Description
 */
public class NC137 {
    public static int solve(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ')
                continue;
            if (arr[i] == '('){
                int k;
                int count = 1;
                for (k = i + 1; k < arr.length; k++) {
                    if (arr[k] == ')'){
                        count--;
                    }else if(arr[k] == '('){
                        count++;
                    }
                    if (count == 0){
                        break;
                    }
                }
                num = solve(s.substring(i + 1, k));
                i = k;//此处i不能等于k+1，如果*（2+3），则k+1越界。
            }
            if (arr[i] >= '0' && arr[i] <= '9'){
                num = num * 10 + arr[i] - '0';
            }
            if (!Character.isDigit(arr[i]) || i == arr.length - 1){//最后一位时要进行同样运算
                if (sign == '+'){
                    stack.push(num);
                }else if (sign == '-'){
                    stack.push(-1 * num);
                }else if (sign == '*'){
                    stack.push(stack.pop()*num);
                }else if (sign == '/'){
                    stack.push(stack.pop()/num);
                }
                sign = arr[i];//用于保存上一个运算符
                num = 0;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        int res = solve("2*(2-3)");
        System.out.println("res = " + res);
    }
}
