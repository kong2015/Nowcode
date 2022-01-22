public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode(int[] array){
//        array == null 表示数组什么都没有指向，array.length == 0表示数组中什么也没有。
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Array can not be empty!");
        }
        this.val = array[0];
        ListNode cur = this;
        for (int i = 1; i < array.length; i++){
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("LinkedList:");
        ListNode cur = this;
        while (cur != null){
            sb.append(cur.val + "->");
            cur =cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}