package BSTConstruction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CreateBST {
    TreeNode root=null;

    public  TreeNode createBST(int[] arr){

        for (int i = 0; i <arr.length ; i++) {
            insertNode( arr[i]);
        }
        return root;
    }

    private  void insertNode(int val){
        //basic Step;
        if(root==null){
            root=new TreeNode(val);
            return;
        }
        else{
            TreeNode ptr=this.root;
            TreeNode tail=null;
            while (ptr!=null){
                //BST Does not allow duplicates & inorder traversal of BST gives sorted elements
                if(val<ptr.val) {
                    tail=ptr;   //To insert left child
                    ptr = ptr.left;
                }
                else {
                    tail=ptr;
                    ptr = ptr.right;  //To right child
                }
            }
            if(tail!=null) {
                TreeNode t = new TreeNode(val);
                if(t.val<tail.val)
                    tail.left=t;
                else
                    tail.right=t;
            }
            return;
        }
    }

    public  void printLevelOrderTraversal(){

        if(this.root==null)
            return;
        //BFS -Bredth First Search

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count=queue.size();
            while (count-->0){
                TreeNode curNode = queue.poll();
                System.out.print(curNode.val+" ");
                if(curNode.left!=null)
                    queue.add(curNode.left);
                if(curNode.right!=null)
                    queue.add(curNode.right);
            }
        }
        return;
    }

    private int countNodes(TreeNode root,int count){
        if(root==null)
            return 0;
        return 1+countNodes(root.left,count) +countNodes(root.right,count);

/*
        if(root!=null){
            return 1+countNodes(root.left,count)+countNodes(root.right,count);
        }
        return count;*/

    }

    public void inOrderBST(TreeNode root){
        if(root==null)
            return;
        inOrderBST(root.left);
        System.out.print(root.val+" ");
        inOrderBST(root.right);
    }

    public void inOrderBSTIteratvie(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (root!=null || !stack.isEmpty()){

            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            System.out.print(root.val+" ");
            root=root.right;
        }

    }
/*

    private  TreeNode deleteNode(TreeNode ptr, int key) {

        if(ptr==null)
            return null;
        if(ptr.left==null && ptr.right==null){
            return null;
        }
        if(key<ptr.val){
            //go left
           ptr =deleteNode(ptr.left,key);
        }
        else if(key>ptr.val){
            ptr =deleteNode(ptr.right,key);
        }
        else{
            //found the node
            if(height(ptr.left)>height(ptr.right)){
                TreeNode q=findInOrderPredecessor(ptr.left);
                ptr.val= q.val;
                ptr.left=deleteNode(ptr.left, q.val);
            }
            else{
                TreeNode q=findInorderSuccessor(ptr.right);
                ptr.val= q.val;
                ptr.right=deleteNode(ptr.right,q.val);
            }
        }

        return ptr;
    }

    private TreeNode findInorderSuccessor(TreeNode ptr) {
        if(ptr.left==null)
            return ptr;
        return findInorderSuccessor(ptr.left);
    }

    private TreeNode findInOrderPredecessor(TreeNode p) {
        //Is this last node in the right
        if(p.right==null)
            return p;
        return findInOrderPredecessor(p.right);
    }

    private int height(TreeNode ptr) {
        int x;
        int y;
        if(ptr==null)
            return 0;
        x=height(ptr.left);
        y=height(ptr.right);
        return x>y?x+1:y+1;
    }
*/


    private TreeNode deleteNode(TreeNode ptr,int key){

        TreeNode treeNode = deleteRec(ptr, key);
        return treeNode;
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        if(root==null)
            return  root;
        if(key<root.val)
           root.left= deleteRec(root.left,key);
        else if(key>root.val)
            root.right=deleteRec(root.right,key);
        else {

            // if key is same as root's
            // key, then This is the
            // node to be deleted
            // node with only one child or no child
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.val=minValue(root.right);
            // Delete the inorder successor
            root.right=deleteRec(root.right,root.val);
        }
        return root;
    }

    private int minValue(TreeNode ptr) {
        int minVal=ptr.val;
        while (ptr.left!=null){
            minVal=ptr.left.val;
            ptr=ptr.left;
        }

        return minVal;

    }


    public static void main(String[] args) {
/*
        int[] A={9,6,5,0,8,2,4,7};

        CreateBST bst=new CreateBST();
        bst.createBST(A);
       bst.printLevelOrderTraversal();

        int i = bst.countNodes(bst.root, 0);
        System.out.println("Count Nodes "+i);

        bst.inOrderBST(bst.root);

        System.out.println();
        bst.inOrderBSTIteratvie(bst.root);

    */


        int[] nodes={5,3,6,2,4,7};
        CreateBST bst=new CreateBST();
        bst.createBST(nodes);
        bst.printLevelOrderTraversal();
        TreeNode treeNode = bst.deleteNode(bst.root, 3);
        System.out.println();
        bst.printLevelOrderTraversal();
    }

}
