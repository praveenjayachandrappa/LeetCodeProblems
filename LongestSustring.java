import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class LongestSustring {
    public static int lengthOfLongestSubstring(String s) {
        Deque<Character> deque=new ArrayDeque<>();
        int res=0;
        int i=0;
        while (i<s.length()){
            if(!deque.contains(s.charAt(i))){
                deque.add(s.charAt(i));
                i++;
            }
            else {
                res=Math.max(res,deque.size());
                deque.removeFirst();
            }
        }
        res=Math.max(res,deque.size());
        return res;
    }


    public static void main(String[] args) {

        String s="pwwkew";

        int longestSubstring = lengthOfLongestSubstring(s);
        System.out.println(longestSubstring);
    }
}
