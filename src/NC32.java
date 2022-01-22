/**
 * @author dingxudong
 * @create 2021-09-05 21:57
 * @Description
 *
 * 实现函数 int sqrt(int x).
 * 计算并返回x的平方根（向下取整）
 */
public class NC32 {
    public int sqrt (int x) {
        // write code here
        int len = 0;
        int i = 1;
        while(x >= 0){
            x -= i;
            i += 2;
            len++;
        }
        return len - 1;
    }

    public int sqrt1 (int x) {
        // write code here
        int left = 1;
        int right = x / 2 + 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(x / mid > mid){
                left = mid + 1;
            }else if(x / mid < mid){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return right;
    }
}
