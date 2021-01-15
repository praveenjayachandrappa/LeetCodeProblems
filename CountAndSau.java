import java.util.*;

public class CountAndSau {

    public static String countAndSay(int n) {
/*
          String s="1";
        for(int i=1;i<n;i++){
            char c=s.charAt(0);
            int count=1;
            StringBuilder sb=new StringBuilder();
            for(int j=1;j<s.length();j++){

                if(c==s.charAt(j))
                    count++;
                else{
                    sb.append(count);
                    sb.append(c);
                    count=1;
                }
                c=s.charAt(j);
            }
            sb.append(count);
            sb.append(c);
            s=sb.toString();
        }
*/
        String s = "1";
        for (int i = 1; i <n ; i++) {
            s=decode(s);
        }
        return s;
    }

    private static String decode(String s) {

        StringBuilder stringBuilder=new StringBuilder();
        char prevChar=s.charAt(0);
        int count=0;
        for (char ch:s.toCharArray()) {
            if(prevChar==ch)
                count++;
            else{
                stringBuilder.append(count);
                stringBuilder.append(prevChar);
                prevChar=ch;
                count=1;
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(prevChar);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        String s = countAndSay(4);
        System.out.println(s);
    }

    class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            while (size-->0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            result.add(new ArrayList<>(temp));
        }

        return result;
        }


    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length==0) return null;
        //since array is sorted ,we can apply binary search to construct BST
        return constructBSTFromBinarySearch(nums,0,nums.length-1);

    }

    private TreeNode constructBSTFromBinarySearch(int[] nums, int low, int high) {
        if(low>high)
            return null;
        int mid=low+(high-low)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=constructBSTFromBinarySearch(nums,low,mid-1);
        node.right=constructBSTFromBinarySearch(nums,mid+1,high);
        return node;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true; //root is null the tree is symmetric

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()){

            //poll both children
            TreeNode node1=queue.poll();
            TreeNode node2=queue.poll();
            if(node1==null && node2==null)
                continue;
            if(node1==null || node2==null)
                return false;
            if(node1.val!= node2.val)
                return false;

            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }


}
