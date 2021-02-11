package string;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    /**
     *
     *
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     * Note:
     * You may assume the string contains only lowercase alphabets.
     */

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] sarr=s.toCharArray();
        char[] tarr=s.toCharArray();
        /*
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return Arrays.equals(sarr,tarr);
        */
        int[] carr=new int[26];
        for (int i = 0; i < sarr.length ; i++) {
            carr[sarr[i]-'a']++;
        }

        for (int i = 0; i < tarr.length ; i++) {
            carr[tarr[i]-'a']--;
        }

        for (int i = 0; i <carr.length ; i++) {

            if(carr[i]!=0)
                return false;
        }

        return true;
    }


    public static void main(String[] args) {


        String s="abc";
        String t = "cba";

        System.out.println(isAnagram(s,t));
    }
}
