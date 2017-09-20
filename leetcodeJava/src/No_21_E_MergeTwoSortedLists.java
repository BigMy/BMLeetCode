/**
 * Created by BigMy on 2017/9/19.
 */
public class No_21_E_MergeTwoSortedLists {



    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode11 = new ListNode(11);


        listNode1.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode7;
        listNode7.next = listNode9;
        listNode9.next = listNode11;

        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode8 = new ListNode(8);

        listNode2.next = listNode4;
        listNode4.next = listNode6;
        listNode6.next = listNode8;

        System.out.println("input: list1 ");
        listNode1.print();
        System.out.println("input: list2 ");
        listNode2.print();
        ListNode mergedNode = mergeTwoLists(listNode2, listNode1);
        System.out.println("output:  ");
        mergedNode.print();

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode mergingNode = new ListNode(0);

        ListNode result = mergingNode;

        while (true) {

            if (l1 == null) {
                mergingNode.next = l2;
                break;
            }

            if (l2 == null) {
                mergingNode.next = l1;
                break;
            }

            if (l1.val < l2.val) {
                mergingNode.next = l1;
                l1 = l1.next;
            } else {
                mergingNode.next = l2;
                l2 = l2.next;
            }
            mergingNode = mergingNode.next;

        }

        return result.next;
    }
}
