import java.util.Arrays;
import java.util.HashMap;

public class Test {
    int[] res;
    int count = 0;

    public int[] printNumbers(int n) {
        res = new int[(int)Math.pow(10, n) - 1];
        for(int digit = 1; digit < n + 1; digit++){
            for(char first = '1'; first <= '9'; first++){
                char[] num = new char[digit];
                num[0] = first;
                dfs(1, num, digit);
            }
        }
        return res;
    }

    private void dfs(int index, char[] num, int digit){
        if(index == digit){
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }
    public static int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public static int lengthOfLongestSubstring(String s) {
        //if(s==null) return 0;这句话可以不加，s.length()长度为0时，不进入下面的循环，会直接返回max=0;
        //划定当前窗口的坐标为(start,i],左开右闭,所以start的初始值为-1，而非0。
        int max = 0,start =-1;
        int cur = 0;
        //使用哈希表map统计各字符最后一次出现的索引位置
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);

            //当字符在map中已经存储时，需要判断其索引值index和当前窗口start的大小以确定是否需要对start进行更新:
            //当index>start时，start更新为当前的index,否则保持不变。
            //注意若index作为新的start，计算当前滑动空间的长度时也是不计入的，左开右闭，右侧s[i]会计入，这样也是防止字符的重复计入。
            if(map.containsKey(tmp)){
                cur = map.get(tmp);
                start = Math.max(start,cur);
            }


            //如果map中不含tmp，此处是在map中新增一个键值对，否则是对原有的键值对进行更新
            map.put(tmp,i);

            //i-start,为当前滑动空间(start,i]的长度，若其大于max，则需要进行更新。
            max = Math.max(max,i-start);
        }
        return max;
    }
//    public static boolean isNumber(String s) {
//        //数值字符串中可能包含的十个字符，map下标为0-9. 每一个下标表示当前字符可能对应的下一个字符是哪几种
//        HashMap [] states = {new HashMap<>(){{put(' ', 0); put('s', 1); put('d', 2); put('.', 3);}},//0代表空格
//                new HashMap<>(){{put('d', 2); put('.', 4);}},//1代表正负号
//                new HashMap<>(){{put('d', 2); put('.', 4); put('e', 6); put(' ', 9);}},//2代表小数点前的数字
//                new HashMap<>() {{put('d', 5);}},//3表示左边没有整数的小数点（.9）
//                new HashMap<>() {{put('d', 5); put('e', 6); put(' ', 9);}},//4表示左边有整数的小数点（3.）
//                new HashMap<>(){{put('d', 5); put('e', 6);}},//5代表小数点后的数字
//                new HashMap<>(){{put('s', 7); put('d', 8);}},//6代表e
//                new HashMap<>(){{put('d', 8);}},//7代表e后的正负号
//                new HashMap<>(){{put('d', 8); put(' ', 9);}},//8代表e后的整数
//                new HashMap<>(){{put(' ', 9);}}//9代表最后的空格
//        };
//        char temp;
//        int p = 0;
//        for (char c : s.toCharArray()){
//            if (c == ' ') temp = ' ';
//            else if (c == '+' || c == '-') temp = 's';
//            else if (c == '.') temp = '.';
//            else if (c <= '9' && c >= '0') temp = 'd';
//            else if (c == 'e' || c == 'E') temp = 'e';
//            else temp = '?';
//
//            if (!states[p].containsKey(temp)) return false;
//            p = (int) states[p].get(temp);
//        }
//        return p == 2 || p == 4 || p == 5 || p == 8 || p == 9;
//    }
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++){
            res[i] = Math.min(2 * res[a], Math.min(3 * res[b], 5 * res[c]));
            if (2 * res[a] < 3 * res[b] && 2 * res[a] < 5 * res[c]){
                a++;
            }else if (3 * res[b] < 2 * res[a] && 3 * res[b] < 5 * res[c]){
                b++;
            }else if (5 * res[c] < 2 * res[a] && 5 * res[c] < 3 * res[b]){
                c++;
            }else if (2 * res[a] == 3 * res[b] && 2 * res[a] == 5 * res[c]){
                a++;b++;c++;
            }else if (2 * res[a] == 3 * res[b]){
                b++;a++;
            }else if (5 * res[c] == 2 * res[a]){
                a++;c++;
            }else if (5 * res[c] == 3 * res[b]){
                b++;c++;
            }
        }
        return res[n - 1];
    }

    public static int lengthOf(String s) {
        int i;
        int j = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            map.put(s.charAt(i), i);
            max = Math.max(i - j + 1, max);
        }
        return max;
    }

    public static String[] getNames(String[] names, String[] scores){
        HashMap<Integer, String> map = new HashMap<>();
        int[] sums = new int[names.length];
        for(int i = 0; i < scores.length; i++){
            String[] temp = scores[i].split(",");
            int sum = 0;
            for(int j = 0; j < temp.length; j++){
                sum += Integer.parseInt(temp[j]);
            }
            map.put(sum, names[i]);
            sums[i] = sum;
        }
        Arrays.sort(sums);
        String[] res = new String[names.length];
        for(int i = 0; i < sums.length; i++){
            res[i] = map.get(sums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {1,3,8,6,5,2,5};
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<>();
//        int tem;
//        while((tem = sc.nextInt()) != 0){
//            list.add(tem);
//        }
//        System.out.println(list);

    }
}