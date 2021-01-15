package unicodes;

import java.util.HashMap;

class Solution {
        //key=element & value=Index
    int index;
    public String largestTimeFromDigits(int[] arr) {
       String res="";
       int f=check(arr,2);
       if(f==-1) return "";
       arr[this.index]=-1;
        int f2=check(arr,3);
        if(f2==-1)
            return "";
        arr[this.index]=-1;
        int f3=check(arr,5);
        if(f3==-1)
            return "";
        arr[this.index]=-1;
        int f4=check(arr,9);
        if(f4==-1)
            return "";
        res+=Integer.toString(f)+Integer.toString(f2)+":"+Integer.toString(f3)+Integer.toString(f4);
        
        return res;
        
    }
    private int check(int[] arr,int max){
        int res=-1;
        int index=0;
        for(int i=0;i<arr.length;i++){
          int x=arr[i];
           if(x!=-1 && x<=max)
           {        if(res<x) {
                   res = Math.max(x, res);
                    index = i;
           }

           }
        }
            
        if(res==-1)
            return -1;
        else {
            this.index=index;
            return res;
        }
    }

    public static void main(String[] args) {

        int[] arr={0,4,0,0};
        String res = new Solution().largestTimeFromDigits(arr);
        System.out.println(res);
    }
}