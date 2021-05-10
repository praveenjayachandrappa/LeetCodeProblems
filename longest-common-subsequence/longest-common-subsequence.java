class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        
          dp=new int[text1.length()][text2.length()];
        
        for(int i=0;i<text1.length();i++){
            
            for(int j=0;j<text2.length();j++){
                
                dp[i][j]=-1;
            }
            
        }
        return helper(0,0,text1,text2);
    
    }
    
    
    private int helper(int m,int n,String s1,String s2){
        
        
        if(m==s1.length()|| n==s2.length())
            return 0;
        
        
        if(dp[m][n]>=0)
            return dp[m][n];
        
        if(s1.charAt(m)==s2.charAt(n)){
            
            dp[m][n]=1+helper(m+1,n+1,s1,s2);
            
            //return 1+helper(m+1,n+1,s1,s2);
        }
        
        else{
            
             dp[m][n]=Math.max(helper(m+1,n,s1,s2),helper(m,n+1,s1,s2));
        }
        
        return dp[m][n];
    }
}