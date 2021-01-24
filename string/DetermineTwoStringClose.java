package string;

import java.util.HashMap;
import java.util.Map;

public class DetermineTwoStringClose {


    /**
     * Input: word1 = "abc", word2 = "bca"
     * Output: true
     * Explanation: You can attain word2 from word1 in 2 operations.
     * Apply Operation 1: "abc" -> "acb"
     * Apply Operation 1: "acb" -> "bca"
     * Example 2:
     *
     * Input: word1 = "a", word2 = "aa"
     * Output: false
     * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
     * Example 3:
     *
     * Input: word1 = "cabbba", word2 = "abbccc"
     * Output: true
     * Explanation: You can attain word2 from word1 in 3 operations.
     * Apply Operation 1: "cabbba" -> "caabbb"
     * Apply Operation 2: "caabbb" -> "baaccc"
     * Apply Operation 2: "baaccc" -> "abbccc"
     * Example 4:
     *
     * Input: word1 = "cabbba", word2 = "aabbss"
     * Output: false
     * Explanation: It is impossible to attain word2 from word1, or vice versa, in any amount of operations.
     *
     *
     * Constraints:
     *
     * 1 <= word1.length, word2.length <= 105
     * word1 and word2 contain only lowercase English letters.
     */
    public static boolean closeStrings(String word1, String word2) {

        if(word1.length()!=word2.length())
            return false;


        int[] w1=new int[26];

        int[] w2=new int[26];



        for(char c:word1.toCharArray()){
            w1[c-'a']++;
        }

        for(char c:word2.toCharArray()){
            w2[c-'a']++;
        }


        for(int i=0;i<26;i++){
            if(w1[i]==0 && w2[i]!=0)
                return false;
            if(w2[i]==0 && w1[i]!=0)
                return false;

        }



        Map<Integer,Integer> map=new HashMap();


        for(int key:w1){

            if(key>0){
                map.put(key,map.getOrDefault(key,0)+1);
            }

        }


        for(int key:w2){

            if(key>0){

                if(!map.containsKey(key))
                    return false;
                map.put(key,map.get(key)-1);
                if(map.get(key)==0){
                    map.remove(key);
                }
            }
        }


        return map.size()==0?true:false;


        //TC-O(N);
        //SC-o(1);


/*

    Approach 2:
        Arrays.sort(w1);
        Arrays.sort(w2);

        return Arrays.equals(w1,w2);
*/

    }


    public static void main(String[] args) {

        String word1="abc";
        String word2="bca";
        boolean isclosed = closeStrings(word1, word2);

        System.out.println(isclosed);

    }
}
