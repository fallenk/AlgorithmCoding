import java.util.*;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) {
        val = x;
        next = null;
    }
}
public class HasCycle {
    public static void main(String[] args) {
        HasCycle cycle = new HasCycle();
        ListNode2 node = new ListNode2(1);
        ListNode2 n1 = new ListNode2(2);
        ListNode2 n3 = new ListNode2(3);
        node.next = n1;
        n1.next = n3;
        n3.next = node;
        cycle.hasCycle(node);
    }
    public boolean hasCycle(ListNode2 head) {
//        Map<ListNode2, ListNode2> map = new HashMap<>();
        Set<ListNode2> set = new HashSet<>();
        ListNode2 p = head;
        while (p != null) {
//            map.containsValue()
            if (set.contains(p)) {
                return true;
            } else {
                set.add(head);

            }
            p = p.next;
        }
        return false;
    }
    // 快慢指针， 定理 https://www.bilibili.com/video/BV1kb411g7DZ/?spm_id_from=333.788.videocard.0
    //  slow 和 fast 从开始 一起出发 环 到相遇点； 得出 slow从开始出发到环入口点 = fast指针从相遇点出发到环入口点的距离 + 环的圈数
    // 算法中 先算出相遇点 fast再从相遇点出发 = slow从原点出发， 算出 环入口点
    public boolean hasCycle2(ListNode2 listNode) {
        if (listNode == null || listNode.next == null) {
            return false;
        }
        ListNode2 slow = listNode;
        ListNode2 fast = listNode.next;
        while (slow != fast) {
            if (slow == null|| fast==null || fast.next == null) {

                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }

    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode intersect = getIntersect(head);
        if (intersect ==null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = intersect;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
