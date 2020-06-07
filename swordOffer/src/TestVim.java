import java.util.HashSet;
import java.util.Set;

public class TestVim {
    public static void main(String[] args) {
        TestVim test = new TestVim();
        TestVim tsste2te2 = new TestVim();
    }
    public boolean hasCycle(ListNode2 head){
        Set<ListNode2> set = new HashSet<>();
        while (head!=null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;

        }
        return false;


    }
}
