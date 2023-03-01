package forwordOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author：wuwei
 * @name：offer10
 * @Date：2022/12/29 16:40
 */
public class offer10 {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] a = new int[stack.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = stack.pop();
        }
        return a;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
