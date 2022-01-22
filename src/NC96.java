import java.util.ArrayList;

/**
 * @author dingxudong
 * @create 2021-09-08 10:13
 * @Description
 *
 * 给定一个链表，请判断该链表是否为回文结构。
 */
public class NC96 {
    public boolean isPail (ListNode head) {
        // write code here
        ListNode cur = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while(left < right){ //双指针法则 不要使用!=
            if(!list.get(left).equals(list.get(right))){//判断相等 一定要使用equals
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}
