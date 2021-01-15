public class StringPermutations
{

    public  // Function to print all the permutations of str
    static void printPermutn(String str, String ans){

        if(str.length()==0){
            System.out.print(ans+" ");
            return;
        }

        for (int i = 0; i <str.length() ; i++) {
            char ch=str.charAt(i);
            String ros=str.substring(0,i)+str.substring(i+1);
            printPermutn(ros,ans+ch);
        }
    }


    static  void reverse(String str)
    {
        if ((str==null)||(str.length() <= 1))
            System.out.println(str);
        else
        {
            System.out.print(str.charAt(str.length()-1));
            reverse(str.substring(0,str.length()-1));
        }
    }
    public static String reverse2(String string,String rev){

        if (string.length()<=0){
            return rev;
            }
        else {
            rev+=string.charAt(string.length()-1);
            rev=reverse2(string.substring(0,string.length()-1),rev);
        }
        return rev;
    }
    public static void main(String[] args) {
        String string="bat";
     //   printPermutn(string,"");

        reverse(string);
        String s = reverse2(string, "");
        System.out.println(s);
    }
}
