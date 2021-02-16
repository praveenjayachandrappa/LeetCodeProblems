package permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LetterCasePermutation {
    HashSet<String> res;
    public List<String> letterCasePermutation(String s) {

        if(s==null || s.isEmpty())
            return new ArrayList();


        res=new HashSet<>();

        findAllPermutation(s.toCharArray(),0);

        return new ArrayList<>(res);
    }


    private void findAllPermutation(char[] sarr,int start){

        if(start>=sarr.length){
            res.add(new String(sarr));
            return;
        }

        for(int i=start;i<sarr.length;i++){
            if(Character.isLetter(sarr[i])){
                if(Character.isUpperCase(sarr[i])){
                    sarr[i]=Character.toLowerCase(sarr[i]);
                    findAllPermutation(sarr,i+1);
                    sarr[i]=Character.toUpperCase(sarr[i]);
                }
                else{
                    sarr[i]=Character.toUpperCase(sarr[i]);
                    findAllPermutation(sarr,i+1);
                    sarr[i]=Character.toLowerCase(sarr[i]);
                }
            }
            else{
                findAllPermutation(sarr,i+1);
            }
        }
        if(!res.contains(new String(sarr)))
            res.add(new String(sarr));

    }

    public static void main(String[] args) {
        String s="a1b2";
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        List<String> list = letterCasePermutation.letterCasePermutation(s);

        list.stream().forEach(e-> System.out.println(e));

        //["a1b2","a1B2","A1b2","A1B2"]
    }
}
