import java.util.HashSet;

public class SplitString {


    public int maxUniqueSplit(String s) {

        return helper(s,new HashSet<String>(),1);
    }

    private int helper(String s, HashSet<String> set,int idx) {
        /*int max=0;
        for (int i = 1; i <=s.length() ; i++) {
            String sub=s.substring(0,i);
            if(!set.contains(sub)) {
                set.add(sub);
                max=Math.max(max,1+helper(s.substring(i),set));
            }

        }*/
        /*return max;*/
        int max=0;
        if(s.isEmpty() || idx>s.length())
            return max;
        else {
            String sub = s.substring(0, idx);
            if (!set.contains(sub)) {
                set.add(sub);
             max=Math.max(max,1+ helper(s.substring(idx),set,1));
            }
            return helper(s,set,idx+1);
        }

    }

    public static void main(String[] args) {

        String s="ababccc";
        System.out.println(new SplitString().maxUniqueSplit(s));
    }
}