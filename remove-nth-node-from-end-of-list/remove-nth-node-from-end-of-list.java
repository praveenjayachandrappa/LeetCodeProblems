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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        
        if(head==null)
            return null;

        /*
        int len=getLength(head);
        
        int pos=len-n;
        
        if(pos==0)
            return head.next;
        
        
        ListNode ptr=head;
        while(pos>1){
            ptr=ptr.next;
            pos--;
        }
        
        ptr.next=ptr.next.next;
        
        return head;
        
        */
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=dummy;
        ListNode second=dummy;
        for(int i=1;i<=n+1;i++){
            first=first.next;
        }
        
        while(first!=null){
            
            first=first.next;
            second=second.next;
        }
        
        
        second.next=second.next.next;
        
        
        return dummy.next;
        
    }
    
    
    private int getLength(ListNode node){
        
        int count=0;
        
        while(node!=null){
            
            node=node.next;
            count++;
        }
        
        return count;
    }
}