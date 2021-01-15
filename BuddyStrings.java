import java.util.Arrays;

public class BuddyStrings {
    public static boolean buddyStrings(String A, String B) {
        if(A.isEmpty() || B.isEmpty())
            return false;
        char[] copyA=A.toCharArray();
        char[] copyB=B.toCharArray();

        for(int i=0;i<A.length();i++){
            int idx=B.indexOf(A.charAt(i));
            if(i!=idx)
            {
                char temp=copyA[idx];
                copyA[idx]=copyA[i];
                copyA[i]=temp;
                String sa = String.valueOf(copyA);
                String sb=String.valueOf(copyB);
                if(sa.equals(sb))
                    return true;
            }

        }

        return  false;
    }

    public static void main(String[] args) {

        String A = "ab";
        String B="ba";
        boolean res= buddyStrings(A, B);
        System.out.println(res);
    }
}
