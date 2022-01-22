/**
 * @author dingxudong
 * @create 2021-09-10 20:32
 * @Description
 * NC21 链表内指定区间反转
 */
public class NC21 {
    public ListNode reverseBetween (ListNode head, int m, int n) {  //有点恶心
        // write code here
        if(m==n){return head;}
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode last = dummyNode;
        for(int i = 1; i < m; i++){
            last = last.next;
        }
        ListNode pre = last.next;
        ListNode cur = pre.next;
        ListNode begin = last.next;
        for(int i = m + 1; i <= n; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if(i == n){
                last.next = pre;
                begin.next = cur;
            }
        }
        return dummyNode.next;
    }
}