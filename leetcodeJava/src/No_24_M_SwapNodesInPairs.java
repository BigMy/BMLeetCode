public class No_24_M_SwapNodesInPairs {


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
        swapPairs(listNode7).print();
        System.out.print("\r\n");
    }


    public static ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode preOddNode = new ListNode(0);
        preOddNode.next = head;
        ListNode result = preOddNode;
        // 奇数node
        ListNode oddNode = head;
        // 偶数node
        ListNode evenNode = head.next;

        while (true) {
            if (evenNode == null) {
                break;
            }

            ListNode swappingOddNode = oddNode;

            ListNode swappingEvenNode = evenNode;

            swappingOddNode.next = swappingEvenNode.next;

            swappingEvenNode.next = swappingOddNode;

            preOddNode.next = swappingEvenNode;

            if (swappingOddNode.next == null) {
                break;
            }
            // 奇数前置节点照常 移动两位
            preOddNode = preOddNode.next.next;
            // 奇数节点跟偶数节点交换了，所以下一个奇数节点距离他只有一步
            oddNode = oddNode.next;
            // 偶数节点被换到前一个奇数节点的位置了，所以距离下一个偶数节点要走三步
            evenNode = evenNode.next.next.next;
        }
        return result.next;
    }
}
