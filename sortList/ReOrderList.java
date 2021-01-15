package sortList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ReOrderList {

    /*public static void reorderList(ListNode head) {
        Deque<ListNode> deque=new LinkedList<>();
        ListNode ptr=head;
        while(ptr!=null){
            deque.add(new ListNode(ptr.val));
            ptr=ptr.next;
        }
        ListNode list=new ListNode(-100);
        ListNode res=list;
        boolean flag=true;
        while(deque.size()>1){
            if(flag){
                ListNode node =deque.removeFirst();
                res.next=node;
                res=res.next;
                flag=!flag;
            }
            else{
                ListNode node=deque.removeLast();
                res.next=node;
                res=res.next;
                flag=!flag;
            }
        }
        res.next=deque.poll();
        res=res.next;
        head=list.next;
        printList(head);
    }*/

    public  static void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return ;

        //first reach the midlle of the linked List

        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){

            fast=fast.next;
            if(fast==null)
                break;
            fast=fast.next;
            slow=slow.next;
        }

        ListNode fromMid=slow.next;
        slow.next=null;
        Stack<ListNode> stack=new Stack();
        while(fromMid!=null){
            stack.push(fromMid);
            fromMid=fromMid.next;
        }

        ListNode ptr=head;
        ListNode next;

        while(!stack.isEmpty()){
            next=ptr.next;
            ListNode cur=stack.pop();
            cur.next=null;
            ptr.next=cur;
            cur.next=next;
            ptr=cur.next;
        }
        printList(head);
    }

    public  static void reorderListWihoutUsingStack(ListNode head){

        if(head==null || head.next==null)
            return;

        //Step1: Reach to the middle of the linked List
        ListNode slow=head,fast=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next;
            if(fast==null)
                break;
            fast=fast.next;
            slow=slow.next;
        }
        //Step 2: Reverse second Half of the linkedList
        ListNode preMiddle=null;
        ListNode preCurrent=slow.next;
        slow.next=null; //make slow.next =null
        while (preCurrent!=null){
           ListNode next=preCurrent.next;
           preCurrent.next=preMiddle;
           preMiddle=preCurrent;
           preCurrent=next;
        }
        ListNode ptr=head;

        //Then Merge both the linkedLists
        while (ptr!=slow){
            ListNode next=ptr.next;
            ListNode secondNext=preMiddle.next;
           preMiddle.next=ptr.next;
            ptr.next=preMiddle;
            preMiddle=secondNext;
            ptr=next;
        }

    }



    public static void printList(ListNode ptr){
        if(ptr==null)
            return;
        System.out.print(ptr.val+" ");
        printList(ptr.next);
    }
    public static void main(String[] args) {

        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        //reorderList(head);
        reorderListWihoutUsingStack(head);

    }

}
