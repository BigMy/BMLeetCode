
/**
 * Created by BigMy on 2017/8/23.
 */



public class No_2_M_Add_Two_Numbers {



    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);

        ListNode listNode2 = new ListNode(4);

        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(5);

        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(7);

        listNode3.next = listNode4;



        ListNode listNode11 = new ListNode(3);

        ListNode listNode22 = new ListNode(4);

        listNode11.next = listNode22;

        ListNode listNode33 = new ListNode(7);

        listNode22.next = listNode33;

        ListNode listNode44 = new ListNode(9);

        listNode33.next = listNode44;

        ListNode resultNode = addTwoNumbers(listNode1, listNode11);

        System.out.println("add two numbers");
        System.out.println("see more detail? plz debug");


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int nextNodeIncrVal = 0;

        ListNode resultListHead = null;
        ListNode appendingHead = null;
        while (true) {

            if (l1 == null && l2 == null) {
                if (nextNodeIncrVal > 0) {
                    appendingHead.next = new ListNode(nextNodeIncrVal);
                }
                break;
            }
            int currentDigitsSum = 0;
            if (l1 != null) {
                currentDigitsSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentDigitsSum += l2.val;
                l2 = l2.next;
            }

            currentDigitsSum += nextNodeIncrVal;
            if (currentDigitsSum  > 9) {
                currentDigitsSum = currentDigitsSum - 10;
                nextNodeIncrVal = 1;
            } else {
                nextNodeIncrVal = 0;
            }

            if (appendingHead == null) {
                appendingHead = new ListNode(currentDigitsSum);
                resultListHead = appendingHead;
            } else {
                appendingHead.next = new ListNode(currentDigitsSum);
                appendingHead = appendingHead.next;
            }

        }

        return resultListHead;
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
