package Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class  TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class LeftViewofTree {
    TreeNode2 root;
    static int maxLevel=0;

    public void printLeftView(TreeNode2 root){
            leftUtil(root,1);
    }

    private void leftUtil(TreeNode2 root,int level){
        if(root==null)
            return;

        if(maxLevel<level){
            System.out.print(root.val+" ");
            maxLevel=level;
        }
        leftUtil(root.left,level+1);
        leftUtil(root.right,level+1);
    }

    private void leftView_BFS(TreeNode2 root){

        if(root==null)
            return;

        LinkedList<TreeNode2> queue=new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty()==false){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode2 node = queue.poll();
                if(i==0)
                    System.out.print(node.val+" ");
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }



    }

    public static void main(String[] args) {

        LeftViewofTree tree=new LeftViewofTree();
        tree.root=new TreeNode2(4);
        tree.root.left=new TreeNode2(5);
        tree.root.right=new TreeNode2(2);

        ///////////////////////////////
        tree.root.right.left=new TreeNode2(3);
        tree.root.right.right=new TreeNode2(1);
        //////////////////////////////////////
        tree.root.right.left.left=new TreeNode2(6);
        tree.root.right.left.right=new TreeNode2(7);

        tree.printLeftView(tree.root);
        System.out.println();
        System.out.println("Left view traversal of binary tree using Breadth First Search : ");

        tree.leftView_BFS(tree.root);


        RightViewBinaryTree rightViewBinaryTree=new RightViewBinaryTree();

        System.out.println("Right view of binary Tree is : ");
        System.out.println();
        rightViewBinaryTree.printRightView(tree.root, 1);
        System.out.println();
        System.out.println("Right view of binary Tree using Breadth First search  : ");

        rightViewBinaryTree.printRightView_BFS(tree.root);
    }
}
