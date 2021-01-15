package Tree;

public class PathSumCount {

    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        return pathSum(root.left,sum)+pathSum_includeRoot(root,sum)+pathSum(root.right,sum);
    }

    private int pathSum_includeRoot(TreeNode root,int sum){
        if(root==null)
            return 0;
        int res=0;
        if(root.val==sum) res++;
        res+=pathSum_includeRoot(root.left,sum-root.val);
        res+=pathSum_includeRoot(root.right,sum-root.val);
        return res;
    }

    public static void main(String[] args) {

        int[] arr={10,5,-3,3,2,-1,11,3,-2,-1,1};
        CreateBinaryTree createBinaryTree=new CreateBinaryTree();
        createBinaryTree.createBTree(arr);
        TreeNode root = createBinaryTree.getRoot();
        PathSumCount pathSumCount=new PathSumCount();
        int res = pathSumCount.pathSum(root, 8);
        System.out.println(res);
    }

}
