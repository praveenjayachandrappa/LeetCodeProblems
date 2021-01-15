package LinkedList;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;

    }

}
public class ReOrderList {

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

   private void createList(int[] arr){
       if(head==null){
           head=new ListNode(arr[0]);
       }
       for (int i = 1; i <arr.length ; i++) {
           ListNode node=new ListNode(arr[i]);
           insertNode(node);
       }
   }

    private void insertNode(ListNode node) {
       ListNode ptr=head;
       while (ptr.next!=null){
           ptr=ptr.next;
       }
        ptr.next=node;
   }
   private  void printList(){
       ListNode ptr=this.head;
       while (ptr!=null){
           System.out.print(ptr.val+" ");
        ptr=ptr.next;
       }
       System.out.println();
   }
    public static void main(String[] args) {

       int[] arr={1,2,3,4,5};
       ReOrderList obj=new ReOrderList();
       obj.createList(arr);
        obj.reorderList(obj.getHead());
    }

    private void reorderList(ListNode head) {

    if(head==null || head.next==null)
        return;
    ListNode slow=head,fast=head;

    while (fast!=null && fast.next!=null){
        fast=fast.next;
        if(fast!=null) fast=fast.next;
        slow=slow.next;
    }
        ListNode prev=null,next;
        while (slow!=null){
            next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }
        ListNode n1=head;
        ListNode temp;
        while (prev!=null){
            temp=n1.next;
            n1.next=new ListNode(prev.val);
            n1=n1.next;
            n1.next=temp;
            prev=prev.next;
        }
        printList();
    }
}
