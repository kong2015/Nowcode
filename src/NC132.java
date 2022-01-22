import java.util.ArrayList;

/**
 * @author dingxudong
 * @create 2021-09-27 11:54
 * @Description
 * NC132 环形链表的约瑟夫问题
 */
public class NC132 {
    public int ysf (int n, int m) {
        // write code here
//         int res = 0;
//         for(int i = 2; i <= n; i++){
//             res =(res + m) % i;
//         }
//         return res + 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1){
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

}
