/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode step1=head;
        ListNode step2=head;
        while(step2 != null && step2.next != null){
            step1=step1.next;
            step2=step2.next.next;
            if(step1 == step2){
                return true;
            }
        }
        return false;
    }
}