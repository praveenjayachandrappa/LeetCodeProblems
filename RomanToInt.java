import java.util.HashMap;

public class RomanToInt {


    public int romanToInt(String s) {

        HashMap<Character,Integer> map=new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('D',500);
        map.put('C',100);
        map.put('M',1000);

        int res=0;
        for (int i = 0; i <s.length(); i++) {
            int v1=map.get(s.charAt(i));
            int v2=(i+1)<s.length()?map.get(s.charAt(i+1)):-1;
            if(v2>v1){
                res+=v2-v1;
                i++;
            }
            else
                res+=v1;
        }


        return res;

    }

    public static void main(String[] args) {

        //String s="III";
        String s="LVIII";
        RomanToInt romanToInt=new RomanToInt();
        int res= romanToInt.romanToInt(s);
        System.out.println(res);
    }
}
