/* Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        System.out.println("list length: " + lists.length);
        // if there are no lists
        if (lists.length == 0) {
            return null;
        }
        
        // if there is only one list 
        if (lists.length == 1) {
            return lists[0];
        }
        
        // otherwise at least 2 lists, even number of lists
        if (lists.length % 2 == 0) {
            ListNode[] temp = new ListNode[lists.length / 2];
            System.out.println("temp length: " + temp.length);
            int index = 0;
            while (index < lists.length - 1) {
                temp[index / 2] = mergeTwo(lists[index], lists[index + 1]);
                index += 2;
            }
            return mergeKLists(temp);
        } 
        // at least 3 lists, odd number of lists
        else {
            ListNode[] temp = new ListNode[lists.length / 2 + 1];
            System.out.println("temp length: " + temp.length);
            int index = 0;
            while (index < lists.length - 1) {
                temp[index / 2] = mergeTwo(lists[index], lists[index + 1]);
                index += 2;
            }
            temp[temp.length - 1] = lists[lists.length - 1];
            return mergeKLists(temp);
        }
    }
    
    public ListNode mergeTwo(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        
        // case 1: both nodes aren't null
        while (node1 != null && node2 != null) {
            // condition 1:  node 1 value is smaller or equal than node 2 value
            if (node1.val <= node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } 
            // condition 2: node 1 value greater than node 2 value
            else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        
        // case two: at the end of list one but not list two
        while (node1 == null && node2 != null) {
            temp.next = node2;
            node2 = node2.next;
            temp = temp.next;
        }
        
        // case three: at the end of list two but not list one
        while (node1 != null && node2 == null) {
            temp.next = node1;
            node1 = node1.next;
            temp = temp.next;
        }
        
        return head.next;
    }
}
