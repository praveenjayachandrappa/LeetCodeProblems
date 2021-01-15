import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNASubsequence {


    public static List<String> findRepeatedDnaSequences(String s) {

        Map<String,Integer> map=new HashMap<>();

        for (int i = 0; i <s.length()-9; i++) {
            String dna=s.substring(i,i+10);
            map.put(dna,map.getOrDefault(dna,0)+1);
        }
        List<String> list=new ArrayList<>();
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                list.add(entry.getKey());
            }
        }
// return map.entrySet().stream().filter(e->e.getValue()>1).map(e->e.getKey()).collect(Collectors.toList());
//
        return list;
    }


    public static void  printLength(String str){

        for (int i = 0; i <=str.length()-4; i++) {
            System.out.println(str.substring(i,i+4));
        }

    }
    public static void main(String[] args) {

/*
        String string="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        List<String> repeatedDnaSequences = findRepeatedDnaSequences(string);

        System.out.println(repeatedDnaSequences.toString());
    */

        String str="abcdef";

        printLength(str);

    }


}
