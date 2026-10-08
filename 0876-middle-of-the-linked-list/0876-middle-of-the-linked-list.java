/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp1=head; 
        int n=1;
        while(temp1.next != null){
            temp1=temp1.next;
            n++;
        }
        if(n==1){
            return head;
        }
        int mid=(n/2);
        ListNode temp2=head; 
        int i=1;
        while(i<mid){
            temp2=temp2.next;
            i++;
        }
        return temp2.next;
    }
}