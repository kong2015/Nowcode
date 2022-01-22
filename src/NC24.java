/**
 * @author dingxudong
 * @create 2021-09-14 17:34
 * @Description
 * 只保留原链表中只出现一次的元素
 * 给出的链表为1 \to 2\to 3\to 3\to 4\to 4\to51→2→3→3→4→4→5, 返回1\to 2\to51→2→5.
 * 给出的链表为1\to1 \to 1\to 2 \to 31→1→1→2→3, 返回2\to 32→3.
 */
public class NC24 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                while(cur != null && cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}

