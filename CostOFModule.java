import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostOFModule {


    public static List<String> costsOfNodes(List<String> lines) {
        List<String> res=new ArrayList<>();

        int n=lines.size();

        List<Map<Character,List<Character>>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashMap<>());
        }

        for (int i = 0; i < n; i++) {
            String s = lines.get(i);
            s=s.replace(",","");
            Map<Character, List<Character>> characterListMap = adj.get(i);
            char key=s.charAt(0);
            for (int j = s.length()-1; j >0 ; j--) {
                List<Character> list = characterListMap.get(s.charAt(j));
                if(list==null) {
                    list = new ArrayList<>();
                    list.add(key);
                    characterListMap.put(s.charAt(j),list);
                }
                else{
                    List<Character> list1 = characterListMap.get(s.charAt(j));
                    list1.add(key);
                    characterListMap.put(s.charAt(j),list);
                }
            }
        }

        return null;
    }


    public static void main(String[] args) {

        String s="A,E,N,S";
        String s2="S,H,N";
        String s3="E,N";
        String s4="H";
        String s5="N";
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        List<String> list1 = costsOfNodes(list);

    }
}
