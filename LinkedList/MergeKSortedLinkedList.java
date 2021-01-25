package LinkedList;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    /**
     *
     *
     *
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     *
     * Merge all the linked-lists into one sorted linked-list and return it.
     *
     *
     *
     * Example 1:
     *
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     * Explanation: The linked-lists are:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * merging them into one sorted list:
     * 1->1->2->3->4->4->5->6
     * Example 2:
     *
     * Input: lists = []
     * Output: []
     * Example 3:
     *
     * Input: lists = [[]]
     * Output: []
     *
     *
     * Constraints:
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] is sorted in ascending order.
     * The sum of lists[i].length won't exceed 10^4.
     *
     */
    /*
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        int st=0;
        while(st<lists.length && lists[st]==null){
            st++;
        }
        if(st==lists.length) return null;
        ListNode res=new ListNode(Integer.MIN_VALUE,lists[st]);
        for (int i = st+1; i < lists.length; i++) {
            ListNode yetToMerge=lists[i];
            if(yetToMerge!=null)
                res=merge(res,yetToMerge);
        }
        return res.next;
    }
    private ListNode merge(ListNode cur, ListNode yetToMerge) {
        ListNode merge=new ListNode();
        ListNode ptr=merge;
        ListNode p=cur;
        ListNode q=yetToMerge;
        while (p!=null && q!=null){
            if(p.val<q.val){
                ptr.next=p;
                p=p.next;
            }
            else{
                ptr.next=q;
                q=q.next;
            }
            ptr=ptr.next;
        }
        if(p!=null)
            ptr.next=p;
        if(q!=null)
            ptr.next=q;
        return  merge.next;
    }
     */

    //Efficient approach :
    //Time Complexity is =o(nlogK) where each time list is reduced by factor of 2;
    //Sapce Complexity is o(1);
/*
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0)
            return null;
        //Two way Merging

        int interval=1;
        while (interval<lists.length){
            for (int i = 0; i+interval< lists.length ; i=i+interval*2) {
                lists[i]=mergeTwoLinkedLists(lists[i],lists[i+interval]);
            }
            interval=interval*2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLinkedLists(ListNode l1,ListNode l2){

        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode res=new ListNode();
        ListNode cur=res;

        while (l1!=null && l2!=null){
            if(l1.val<l2.val) {
                cur.next = l1;
                l1=l1.next;
            }
            else {
                cur.next = l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=(l1==null)?l2:l1;
        return res.next;
    }*/

    //Third approach Using Heap Data structures;
    //Time complexity of this approach is n(logK)
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>((l1,l2)->l1.val- l2.val);

        for (ListNode list:lists) {
            while (list!=null){
                priorityQueue.add(list);
                list=list.next;
            }
        }

        ListNode res=new ListNode();
        ListNode cur=res;
        while (!priorityQueue.isEmpty()){
            cur.next=priorityQueue.poll();
            cur=cur.next;
        }
        return res.next;
    }



}
