/**
 * @author dingxudong
 * @create 2021-09-05 17:05
 * @Description
 */
public class NC91 {
    /**
     * 给定数组arr，设长度为n，输出arr的最长递增子序列。
     * （如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）
     * @param arr
     * @return
     */
    public int[] LIS (int[] arr) {
        int[] vector = new int[arr.length];
        int[] dp = new int[arr.length];//保存以arr[i]结尾的元素的最长子序列
        int len = 1;
        vector[0] = arr[0];
        dp[0] = 1;
        for(int i = 1; i < arr.length; i++){
            int num = arr[i];
            if(num > vector[len - 1]){
                vector[len++] =num;
                dp[i] = len;
            }else if(num <= vector[len - 1]){
                int left = 0;
                int right = len - 1;
                while(left <= right){
                    int mid = left + (right - left) / 2;
                    if(vector[mid] >= num){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
                vector[left] = num;
                dp[i] = left + 1;
            }
        }
        int[] res = new int[len];
        for(int i = res.length - 1, j = dp.length - 1; i >= 0; j--){
            if(dp[j] == len){
                res[i--] = arr[j];
                len--;
            }
        }
        return res;
    }
}