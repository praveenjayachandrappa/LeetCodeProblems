package BST;
import java.util.Arrays;
import java.util.Stack;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(){}
    TreeNode(int val) {
        this.val = val;
        this.left = right = null;
    }
}
public class BSTSearialsize {


    public String serialize(TreeNode root) {
        String res="";
        if(root==null)
            return res;

        TreeNode ptr=root;
        StringBuilder sb=new StringBuilder();
        StringBuilder searilize = doPreorderTraversalBST(ptr, sb);
        System.out.println(searilize);
       return searilize.toString();
    }

    private StringBuilder doPreorderTraversalBST(TreeNode ptr,StringBuilder sb){
        if(ptr==null)
            return sb;
            sb.append(ptr.val+",");
        sb=doPreorderTraversalBST(ptr.left,sb);
        sb=doPreorderTraversalBST(ptr.right,sb);
        return sb;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if(data.isEmpty())
          return null;
        String[] preOrderArray = data.split(",");
        System.out.println("Char Array is "+ Arrays.toString(preOrderArray));
        TreeNode treeNode = constructBSTFromPreOrder(preOrderArray);
        return treeNode;
    }

    private TreeNode constructBSTFromPreOrder(String[] preorder){
        TreeNode root=new TreeNode(Integer.parseInt(preorder[0]));
        TreeNode ptr=root;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(new TreeNode(Integer.MAX_VALUE));
        int i=1;
        while (i<preorder.length){
            TreeNode node=new TreeNode(Integer.parseInt(preorder[i]));
            if(node.val<ptr.val) {
                ptr.left = node;
                stack.push(ptr);
                ptr=ptr.left;
                i++;
            }
            else {
                //it has to go right node of ptr
                if(node.val>ptr.val && node.val<stack.peek().val) {
                    ptr.right = node;
                    ptr = ptr.right;
                    i++;
                }
                else{
                    ptr=stack.pop();
                }
            }
        }
        return root;
    }

    private static void printBSTPreOrder(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        printBSTPreOrder(root.left);
        printBSTPreOrder(root.right);
    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(42);
        treeNode.left=new TreeNode(31);
        treeNode.right=new TreeNode(53);
        treeNode.right.right=new TreeNode(65);
        BSTSearialsize bstSearialsize=new BSTSearialsize();
        String serialize = bstSearialsize.serialize(treeNode);
        TreeNode deserialize = bstSearialsize.deserialize(serialize);
        System.out.println("Desearilized result: ");
        printBSTPreOrder(deserialize);

    }
}
