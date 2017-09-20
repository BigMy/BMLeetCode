/**
 * Created by BigMy on 2017/9/19.
 */
public class ListNode {
    int val;
    public ListNode next;
    ListNode(int x) { val = x; }

    public void print() {
        ListNode dummy = this;
        System.out.print(val);
        while (dummy.next != null) {
            System.out.print(" -> " + dummy.next.val);
            dummy = dummy.next;
        }
    }
}
