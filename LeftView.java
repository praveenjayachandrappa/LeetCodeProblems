/*class LeftView{

    
    public static void printLeftView(TreeNode root){
    
    
           if(root==null)
           return;
           List<TreeNode> queue=new LinkedList();
           
              //System.out.println(root.val);
              queue.add(root);
              while(!queue.isEmpty()){
              int size=queue.size();
              while(size-->0){
               TreeNode p=queue.remove();
               System.out.println(p.val);
                  if(p.left!=null){
                      queue.add(p.left);
                    if(p.left==null && p.right!=null)
                    queue.add(p.right);
                   }
              }




}*/


