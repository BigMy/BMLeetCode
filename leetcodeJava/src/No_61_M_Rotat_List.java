import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，将链表向右旋转 k 个位置，其中 k 是非负数。
 * 给定 1->2->3->4->5->NULL 且 k = 2,
 * 返回 4->5->1->2->3->NULL.
 */
public class No_61_M_Rotat_List {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return null;

        Map<Integer, ListNode> nodeMap = new HashMap<>();

        int count = 1;

        ListNode tempNode = head;
        while (true) {
            nodeMap.put(count, tempNode);
            if (tempNode.next == null)
                break;
            else {
                tempNode = tempNode.next;
                count ++;
            }
        }

        if (k % count == 0) {
            return head;
        } else {
            k = k % count;
        }


        ListNode newHead = nodeMap.get(count - k + 1);
        ListNode newTail = nodeMap.get(count - k);
        ListNode joinNode = nodeMap.get(count);
        joinNode.next = head;
        newTail.next = null;


        return newHead;
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.print();

        System.out.println();

        ListNode ret = new No_61_M_Rotat_List().rotateRight(n1, 5);

        ret.print();


    }
}
