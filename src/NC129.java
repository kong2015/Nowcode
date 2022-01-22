/**
 * @author dingxudong
 * @create 2021-09-28 17:45
 * @Description
 */
public class NC129 {
    public long thenumberof0 (long n) {
        // write code here
        long m = 5;
        long count = 0;
        while (m <= n) {
            count += n / m;
            m *= 5;
        }
        return count;
    }
}