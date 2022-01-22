/**
 * @author dingxudong
 * @create 2021-11-13 21:54
 * @Description
 * 可以看到环的入口结点
 */
public class NC3 {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead == null || pHead.next == null)
            return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                ListNode cur = pHead;
                while (cur != fast){
                    cur = cur.next;
                    fast = fast.next;
                }
                return cur;
            }
        }
        return null;
    }
}
