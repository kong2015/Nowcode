import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dingxudong
 * @create 2021-09-27 11:38
 * @Description
 * 给定一个长度为n的数组nums，数组由一些非负整数组成，
 * 现需要将他们进行排列并拼接，每个数不可拆分，使得最后的结果最大，返回值需要是string类型，否则可能会溢出。
 */
public class NC111 {
    public String solve (int[] nums) {
        // write code here
        String[] res = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
//         Arrays.sort(res, (x,y) -> (y+x).compareTo(x+y));
        if (res[0].equals("0")) return "0";
        StringBuilder ret = new StringBuilder();
        for(String e:res){
            ret.append(e);
        }
        return ret.toString();
    }
}
