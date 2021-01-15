import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    /*public static boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map=new HashMap();
        String[] word=str.split("\\s");
        if(word.length>pattern.length()) return false;
        int i=0;
        for(i=0;i<pattern.length() && i<word.length;i++){
            char ch=pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(word[i])) return false;
            }
            else if(!map.containsKey(ch) && map.containsValue(word[i]))
                return false;
            else
                map.put(ch,word[i]);
        }
        if(i<pattern.length() && i==word.length) return false;
        return true;

    }
*/
    static HashMap<Character,String> map=new HashMap<>();
    static HashSet<String> set=new HashSet<>();
    public static boolean wordPattern(String pattern, String str){
        String[] words = str.split("\\s");
        if(pattern.length()!=words.length)
            return false;
        return findMatch(pattern,words,0);
    }
    private static boolean findMatch(String pattern,String[] words,int i){
        if(i>= pattern.length()) return true;
        if(map.containsKey(pattern.charAt(i))){
            if(!map.get(pattern.charAt(i)).equals(words[i]))
                return false;
        }
        else {
            if(set.contains(words[i])) return false;
            map.put(pattern.charAt(i),words[i]);
            set.add(words[i]);
        }
        return findMatch(pattern,words,i+1);
    }
    public static void main(String[] args) {
        /*String s="jquery";
        String pattern="jquery";*/
        String s="a";
        String pattern="a";
        boolean b = wordPattern(pattern, s);
        System.out.println(b);

        System.out.println(Integer.bitCount(5));
        Integer integer = Integer.getInteger("5");
        System.out.println(integer);
    }
}
