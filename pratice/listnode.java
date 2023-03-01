package pratice;

/**
 * @Author：wuwei
 * @name：listnode
 * @Date：2022/12/16 11:45
 */
public class listnode {
    //移除链表元素
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        pre.next = head;
        while (cur.next != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        pre.next = cur;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    //删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode low = pre;
        ListNode fast = pre;
        while (n-- >= 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            low = low.next;
            fast = fast.next;
        }
        low.next = low.next.next;
        return head;
    }

    //链表相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int lenghA = 0;
        int lenghB = 0;
        while (a != null) {
            lenghA++;
            a = a.next;
        }
        while (b != null) {
            lenghB++;
            b = b.next;
        }
        if (lenghA - lenghB > 0) {
            return isCross(headA, headB, lenghA - lenghB);
        } else {
            return isCross(headB, headA, lenghB - lenghA);
        }
    }

    private ListNode isCross(ListNode headA, ListNode headB, int i) {
        while (i-- > 0) {
            headA = headA.next;
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    //环形链表 II
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                return findListNode(fast, head);
            }
        }
        return null;
    }

    private ListNode findListNode(ListNode fast, ListNode head) {
        while (fast != head) {
            fast = fast.next;
            head = head.next;
        }
        return fast;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
