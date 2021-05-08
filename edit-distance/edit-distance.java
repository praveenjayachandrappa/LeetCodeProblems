class Solution {
    /*
    public int minDistance(String word1, String word2) {
        
        return findMin(word1.length(),word2.length(),word1,word2);
    }
    
    Map<String,Integer> map=new HashMap();
    private int findMin(int m,int n,String s1,String s2){
        
        if(m==0)
            return n;
        if(n==0)
            return m;
        String key=m+"$"+n;
        
        if(map.containsKey(key))
            return map.get(key);
        if(s1.charAt(m-1)==s2.charAt(n-1)){
             int r=findMin(m-1,n-1,s1,s2);
            map.put(key,r);
            }
        else{
            //delete operation            
            int a=1+findMin(m-1,n,s1,s2);
            //replace operation
            int b=1+findMin(m-1,n-1,s1,s2);
            //insert operation
            int c=1+findMin(m,n-1,s1,s2);
            
             int r=Math.min(a,Math.min(b,c));
            
            map.put(key,r);
        }
    
        return map.get(key);
    }
    
    */
    
    
    public int minDistance(String word1, String word2) {
        
     
        
        return findMin(word1.length(),word2.length(),word1,word2);
        
        
    }
    
    
    
    
    HashMap<String,Integer> map=new HashMap();
    private int findMin(int m,int n,String word1,String word2){
        
        
        if(m==0)
            return n;
        
        if(n==0)
            return m;
        
        String key=m+"$"+n;
        
        
        if(map.containsKey(key))
            
            return map.get(key);
        
        if(word1.charAt(m-1)==word2.charAt(n-1)){
            
            
           int min=findMin(m-1,n-1,word1,word2);
            map.put(key,min);
        }
        
        else{
            
            
            //I have to perform threee operations
            
            //Delete operation
            
            int a=1+findMin(m-1,n,word1,word2);
            
            //Replace Operation
            int b=1+findMin(m-1,n-1,word1,word2);
            
            //Insert operation
            
            int c=1+findMin(m,n-1,word1,word2);
            
            int min=Math.min(a,Math.min(b,c));
            
            map.put(key,min);
        
        }
        
        return map.get(key);
    }
    
    
    
    
    
    
}