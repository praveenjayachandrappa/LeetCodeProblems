package string;

import java.util.HashMap;

/**
 * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is less than or equal to k
 * Example 1:
 *
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 105
 *
 *
 */


public class LongestSubStringWithAtLeastKRepeatingCharacters {
    /*public static int longestSubstring(String s, int k) {
        int n=s.length();
        if(n==0 || k>n) return 0;
        if(k<=1) return n;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int j=0;
        while(j<n && map.get(s.charAt(j))>=k){
            j++;
        }
        /////////////////////////////
        if(j>=n-1) return j;
        int l1=longestSubstring(s.substring(0,j),k);
        while(j<n && map.get(s.charAt(j))<k)j++;
        int l2=(j<n)?longestSubstring(s.substring(j),k):0;
        return Math.max(l1,l2);
    }*/
    public  static int longestSubstring(String s, int k) {

        int n=s.length();

        if(n==0 || k>=n)
            return 0;
        if(k<=1)
            return n;

        HashMap<Character,Integer> map=new HashMap();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int i=0;

        while(i<n && map.get(s.charAt(i))>=k){
            i++;
        }

        if(i>=n-1)
            return i;

        int l1=longestSubstring(s.substring(0,i),k);
        while(i<n && map.get(s.charAt(i))<k){
            i++;
        }
        int l2=(i<n)?longestSubstring(s.substring(i),k):0;

        System.out.println(l1);
        System.out.println(l2);

        return Math.max(l1,l2);

    }
    public static void main(String[] args) {

        String str="aaabb";
        int k=3;

        int longestSubstringLength = longestSubstring(str, k);
        System.out.println(longestSubstringLength);



    }



}
