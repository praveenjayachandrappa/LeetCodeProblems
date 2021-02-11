package Tree;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
    int reachedLevel=0;
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res=new ArrayList();
        if(root!=null)
            res.add(root.val);
        //method call
        rightSideView(root,0);
        return res;
    }

    private void rightSideView(TreeNode root,int level){
        if(root==null)
            return;
        if(reachedLevel<level){
            res.add(root.val);
            reachedLevel=level;
        }
        rightSideView(root.right,level+1);
        rightSideView(root.left,level+1);
    }

    public static void main(String[] args) {


    }
}
