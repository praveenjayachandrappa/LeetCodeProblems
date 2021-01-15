import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {

    static HashMap<String,List<String>> map=new HashMap<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
            List<String> result=new ArrayList<>();
        if(map.containsKey(s))
            return map.get(s);
        if(wordDict.contains(s)){
            result.add(s);
        }
        for (int i = 1; i <=s.length() ; i++) {
            String left=s.substring(0,i);
            if(wordDict.contains(left)){
                List<String> subList = wordBreak(s.substring(left.length()), wordDict);
                for (String t:subList) {
                    result.add(left+" "+t);
                }
            }
        }
        map.put(s,result);
        return result;
    }

    public List<String> wordBreak2(String s,List<String> wordDict){
        List<String> result=new ArrayList<>();
        for (String word:wordDict) {
            if (s.startsWith(word)) {
                if (s.equals(word)) {
                    result.add(word);
                }
                else {
                    List<String> subList = wordBreak2(s.substring(s.length()), wordDict);
                    for (String str:subList) {
                        result.add(word+" "+str);
                    }
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {

       String s = "catsanddog";

     //  String s="aaa";
       // List<String> wordDict = Arrays.asList(new String[]{"a", "aa"});
        //ist<String> list = wordBreak(s, wordDict);

        //System.out.println(list);
    }
}
