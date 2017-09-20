public class No_25_H_ReverseNodes_In_k_Group {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode7 = new ListNode(4);
        ListNode listNode9 = new ListNode(5);
        ListNode listNode11 = new ListNode(6);

        listNode1.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode7;
        listNode7.next = listNode9;
        listNode9.next = listNode11;

        System.out.print("input: ");
        listNode1.print();
        System.out.print("\r\n");
        System.out.print("output:");
        reverseKGroup(listNode11, 7).print();
        System.out.print("\r\n");
    }

    public static  ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return head;
        }


        int moveStep = 1;

        ListNode joinPoint = head;

        ListNode reversingNode = head;

        ListNode rightNode = head.next;

        head = rightNode;

        joinPoint.next = null;

        while (moveStep < k && head != null) {

            head = rightNode.next;

            rightNode.next = reversingNode;

            reversingNode = rightNode;

            rightNode = head;

            moveStep ++;


        }

        if (head != null)
            joinPoint.next = head;


        if (k > moveStep && head == null) {
            return reverseListNode(reversingNode);
        }
        return reversingNode;
    }


    public static ListNode reverseListNode(ListNode head) {

        if (head.next == null) {
            return head;
        }
        ListNode swapNode = head.next;
        ListNode preNode = head;
        preNode.next = null;
        while (swapNode != null) {
            ListNode nextNode = swapNode.next;
            swapNode.next = preNode;
            preNode = swapNode;
            if (nextNode == null) {
                break;
            }
            swapNode = nextNode;
        }
        return swapNode;
    }

}
