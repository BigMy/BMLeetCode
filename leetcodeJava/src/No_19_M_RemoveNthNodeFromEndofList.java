import java.util.HashMap;
import java.util.Map;

/**
 * Created by BigMy on 2017/9/18.
 */
public class No_19_M_RemoveNthNodeFromEndofList {



    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode removedNode = removeNthFromEnd(node1, 4);

        System.out.println("LongestCommonPrefix");
        System.out.println("input: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.print("output:");

        System.out.print(removedNode.val);
        while (removedNode.next != null) {
            System.out.print(" -> " + removedNode.next.val);
            removedNode = removedNode.next;
        }

    }





    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null ) {
            return null;
        }
        ListNode result = head;

        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int idx = 0;
        nodeMap.put(idx, head);
        while (head.next != null) {
            idx ++;
            nodeMap.put(idx,  head.next);
            head = head.next;
        }

        if (n > idx) {
            return nodeMap.get(n - idx); // idx = 1
        }
        // idx + 1 总数，
        ListNode preHead = nodeMap.get(((idx + 1) - n) - 1);
        preHead.next = nodeMap.get(((idx + 1) - n) + 1);

        return result;
    }

}
