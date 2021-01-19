package string;

public class LongestPalindromicSubString {

    /**
     *
     * Given a string s, return the longest palindromic substring in s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     * Example 3:
     *
     * Input: s = "a"
     * Output: "a"
     *
     * */

    public static String longestPalindrome(String s) {
        int n=s.length();
        int start=0;
        int end=0;
        for (int i = 0; i <n ; i++) {
            int len1=extendFromMiddle(s,i,i);
            int len2=extendFromMiddle(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start) {
                start = i - (len - 1) / 2;
                end=i+(len/2);
            }
        }

        return s.substring(start,end+1);
    }

    private static int extendFromMiddle(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }


    public static void main(String[] args) {

        String s="cbbd";
        /*int i = extendFromMiddle(s, 0, 1);*/
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
    }
}
