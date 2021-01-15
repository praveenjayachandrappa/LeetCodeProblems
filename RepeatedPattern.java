public class RepeatedPattern {

    public static  boolean repeatedSubstringPattern(String s) {
    /*    int n=s.length();
        for (int l = n/2; l >0; l--) {

            int i=0;
            while (i+l<n && s.charAt(i)==s.charAt(i+l)) {
                i++;
            }
            if(i+l==n)
                return true;
        }
        return false;
    */

    //Second Approach

/*
        String copyS=s+s;

        return copyS.substring(1,copyS.length()-1).contains(s);
*/

//3rd approach
        //return s.matches("([a-z]+)\\1+$");
    return false;
    }


    public static void main(String[] args) {

        //String str="abcabcabcabc";

        String str="aba";
        boolean b = repeatedSubstringPattern(str);
        System.out.println(b);

    }


}
