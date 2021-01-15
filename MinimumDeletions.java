public class MinimumDeletions {

    public int minimumDeletions(String s) {
        int n=s.length();
        int[] countArr=new int[n];
        countArr[n-1]=s.charAt(n-1)=='a'?1:0;
        for (int i = n-2; i >=0 ; i--) {
            countArr[i]=countArr[i+1]+(s.charAt(i)=='a'?1:0);
        }


            int result=Integer.MAX_VALUE;
            int bcount=0;
        for (int i = 0; i <n ; i++) {

            if(s.charAt(i)=='b'){
                result=Math.min(result,bcount+countArr[i]);
                bcount++;
            }
        }
        result=Math.min(result,bcount);

        return result==Integer.MAX_VALUE ?0:result;
    }

    public static void main(String[] args) {

        String s="bbaaaaaabb";

        //String s="aababbab";

        MinimumDeletions minimumDeletions=new MinimumDeletions();
        int res = minimumDeletions.minimumDeletions(s);
        System.out.println(res);




    }


}
