import java.util.LinkedHashMap;
import java.util.Map;

public class PrintDuplicatesInString {

    private static void  printFrequencyOfChar(String str){

        Map<Character,Integer> map=new LinkedHashMap<>();

        for (int i = 0; i <str.length(); i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            /*if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i)+1));
            }
            else {
                map.put(str.charAt(i),1);
            }*/
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(Character key:map.keySet()){
            stringBuilder.append(key);
            stringBuilder.append(map.get(key));
        }

        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {

        String strings = "hhhjjaavvttmcckkkk";

        //to find character wit count
        printFrequencyOfChar(strings);

    }
}
