public class No_142_M_Linked_List_Cycle_II {


    public ListNode detectCycle(ListNode head) {

        if (head == null)
            return null;

        ListNode slow = head.next;

        if (slow == null || slow.next == null)
            return null;

        ListNode fast = head.next.next;

        while (fast != slow) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null)
                return null;
            fast = fast.next.next;
        }
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
