import javax.print.DocFlavor;
import java.util.Arrays;

public class Permutation {



    public static void printPermute(String s){
        char[] chars = s.toCharArray();
        permute(0,chars);
    }

    private static void permute(int st,char[] str){
        if(st==str.length){
            System.out.println(Arrays.toString(str));
        }
        for (int i = st; i <str.length ; i++) {
            swap(st,i,str);
            permute(st+1,str);
            swap(st,i,str); //back tracking
        }
    }

    private static void swap(int st, int i, char[] str) {
        char temp=str[st];
        str[st]=str[i];
        str[i]=temp;
    }

    public static void main(String[] args) {
        String str="abc";
        printPermute(str);
    }
}
