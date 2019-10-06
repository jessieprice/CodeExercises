/* Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        int sumA = 0;
        int sumB = 0;
        
        while (tempA.next != null) {
            sumA++;
            tempA = tempA.next;
        }
        while (tempB.next != null) {
            sumB++;
            tempB = tempB.next;
        }
        
        if (tempA != tempB) {
            return null;
        }
        
        int diff = Math.abs(sumA - sumB);
        
        if (sumA > sumB) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else if (sumB > sumA) {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
