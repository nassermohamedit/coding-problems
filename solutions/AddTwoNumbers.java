/**
 * tags: data structures, math
 * statementL https://leetcode.com/problems/add-two-numbers/description/
 */


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s = 0;
        ListNode answer = l1;
        while (true) {
            s = l1.val + (l2 != null ? l2.val : 0) + s/10;
            l1.val = s % 10;
            l2 = l2 != null ? l2.next : l2;
            if (l1.next == null && l2 == null) break;
            if (l1.next == null) l1.next = new ListNode(0);
            l1 = l1.next;
        }
        if (s/10 == 1) l1.next = new ListNode(1);
        return answer;
    }
}
