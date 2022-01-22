/**
 * @author dingxudong
 * @create 2021-09-07 16:20
 * @Description
 *
 * 给定一个无序单链表，实现单链表的排序(按升序排序)。
 */
public class NC70 {
//    public ListNode sortInList (ListNode head) {
//        // write code here
//        ListNode cur = head;
//        ArrayList<Integer> list = new ArrayList<>();
//        while(cur != null){
//            list.add(cur.val);
//            cur = cur.next;
//        }
//        Collections.sort(list);
//        cur = head;
//        int i = 0;
//        while (cur != null){
//            cur.val = list.get(i++);
//            cur = cur.next;
//        }
//        return head;
//    }
    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }
}
