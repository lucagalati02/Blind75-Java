import java.util.*;
import java.io.*;

public class LinkList {
    ListNode reverseList(ListNode head) {
        //https://neetcode.io/problems/reverse-a-linked-list?list=blind75
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //https://neetcode.io/problems/merge-two-sorted-linked-lists?list=blind75
        ListNode master = new ListNode(0);
        ListNode pointer = master;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            }
            else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        if (list1 != null) {
            pointer.next = list1;
        }
        else {
            pointer.next = list2;
        }

        return master.next;
    }

    boolean hasCycle(ListNode head) {
        //https://neetcode.io/problems/linked-list-cycle-detection?list=blind75
        HashSet<ListNode> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}