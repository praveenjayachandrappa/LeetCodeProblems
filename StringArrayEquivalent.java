public class StringArrayEquivalent {


    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
/*

        String first="";
        for(String s:word1)
            first+=s;

        for(String s:word2){

            if(first.indexOf(s)<0)
                return false;
            else{
                int idx=first.indexOf(s);
                first=first.substring(s.length());
                 }
        }
        if(first.isEmpty())
            return true;
        else
            return false;

*/

        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        for(String str:word1){
            sb1.append(str);
        }

        for(String str:word2){
            sb2.append(str);
        }

        if(sb1.toString().equals(sb2.toString()))
            return true;

        return false;

    }

    public static void main(String[] args) {

        /*String[] word1={"abc","d","defg"};
        String[] word2={"abcddef"};
        */
        String[] word1={"ab","c"};
        String[] word2={"a","bc"};
        boolean b = arrayStringsAreEqual(word1, word2);
        System.out.println(b);
    }
}
