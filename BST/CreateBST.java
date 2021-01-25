package BST;

public class CreateBST {

    TreeNode root=null;

    public static void main(String[] args) {

        int[] arr={9,10,8,5,13,4,2,17,12,7,3};
        CreateBST createBST=new CreateBST();
        createBST.createBST(arr);
        inorderBST(createBST.root);
    }

    private static void inorderBST(TreeNode root) {
        if(root==null)
            return;
        inorderBST(root.left);
        System.out.print(root.val+" ");
        inorderBST(root.right);
    }

    private  void createBST(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insertNode(arr[i]);
        }
    }

    private void insertNode(int val){
        if(this.root==null){
            this.root=new TreeNode(val);
            return;
        }
        TreeNode ptr=this.root;
        TreeNode tail=null;

        while (ptr!=null){
            if(val< ptr.val){
                //I have to go left
             tail=ptr;
             ptr=ptr.left;
            }
            else{
                tail=ptr;
                ptr=ptr.right;
            }
        }

        if(tail!=null){
            TreeNode t=new TreeNode(val);
            if(t.val<tail.val)
                tail.left=t;
            else
                tail.right=t;
        }
    }
}
