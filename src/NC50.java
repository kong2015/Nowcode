/**
 * @author dingxudong
 * @create 2021-09-10 20:33
 * @Description
 * NC50 链表中的节点每k个一组翻转
 *
 * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 \ O(1) O(1)
 */
public class NC50 {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            if(cur == null){
                return head;
            }
            cur = cur.next;
        }
        ListNode end = cur;
        cur = head;
        ListNode pre = null;
        while(cur != end){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(end, k);
        return pre;
    }
}