/**
 * @author dingxudong
 * @create 2021-09-26 19:31
 * @Description
 * 山峰元素是指其值大于或等于左右相邻值的元素。
 * 给定一个输入数组nums，任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
 *
 * 假设 nums[-1] = nums[n] = -∞。
 */
public class NC107 {
    public static int solve (int[] a) {
        // write code here
        for(int i = a.length - 1; i > 0; i--){
            if(i == a.length - 1){
                if (a[i] > a[i - 1]){
                    return i;
                }
            }else if(a[i] > a[i + 1] && a[i] > a[i - 1]){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        solve(new int[]{2,4,1,2,7,8,4});
    }
}