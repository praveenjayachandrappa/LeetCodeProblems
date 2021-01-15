package Tree;


import java.util.LinkedList;

public class RightViewBinaryTree {

    int maxLevel=0;

    public void printRightView(TreeNode2 root,int level){

        if(root==null)
            return;
        if(maxLevel<level) {
            System.out.print(root.val + " ");
            maxLevel=level;
        }
        printRightView(root.right,level+1);
        printRightView(root.left,level+1);

    }

    public void printRightView_BFS(TreeNode2 root){

        if(root==null)
            return;
        LinkedList<TreeNode2> q=new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()){

            int size=q.size();

            for (int i = 0; i < size; i++) {
                TreeNode2 node = q.poll();
                if(i==size-1)
                    System.out.print(node.val+" ");
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);

            }

        }

    }



}
