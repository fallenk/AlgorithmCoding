public class SO18_deleteNode {
    public static void main(String[] args) {

    }

    public ListNode3 deleteNode(ListNode3 head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode3 pre = head, cur = head.next;
        while (cur.val != val && cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }

}

class ListNode3 {
    int val;
    ListNode3 next;
    public ListNode3(int val) {
        this.val = val;
    }
}

