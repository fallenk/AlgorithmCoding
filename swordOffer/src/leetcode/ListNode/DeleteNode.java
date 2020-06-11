package leetcode.ListNode;

public class DeleteNode {
    public static void main(String[] args) {

    }

    public ListNode deletNode(ListNode head, int val) {
        if(head.val == val) return head.next;

        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }
}
