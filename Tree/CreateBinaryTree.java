package Tree;


import java.util.*;

class Pair{

     int key;
     int val;

     public Pair(int key, int val) {
         this.key = key;
         this.val = val;
     }

     public int getKey() {
         return key;
     }

     public int getVal(){
         return this.val;
     }

 }
public class CreateBinaryTree {

    TreeNode root=null;
    Queue<TreeNode> queue=new LinkedList<>();
    public void createBTree(int[] arr){
        if(this.root==null){
            root=new TreeNode(arr[0]);
            queue.add(root);
        }
        for (int i = 1; i <arr.length ; i+=2) {
            if(i+1<=arr.length-1)
            insertNode(arr[i],arr[i+1]);
            else
            insertNode(arr[i],-1);
        }
    }

    public TreeNode getRoot() {
        return this.root;
    }
    private void insertNode(int leftVal,int rightVal){
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(leftVal!=-1) {
                treeNode.left = new TreeNode(leftVal);
                queue.add(treeNode.left);
            }
            if(rightVal!=-1) {
                treeNode.right = new TreeNode(rightVal);
                queue.add(treeNode.right);
            }
            break;
        }
    }

    public void preOrder(TreeNode ptr){
        if(ptr==null)
            return;
        System.out.print(ptr.val+" ");
        preOrder(ptr.left);
        preOrder(ptr.right);
    }

    HashMap<Integer,List<Pair>> map=new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        dfs(root,0,0);
        Set<Integer> keySet = map.keySet();
        int min=Collections.min(keySet);
        int max=Collections.max(keySet);
        for (int i = min; i<=max; i++) {
            List<Pair> pairList = map.get(i);
            if(pairList.size()>1){
                Collections.sort(pairList, (p1, p2) -> {
                    //same row
                    if(p1.val==p2.val){
                        return p1.getKey()-p2.getKey();
                    }
                    else {
                        return p2.getVal() - p1.getVal();
                    }
                });
                List<Integer> list=new ArrayList<>();
                for (Pair p:pairList) {
                    list.add(p.getKey());
                }
                result.add(list);
            }
            else {
                List<Integer> list=new ArrayList<>();
                list.add(pairList.get(0).getKey());
                result.add(list);
            }

        }
        return result;
    }

    private void dfs(TreeNode root, int c, int r) {
        if(root==null)
            return;
        Pair pair=new Pair(root.val,r);
        if(map.containsKey(c)){
            List<Pair> pairList = map.get(c);
            pairList.add(pair);
            map.put(c,pairList);
        }
        else {
            List<Pair> list = new ArrayList<>();
            list.add(pair);
            map.put(c,list);
        }
        dfs(root.left,c-1,r-1);
        dfs(root.right,c+1,r-1);
    }

    int globalRes=0;
    public int sumRootToLeaf(TreeNode root) {
        getSum(root,new String());
        return globalRes;
    }

    private void getSum(TreeNode root, String res){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            globalRes+=Integer.parseInt(res+root.val,2);
            return;
        }
        res+=root.val;
        getSum(root.left,res);
        getSum(root.right,res);
    }

    public static void main(String[] args) {

        //int[] arr={3,9,20,-1,-1,15,17};
        //int[] arr={1,2,3,4,5,6,7,-1,-1,-1,-1,8,-1,-1,-1};
          //  int[] arr={1,2,3,4,5,6,7};
        int[] arr={1,0,1,0,1,0,1};
        CreateBinaryTree createBinaryTree=new CreateBinaryTree();
         createBinaryTree.createBTree(arr);
        createBinaryTree.preOrder(createBinaryTree.root);
        /*List<List<Integer>> result = createBinaryTree.verticalTraversal(createBinaryTree.root);
        System.out.println(result);


*/

        createBinaryTree.sumRootToLeaf(createBinaryTree.root);
        System.out.println(createBinaryTree.globalRes);

    }
}
