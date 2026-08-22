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
    public ListNode detectCycle(ListNode head) {
        ListNode step1=head;

        HashSet<ListNode> set=new HashSet<>();
        set.add(step1);

        while(step1 != null){
            step1=step1.next;
            if(set.contains(step1)){
                return step1;
            }
            set.add(step1);
        }
        return null;
    }
}