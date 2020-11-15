import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution143 {



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode currNode = head;
        while (currNode != null){
            deque.addLast(currNode);
            currNode = currNode.next;
        }
        ListNode lastNode = null;
        currNode = deque.removeFirst();
        lastNode = currNode;

        while (!deque.isEmpty()){
            currNode = deque.removeLast();
            lastNode.next = currNode;
            lastNode = currNode;
            if (!deque.isEmpty()){
                currNode = deque.removeFirst();
                lastNode.next = currNode;
                lastNode = currNode;
            }

        }
        lastNode.next = null;
        return;


    }


}
